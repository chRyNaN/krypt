@file:Suppress("unused")

package com.chrynan.auth.csprng

import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuidOf
import kotlin.experimental.and
import kotlin.experimental.or
import kotlin.random.Random

private const val ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
private val ALPHA_NUMERIC_CHARS = ALPHA_NUMERIC_STRING.toCharArray()

/**
 * A cryptographically strong pseudo-random number generator (CSPRNG).
 */
expect class SecureRandom constructor() : Random {

    override fun nextBits(bitCount: Int): Int

    companion object
}

fun SecureRandom.nextChar(characters: CharArray = ALPHA_NUMERIC_CHARS): Char {
    val index = nextInt(characters.size)
    return characters[index]
}

fun SecureRandom.nextString(length: Int, characters: CharArray = ALPHA_NUMERIC_CHARS): String {
    val stringBuilder = StringBuilder()
    for (i in 0..length) {
        stringBuilder.append(nextChar(characters = characters))
    }
    Random.nextBoolean()
    return stringBuilder.toString()
}

fun SecureRandom.nextUuid(): Uuid {
    var randomBytes = ByteArray(16)
    randomBytes = nextBytes(randomBytes)

    randomBytes[6] = randomBytes[6] and 0x0f /* clear version        */
    randomBytes[6] = randomBytes[6] or 0x40 /* set to version 4     */
    randomBytes[8] = randomBytes[8] and 0x3f /* clear variant        */
    randomBytes[8] = randomBytes[8] or 0x80.toByte() /* set to IETF variant  */

    return uuidOf(randomBytes)
}

/**
 * Takes upper [bitCount] bits (0..32) from this number.
 */
internal fun Int.takeUpperBits(bitCount: Int): Int =
    this.ushr(32 - bitCount) and (-bitCount).shr(31)
