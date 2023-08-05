package com.chrynan.krypt.hash.sha

import com.chrynan.krypt.hash.HashResult

/**
 * The [HashResult] from the [SHA2Hasher].
 */
class SHA2HashResult internal constructor(
    override val algorithm: SHA2HashFunction.SupportedAlgorithm,
    override val hash: ByteArray
) : HashResult<SHA2HashFunction.SupportedAlgorithm> {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as SHA2HashResult

        if (algorithm != other.algorithm) return false

        return hash.contentEquals(other.hash)
    }

    override fun hashCode(): Int {
        var result = algorithm.hashCode()
        result = 31 * result + hash.contentHashCode()
        return result
    }

    override fun toString(): String = "SHA2HashResult(algorithm=$algorithm,hash=REDACTED)"
}
