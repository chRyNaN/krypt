@file:Suppress("unused")

package com.chrynan.krypt.csprng

import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuidOf
import com.chrynan.krypt.core.SecureString
import kotlin.experimental.and
import kotlin.experimental.or
import kotlin.random.Random

private const val ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
private val ALPHA_NUMERIC_CHARS = ALPHA_NUMERIC_STRING.toCharArray()

/**
 * A cryptographically strong pseudo-random number generator (CSPRNG) which implements the [Random] interface.
 */
expect class SecureRandom constructor() : Random {

    override fun nextBits(bitCount: Int): Int

    companion object
}

fun SecureRandom.nextChar(characters: CharArray = ALPHA_NUMERIC_CHARS): Char {
    val index = nextInt(characters.size)
    return characters[index]
}

fun SecureRandom.nextCharArray(length: Int, characters: CharArray = ALPHA_NUMERIC_CHARS): CharArray {
    val charArray = CharArray(length)
    for (i in 0..length) {
        charArray[i] = nextChar(characters = characters)
    }
    return charArray
}

fun SecureRandom.nextString(length: Int, characters: CharArray = ALPHA_NUMERIC_CHARS): String {
    val stringBuilder = StringBuilder()
    stringBuilder.append(nextCharArray(length = length, characters = characters).concatToString())
    return stringBuilder.toString()
}

fun SecureRandom.nextSecureString(length: Int, characters: CharArray = ALPHA_NUMERIC_CHARS): SecureString {
    val charArray = nextCharArray(length = length, characters = characters)
    return SecureString(chars = charArray, eraseSource = true)
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
 * Retrieves a [ByteArray] from this [SecureRandom] to be used as a salt, which is typically used when hashing
 * passwords. This is a convenience function which delegates to the [SecureRandom.nextBytes] function.
 *
 * @param [byteCount] The size of the returned [ByteArray].
 */
fun SecureRandom.nextSalt(byteCount: Int = 16): ByteArray = nextBytes(byteCount)