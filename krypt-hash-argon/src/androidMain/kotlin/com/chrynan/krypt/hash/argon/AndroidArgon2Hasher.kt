@file:Suppress("unused")

package com.chrynan.krypt.hash.argon

import com.chrynan.krypt.core.SecureString
import com.chrynan.krypt.core.toSecureString
import com.chrynan.krypt.hash.argon.Argon2HashAlgorithm
import com.chrynan.krypt.hash.argon.Argon2HashResult
import com.chrynan.krypt.hash.argon.Argon2Hasher
import com.chrynan.krypt.hash.argon.Argon2Type
import com.password4j.Argon2Function
import com.password4j.Password

internal class AndroidArgon2Hasher(
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

    override suspend fun matches(source: SecureString, result: Argon2HashResult): Boolean =
        Password.check(source.toJavaSecureString(eraseSource = false), result.hash.toString())
            .addSalt(result.salt.toString())
            .with(argon2HashFunction)
}

internal actual fun argon2Hasher(
    type: Argon2Type,
    saltLength: Int,
    hashLength: Int,
    parallelism: Int,
    memory: Int,
    iterations: Int
): Argon2Hasher =
    AndroidArgon2Hasher(
        type = type,
        saltLength = saltLength,
        hashLength = hashLength,
        parallelism = parallelism,
        memory = memory,
        iterations = iterations
    )
