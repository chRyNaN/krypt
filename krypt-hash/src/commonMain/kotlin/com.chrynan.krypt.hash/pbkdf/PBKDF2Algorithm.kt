package com.chrynan.krypt.hash.pbkdf

import com.chrynan.krypt.hash.HashAlgorithm

data class PBKDF2Algorithm internal constructor(
    val salt: ByteArray,
    val iterationCount: Int,
    val hLength: Int,
    val dkLength: Int
) : HashAlgorithm {

    override val name: String
        get() = "PBKDF2"

    override val version: String
        get() = "2"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as PBKDF2Algorithm

        if (!salt.contentEquals(other.salt)) return false
        if (iterationCount != other.iterationCount) return false
        if (name != other.name) return false
        if (version != other.version) return false

        return true
    }

    override fun hashCode(): Int {
        var result = salt.contentHashCode()
        result = 31 * result + iterationCount
        result = 31 * result + name.hashCode()
        result = 31 * result + version.hashCode()
        return result
    }
}
