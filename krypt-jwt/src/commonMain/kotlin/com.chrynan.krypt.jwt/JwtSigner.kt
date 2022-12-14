package com.chrynan.krypt.jwt

import com.chrynan.krypt.encoding.Encoder

interface JwtSigner {

    suspend fun sign(
        key: ByteArray,
        algorithm: SignatureAlgorithm,
        value: String,
        encoder: Encoder
    ): String
}

@PublishedApi
internal expect val defaultJwtSigner: JwtSigner
