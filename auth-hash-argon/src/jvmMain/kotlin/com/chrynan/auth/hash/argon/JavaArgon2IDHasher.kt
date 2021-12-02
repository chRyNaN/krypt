@file:Suppress("unused")

package com.chrynan.auth.hash.argon

import com.chrynan.redacted.core.RedactedProperty
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder

internal class JavaArgon2IDHasher(
    saltLength: Int = 16,
    hashLength: Int = 32,
    parallelism: Int = 1,
    memory: Int = 1 shl 12,
    iterations: Int = 3
) : Argon2IDHasher {

    override val algorithm: Argon2IDHashAlgorithm = Argon2IDHashAlgorithm(
        version = "1.3",
        saltLength = saltLength,
        hashLength = hashLength,
        parallelism = parallelism,
        memory = memory,
        iterations = iterations
    )

    private val argon2PasswordEncoder = Argon2PasswordEncoder(saltLength, hashLength, parallelism, memory, iterations)

    override suspend fun hash(source: CharSequence): ArgonHashResult =
        ArgonHashResult(
            algorithm = algorithm,
            hash = RedactedProperty(value = argon2PasswordEncoder.encode(source)),
            salt = null
        )

    override suspend fun matches(source: CharSequence, hash: String): Boolean =
        argon2PasswordEncoder.matches(source, hash)
}

actual fun argon2IDHasher(
    saltLength: Int,
    hashLength: Int,
    parallelism: Int,
    memory: Int,
    iterations: Int
): Argon2IDHasher =
    JavaArgon2IDHasher(
        saltLength = saltLength,
        hashLength = hashLength,
        parallelism = parallelism,
        memory = memory,
        iterations = iterations
    )
