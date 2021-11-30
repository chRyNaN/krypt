@file:Suppress("unused")

package com.chrynan.auth.csprng

import com.benasher44.uuid.Uuid

private const val ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
private val ALPHA_NUMERIC_CHARS = ALPHA_NUMERIC_STRING.toCharArray()

/**
 * A cryptographically strong pseudo-random number generator (CSPRNG).
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

    fun generateSeed(numBytes: Int): ByteArray

    companion object
}

expect fun SecureRandom(): SecureRandom

expect fun SecureRandom.nextUuid(): Uuid

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
