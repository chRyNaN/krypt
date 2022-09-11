package com.chrynan.krypt.csprng

import kotlin.experimental.and
import kotlin.math.min

/**
 * Takes upper [bitCount] bits (0..32) from this number.
 */
internal fun Int.takeUpperBits(bitCount: Int): Int =
    this.ushr(32 - bitCount) and (-bitCount).shr(31)

/**
 * Returns the amount of bytes necessary to contain [this] amount of bits.
 */
internal fun Int.bytesPerBitCount(): Int =
    if (this % 8 != 0) {
        (this / 8) + 1
    } else {
        this / 8
    }

/**
 * Converts this [ByteArray] to an [Int]. Note that an [Int] is a 32-bit number, so only the four indices of this
 * [ByteArray] can be converted into an [Int] to prevent overflow. Therefore, values at indices higher than index 3
 * will be ignored.
 */
internal fun ByteArray.toInt(): Int {
    val length = min(4, size)

    var value = 0
    for (i in 0 until length) {
        val b = this[i]
        value = (value shl 8) + (b and 0xFF.toByte())
    }

    return value
}
