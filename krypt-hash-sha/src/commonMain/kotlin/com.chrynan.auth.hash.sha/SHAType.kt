@file:Suppress("unused")

package com.chrynan.auth.hash.sha

enum class SHAType(
    val typeName: String,
    val typeVersion: Int,
    val byteCount: Int
) {

    SHA_1(typeName = "SHA-1", typeVersion = 1, byteCount = 20),
    SHA_256(typeName = "SHA-256", typeVersion = 256, byteCount = 32),
    SHA_512(typeName = "SHA-512", typeVersion = 512, byteCount = 64)
}
