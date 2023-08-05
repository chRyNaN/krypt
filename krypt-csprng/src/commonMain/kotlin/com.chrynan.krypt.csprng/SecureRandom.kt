@file:Suppress("unused")

package com.chrynan.krypt.csprng

import com.chrynan.krypt.core.toInt
import kotlin.random.Random

/**
 * The base class of all [SecureRandom] implementations.
 *
 * @see [SecureRandom] for more details.
 */
abstract class AbstractSecureRandom internal constructor() : Random() {

    final override fun nextBits(bitCount: Int): Int {
        require(bitCount in 0..32) { "'bitCount' property must be in the range 0 to 32." }

        if (bitCount == 0) return 0

        val bytes = nextBytes(array = ByteArray(size = bitCount))

        return bytes.toInt().takeUpperBits(bitCount)
    }

    abstract override fun nextBytes(array: ByteArray, fromIndex: Int, toIndex: Int): ByteArray
}

/**
 * A cryptographically strong pseudo-random number generator (CSPRNG) which implements the [Random] abstract class.
 * This class should be suitable for use in cryptography.
 *
 * **Note:** that [SecureRandom] implementations are not guaranteed to be thread safe. It is up to the call-site to use
 * it in a thread safe manner.
 *
 * ## Implementation Highlights
 *
 * ### JVM and Android:
 * [java.security.SecureRandom class](https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html)
 *
 * ### JS:
 * [Crypto.getRandomValues](https://developer.mozilla.org/en-US/docs/Web/API/Crypto/getRandomValues)
 *
 * ### iOS and Mac:
 * [SecureRandomCopyBytes](https://developer.apple.com/documentation/security/1399291-secrandomcopybytes)
 *
 * ### Windows:
 * [bcryptgenrandom](https://learn.microsoft.com/en-us/windows/win32/api/bcrypt/nf-bcrypt-bcryptgenrandom)
 *
 * ### Linux:
 * [getrandom](https://man7.org/linux/man-pages/man2/getrandom.2.html) / `/dev/urandom`
 *
 * @see [Wikipedia explanation](https://en.wikipedia.org/wiki/Cryptographically-secure_pseudorandom_number_generator)
 */
expect class SecureRandom() : AbstractSecureRandom {

    override fun nextBytes(array: ByteArray, fromIndex: Int, toIndex: Int): ByteArray

    companion object
}
