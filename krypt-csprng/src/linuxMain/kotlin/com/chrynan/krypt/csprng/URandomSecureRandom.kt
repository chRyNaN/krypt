package com.chrynan.krypt.csprng

import kotlinx.cinterop.*
import kotlin.native.concurrent.AtomicInt
import platform.posix.*

/**
 * Helper for:
 *  - Ensuring /dev/random has been seeded
 *  - Obtaining bytes from /dev/urandom
 *
 * Polling of /dev/random via [ensureSeeded] is always called
 * to ensure that no data is read from /dev/urandom until there
 * is adequate randomness generated. [ensureSeeded] only ever
 * polls /dev/random once, afterwhich it does nothing.
 *
 * @see [readBytesTo]
 * */
internal object URandom : AbstractSecureRandom() {

    private const val INFINITE_TIMEOUT = -1

    private val lock = Lock()

    @OptIn(ExperimentalForeignApi::class)
    override fun nextBytes(array: ByteArray, fromIndex: Int, toIndex: Int): ByteArray {
        array.usePinned {
            readBytesTo(buffer = it, bufferLength = array.size)
        }

        return array.copyOfRange(fromIndex = fromIndex, toIndex = toIndex)
    }

    /**
     * Reads bytes from /dev/urandom of specified [bufferLength] into [buffer].
     *
     * @see [withReadOnlyFD]
     * @see [fillCompletely]
     * */
    @OptIn(ExperimentalForeignApi::class)
    private fun readBytesTo(buffer: Pinned<ByteArray>, bufferLength: Int) {
        ensureSeeded()

        lock.withLock {
            withReadOnlyFD("/dev/urandom") { fd ->
                buffer.fillCompletely(bufferLength) { ptr, length ->
                    read(fd, ptr, length.toULong().convert()).convert()
                }
            }
        }
    }

    /**
     * Polls /dev/random once and only once to ensure /dev/urandom
     * is ready to read from.
     * */
    @OptIn(ExperimentalForeignApi::class)
    private fun ensureSeeded() {
        // Will only ever be invoked once
        withReadOnlyFD("/dev/random") { fd ->
            memScoped {
                val pollFd = nativeHeap.alloc<pollfd>()

                pollFd.apply {
                    this.fd = fd
                    events = POLLIN.convert()
                    revents = 0
                }

                while (true) {
                    val result = poll(pollFd.ptr, 1u, INFINITE_TIMEOUT)

                    if (result >= 0) {
                        break
                    }

                    when (val err = errno) {
                        EINTR,
                        EAGAIN -> continue

                        else -> nativeError(err)
                    }
                }
            }
        }

    }

    /**
     * Opens the file descriptor for [path] and then closes
     * it once [block] completes.
     * */
    private fun withReadOnlyFD(path: String, block: (fd: Int) -> Unit) {
        val fd = open(path, O_RDONLY, null)
        if (fd == -1) nativeError(errno)

        try {
            block.invoke(fd)
        } finally {
            close(fd)
        }
    }
}

private class Lock {

    // 0: Unlocked
    // *: Locked
    private val lock = AtomicInt(0)

    fun <T> withLock(block: () -> T): T {
        val lockId = Any().hashCode()

        try {
            while (true) {
                if (lock.compareAndSet(0, lockId)) {
                    break
                }
            }

            return block.invoke()
        } finally {
            lock.compareAndSet(lockId, 0)
        }
    }
}
