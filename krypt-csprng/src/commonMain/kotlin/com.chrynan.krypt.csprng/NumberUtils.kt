package com.chrynan.krypt.csprng

import kotlin.random.Random

/**
 * Takes upper [bitCount] bits (0..32) from this number.
 *
 * **Note:** This is taken from the Kotlin [Random] implementation.
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
