package com.chrynan.krypt.csprng

import kotlinx.cinterop.*
import platform.posix.*

/**
 * An [AbstractSecureRandom] implementation that uses the
 * [getrandom](https://man7.org/linux/man-pages/man2/getrandom.2.html) function which uses the syscall to obtain random
 * data from /dev/urandom.
 *
 * Must always check that [isAvailable] returns `true` before using this implementation.
 *
 * @see [isAvailable]
 * @see [getrandom]
 * */
internal object GetRandomSecureRandom : AbstractSecureRandom() {

    private const val NO_FLAGS: UInt = 0U

    // https://docs.piston.rs/dev_menu/libc/constant.SYS_getrandom.html
    private const val SYS_getrandom: Long = 318L

    // https://docs.piston.rs/dev_menu/libc/constant.GRND_NONBLOCK.html
    private const val GRND_NONBLOCK: UInt = 0x0001U

    @OptIn(ExperimentalForeignApi::class)
    override fun nextBytes(array: ByteArray, fromIndex: Int, toIndex: Int): ByteArray {
        array.usePinned {
            getrandom(buffer = it, bufferLength = array.size)
        }

        return array.copyOfRange(fromIndex = fromIndex, toIndex = toIndex)
    }

    /**
     * Performs a non-blocking check via [syscall] to check
     * availability of [getrandom] on the system.
     * */
    @OptIn(ExperimentalForeignApi::class)
    internal fun isAvailable(): Boolean {
        val buf = ByteArray(1)
        buf.usePinned { pinned ->
            val result = getrandom(pinned.addressOf(0), buf.size.toULong().convert(), GRND_NONBLOCK)

            return if (result < 0) {
                when (errno) {
                    ENOSYS, // No kernel support
                    EPERM, // Blocked by seccomp
                    -> false

                    else -> true
                }
            } else {
                true
            }
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun getrandom(buffer: Pinned<ByteArray>, bufferLength: Int) {
        buffer.fillCompletely(bufferLength) { ptr, len ->
            getrandom(pointer = ptr, pointerLength = len.toULong().convert(), flags = NO_FLAGS)
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun getrandom(
        pointer: CPointer<ByteVar>,
        pointerLength: size_t,
        flags: u_int,
    ): Int = syscall(SYS_getrandom.convert(), pointer, pointerLength, flags).convert()
}
