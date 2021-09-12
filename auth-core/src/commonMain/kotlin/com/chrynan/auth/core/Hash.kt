package com.chrynan.auth.core

import kotlinx.serialization.Serializable

fun hash(credentials: String, salt: String) {

}

@Serializable
enum class HashAlgorithm {

    SHA256,
    SHA512,
}

data class HashResult(
    val algorithm: HashAlgorithm
)
