package com.chrynan.auth.hash.argon

import com.chrynan.auth.hash.HashAlgorithm

data class Argon2HashAlgorithm internal constructor(
    override val version: String,
    val type: Argon2Type,
    val saltLength: Int,
    val hashLength: Int,
    val parallelism: Int,
    val memory: Int,
    val iterations: Int
) : HashAlgorithm {

    override val name: String = type.typeName
}
