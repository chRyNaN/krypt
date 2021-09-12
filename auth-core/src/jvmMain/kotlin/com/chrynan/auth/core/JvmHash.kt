@file:Suppress("unused")

package com.chrynan.auth.core

import com.chrynan.redacted.core.RedactedProperty
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder

internal class Argon2IDHasher(
    saltLength: Int = 16,
    hashLength: Int = 32,
    parallelism: Int = 1,
    memory: Int = 1 shl 12,
    iterations: Int = 3
) : HashEncoder,
    HashMatcher {

    override val algorithm: HashAlgorithm = HashAlgorithm.ARGON2ID

    private val argon2PasswordEncoder = Argon2PasswordEncoder(saltLength, hashLength, parallelism, memory, iterations)

    override suspend fun hash(credential: CharSequence): HashResult =
        HashResult(
            algorithm = HashAlgorithm.ARGON2ID,
            hash = RedactedProperty(value = argon2PasswordEncoder.encode(credential))
        )

    override suspend fun matches(credential: CharSequence, hash: String): Boolean =
        argon2PasswordEncoder.matches(credential, hash)
}

@Suppress("FunctionName")
actual fun CredentialHashEncoder(
    saltLength: Int,
    hashLength: Int,
    parallelism: Int,
    memory: Int,
    iterations: Int
): HashEncoder =
    Argon2IDHasher(
        saltLength = saltLength,
        hashLength = hashLength,
        parallelism = parallelism,
        memory = memory,
        iterations = iterations
    )

@Suppress("FunctionName")
actual fun CredentialHashMatcher(
    saltLength: Int,
    hashLength: Int,
    parallelism: Int,
    memory: Int,
    iterations: Int
): HashMatcher =
    Argon2IDHasher(
        saltLength = saltLength,
        hashLength = hashLength,
        parallelism = parallelism,
        memory = memory,
        iterations = iterations
    )
