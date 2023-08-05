@file:Suppress("unused")

package com.chrynan.krypt.hash.sha

import com.chrynan.krypt.hash.HashResult
import com.chrynan.krypt.hash.Hasher

/**
 * A [Hasher] that uses one of the variants of the SHA-2 algorithm. To create an instance of this class, use one of
 * the factory functions, such as [sha256].
 *
 * @see [sha256]
 * @see [SHA2HashFunction]
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
 */
class SHA2Hasher internal constructor(
    override val algorithm: SHA2HashFunction.SupportedAlgorithm
) : Hasher<SHA2HashFunction.SupportedAlgorithm, SHA2HashResult> {

    private val hashFunction = SHA2HashFunction(algorithm = algorithm)

    override suspend fun invoke(source: ByteArray): SHA2HashResult {
        val hash = hashFunction.invoke(source = source)

        return SHA2HashResult(
            algorithm = algorithm,
            hash = hash
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SHA2Hasher) return false

        if (algorithm != other.algorithm) return false

        return hashFunction == other.hashFunction
    }

    override fun hashCode(): Int {
        var result = algorithm.hashCode()
        result = 31 * result + hashFunction.hashCode()
        return result
    }

    override fun toString(): String =
        "SHA2Hasher(algorithm=$algorithm, hashFunction=$hashFunction)"
}

/**
 * Creates a [SHA2Hasher] for the SHA-2 224 hashing algorithm.
 *
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
 */
fun Hasher.Companion.sha224(): SHA2Hasher = SHA2Hasher(algorithm = SHA2HashFunction.SupportedAlgorithm.Sha224)

/**
 * Creates a [SHA2Hasher] for the SHA-2 256 hashing algorithm.
 *
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
 */
fun Hasher.Companion.sha256(): SHA2Hasher = SHA2Hasher(algorithm = SHA2HashFunction.SupportedAlgorithm.Sha256)

/**
 * Creates a [SHA2Hasher] for the SHA-2 384 hashing algorithm.
 *
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
 */
fun Hasher.Companion.sha384(): SHA2Hasher = SHA2Hasher(algorithm = SHA2HashFunction.SupportedAlgorithm.Sha384)

/**
 * Creates a [SHA2Hasher] for the SHA-2 512 hashing algorithm.
 *
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
 */
fun Hasher.Companion.sha512(): SHA2Hasher = SHA2Hasher(algorithm = SHA2HashFunction.SupportedAlgorithm.Sha512)
