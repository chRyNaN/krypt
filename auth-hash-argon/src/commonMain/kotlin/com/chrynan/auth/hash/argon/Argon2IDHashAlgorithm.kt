package com.chrynan.auth.hash.argon

import com.chrynan.auth.hash.HashAlgorithm

data class Argon2IDHashAlgorithm internal constructor(
    override val version: String,
    val saltLength: Int = 16,
    val hashLength: Int = 32,
    val parallelism: Int = 1,
    val memory: Int = 1 shl 12,
    val iterations: Int = 3
) : HashAlgorithm {

    override val name: String = "Argon2ID"
}
