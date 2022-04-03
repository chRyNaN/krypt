@file:Suppress("unused")

package com.chrynan.krypt.csprng

import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuidOf
import com.chrynan.krypt.core.SecureString
import kotlin.experimental.and
import kotlin.experimental.or
import kotlin.random.Random

/**
 * A cryptographically strong pseudo-random number generator (CSPRNG) which implements the [Random] interface. This
 * class should be suitable for use in cryptography.
 *
 * On the JVM and Android, this delegates to the
 * [java.security.SecureRandom class](https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html).
 *
 * For JS, this uses the
 * [Crypto.getRandomValues](https://developer.mozilla.org/en-US/docs/Web/API/Crypto/getRandomValues) function to
 * generate cryptographically strong random data.
 *
 * And for iOS, this uses the
 * [SecureRandomCopyBytes](https://developer.apple.com/documentation/security/1399291-secrandomcopybytes) function to
 * generate cryptographically strong random data.
 *
 * @see [Wikipedia explanation](https://en.wikipedia.org/wiki/Cryptographically-secure_pseudorandom_number_generator)
 */
expect class SecureRandom constructor() : Random {

    override fun nextBits(bitCount: Int): Int

    companion object
}

/**
 * Gets the next random [SecureString] with the provided [length] and supported [characters].
 */
fun SecureRandom.nextSecureString(length: Int, characters: CharArray = ALPHA_NUMERIC_CHARS): SecureString {
    val charArray = nextCharArray(length = length, characters = characters)
    return SecureString(chars = charArray, eraseSource = true)
}

/**
 * Gets the next random [Uuid].
 */
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
