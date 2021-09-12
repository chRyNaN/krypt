@file:Suppress("unused")

package com.chrynan.auth.core

import java.lang.StringBuilder
import java.security.SecureRandom
import com.benasher44.uuid.Uuid

/**
 * A cryptographically strong random number generator.
 */
expect class SecureRandom {

    fun nextBoolean(): Boolean

    fun nextInt(): Int

    fun nextInt(bound: Int): Int

    fun nextLong(): Long

    fun nextBytes(bytes: ByteArray)

    fun nextFloat(): Float

    fun nextDouble(): Double

    fun nextGaussian(): Double
}

expect fun SecureRandom(algorithmName: String? = null): SecureRandom

fun SecureRandom.nextChar(characters: CharArray = ALPHA_NUMERIC_CHARS): Char {
    val index = nextInt(characters.size)
    return characters[index]
}

fun SecureRandom.nextString(length: Int, characters: CharArray = ALPHA_NUMERIC_CHARS): String {
    val stringBuilder = StringBuilder()
    for (i in 0..length) {
        stringBuilder.append(nextChar(characters = characters))
    }
    return stringBuilder.toString()
}

expect fun SecureRandom.nextUuid(): Uuid
