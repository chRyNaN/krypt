@file:Suppress("unused")

package com.chrynan.auth.core

import com.chrynan.redacted.core.RedactedProperty
import com.chrynan.redacted.core.RedactedPropertyEncoder
import kotlinx.serialization.Serializable

@Serializable
enum class HashAlgorithm {

    SHA256,
    SHA512,
    ARGON2I,
    ARGON2D,
    ARGON2ID,
}

@Serializable
data class HashResult(
    val algorithm: HashAlgorithm,
    @Serializable(with = RedactedPropertyEncoder::class) val hash: RedactedProperty<String>,
    val salt: String? = null
)

interface HashEncoder {

    val algorithm: HashAlgorithm

    suspend fun hash(credential: CharSequence): HashResult
}

interface HashMatcher {

    val algorithm: HashAlgorithm

    suspend fun matches(credential: CharSequence, hash: String): Boolean
}

@Suppress("FunctionName")
expect fun CredentialHashEncoder(
    saltLength: Int = 16,
    hashLength: Int = 32,
    parallelism: Int = 1,
    memory: Int = 1 shl 12,
    iterations: Int = 3
): HashEncoder

@Suppress("FunctionName")
expect fun CredentialHashMatcher(
    saltLength: Int = 16,
    hashLength: Int = 32,
    parallelism: Int = 1,
    memory: Int = 1 shl 12,
    iterations: Int = 3
): HashMatcher
