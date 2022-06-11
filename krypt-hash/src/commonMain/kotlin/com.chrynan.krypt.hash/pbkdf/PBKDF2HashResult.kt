package com.chrynan.krypt.hash.pbkdf

import com.chrynan.krypt.hash.HashResult

class PBKDF2HashResult internal constructor(
    override val algorithm: PBKDF2Algorithm,
    override val hash: ByteArray
) : HashResult<PBKDF2Algorithm, ByteArray> {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as PBKDF2HashResult

        if (algorithm != other.algorithm) return false
        if (!hash.contentEquals(other.hash)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = algorithm.hashCode()
        result = 31 * result + hash.contentHashCode()
        return result
    }

    override fun toString(): String = "PBKDF2HashResult(algorithm=$algorithm,hash=REDACTED)"
}
