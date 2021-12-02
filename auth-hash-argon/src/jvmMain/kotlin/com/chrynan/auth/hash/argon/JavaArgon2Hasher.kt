@file:Suppress("unused")

package com.chrynan.auth.hash.argon

import com.chrynan.auth.core.SecureString
import com.chrynan.auth.core.toSecureString
import com.password4j.Argon2Function
import com.password4j.Password

internal class JavaArgon2Hasher(
    type: Argon2Type,
    saltLength: Int,
    hashLength: Int,
    parallelism: Int,
    memory: Int,
    iterations: Int
) : Argon2Hasher {

    override val algorithm: Argon2HashAlgorithm = Argon2HashAlgorithm(
        type = type,
        version = "1.3",
        saltLength = saltLength,
        hashLength = hashLength,
        parallelism = parallelism,
        memory = memory,
        iterations = iterations
    )

    private val argon2HashFunction = Argon2Function.getInstance(
        algorithm.memory,
        algorithm.iterations,
        algorithm.parallelism,
        algorithm.hashLength,
        algorithm.type.toArgon2()
    ) // TODO handle version appropriately

    override suspend fun hash(source: SecureString): Argon2HashResult {
        val hash = Password.hash(source.toJavaSecureString(eraseSource = false))
            .addRandomSalt(algorithm.saltLength)
            .with(argon2HashFunction)

        return Argon2HashResult(
            algorithm = algorithm,
            hash = hash.result.toSecureString(),
            salt = hash.salt.toSecureString()
        )
    }

    override suspend fun matches(source: SecureString, salt: SecureString?, hash: SecureString): Boolean =
        if (salt != null) {
            Password.check(source.toJavaSecureString(eraseSource = false), hash.toString())
                .addSalt(salt.toString())
                .with(argon2HashFunction)
        } else {
            Password.check(source.toJavaSecureString(eraseSource = false), hash.toString())
                .with(argon2HashFunction)
        }
}

actual fun argon2Hasher(
    type: Argon2Type,
    saltLength: Int,
    hashLength: Int,
    parallelism: Int,
    memory: Int,
    iterations: Int
): Argon2Hasher =
    JavaArgon2Hasher(
        type = type,
        saltLength = saltLength,
        hashLength = hashLength,
        parallelism = parallelism,
        memory = memory,
        iterations = iterations
    )
