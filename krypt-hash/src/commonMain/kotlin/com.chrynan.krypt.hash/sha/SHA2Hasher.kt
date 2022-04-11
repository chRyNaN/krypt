@file:Suppress("unused")

package com.chrynan.krypt.hash.sha

import com.chrynan.krypt.hash.ByteHasher
import com.chrynan.krypt.hash.HashResult
import com.chrynan.krypt.hash.Hasher

/**
 * A [ByteHasher] that uses one of the variants of the SHA-2 algorithm. To create an instance of this class, use one of
 * the factory functions, such as [sha256].
 *
 * @see [sha256]
 * @see [SHA2HashFunction]
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
 */
interface SHA2Hasher : ByteHasher<SHA2HashFunction.SupportedAlgorithm, SHA2HashResult> {

    companion object
}

class SHA2HashResult internal constructor(
    override val algorithm: SHA2HashFunction.SupportedAlgorithm,
    override val hash: ByteArray
) : HashResult<SHA2HashFunction.SupportedAlgorithm, ByteArray> {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as SHA2HashResult

        if (algorithm != other.algorithm) return false
        if (!hash.contentEquals(other.hash)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = algorithm.hashCode()
        result = 31 * result + hash.contentHashCode()
        return result
    }

    override fun toString(): String = "SHA2HashResult(algorithm=$algorithm,hash=REDACTED)"
}

/**
 * Implementation of the [SHA2Hasher] interface.
 */
internal class SHA2HasherImpl(
    override val algorithm: SHA2HashFunction.SupportedAlgorithm
) : SHA2Hasher {

    private val hashFunction = SHA2HashFunction(algorithm = algorithm)

    override suspend fun invoke(source: ByteArray): SHA2HashResult {
        val hash = hashFunction.invoke(source = source)

        return SHA2HashResult(
            algorithm = algorithm,
            hash = hash
        )
    }
}

/**
 * Creates a [SHA2Hasher] for the SHA-2 224 hashing algorithm.
 *
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
 */
fun Hasher.Companion.sha224(): SHA2Hasher = SHA2HasherImpl(algorithm = SHA2HashFunction.SupportedAlgorithm.SHA_224)

/**
 * Creates a [SHA2Hasher] for the SHA-2 256 hashing algorithm.
 *
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
 */
fun Hasher.Companion.sha256(): SHA2Hasher = SHA2HasherImpl(algorithm = SHA2HashFunction.SupportedAlgorithm.SHA_256)

/**
 * Creates a [SHA2Hasher] for the SHA-2 384 hashing algorithm.
 *
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
 */
fun Hasher.Companion.sha384(): SHA2Hasher = SHA2HasherImpl(algorithm = SHA2HashFunction.SupportedAlgorithm.SHA_224)

/**
 * Creates a [SHA2Hasher] for the SHA-2 512 hashing algorithm.
 *
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
 */
fun Hasher.Companion.sha512(): SHA2Hasher = SHA2HasherImpl(algorithm = SHA2HashFunction.SupportedAlgorithm.SHA_256)
