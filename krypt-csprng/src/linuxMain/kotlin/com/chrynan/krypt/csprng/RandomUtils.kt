package com.chrynan.krypt.csprng

import kotlinx.cinterop.*
import platform.posix.EINTR
import platform.posix.errno
import platform.posix.strerror

/**
 * [GetRandom.getrandom] and [URandom.readBytesTo] return
 * values (if positive) indicate the number of bytes that were
 * put into the [ByteArray]. If it is less than the [size],
 * this ensures that the call is repeated until it has been
 * completely filled.
 * */
@OptIn(ExperimentalForeignApi::class)
internal inline fun Pinned<ByteArray>.fillCompletely(
    size: Int,
    block: (ptr: CPointer<ByteVar>, length: Int) -> Int
) {
    var index = 0
    while (index < size) {

        val remainder = size - index
        val result = block.invoke(addressOf(index), remainder)

        if (result < 0) {
            when (val err = errno) {
                EINTR -> continue // Retry
                else -> nativeError(err)
            }
        } else {
            index += result
        }
    }
}

@OptIn(ExperimentalForeignApi::class)
internal inline fun nativeError(err: Int): Nothing =
    error(strerror(err)?.toKStringFromUtf8() ?: "errno: $err")
