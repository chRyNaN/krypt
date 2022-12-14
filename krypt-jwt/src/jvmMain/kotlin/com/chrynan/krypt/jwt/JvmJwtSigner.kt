@file:Suppress("unused")

package com.chrynan.krypt.jwt

import io.jsonwebtoken.impl.crypto.DefaultJwtSigner
import javax.crypto.spec.SecretKeySpec
import com.chrynan.krypt.encoding.Encoder

internal actual val defaultJwtSigner: JwtSigner = JvmJwtSigner()

class JvmJwtSigner : JwtSigner {

    override suspend fun sign(
        key: ByteArray,
        algorithm: SignatureAlgorithm,
        value: String,
        encoder: Encoder
    ): String {
        val jvmSigner = DefaultJwtSigner(
            algorithm.toJvmSignatureAlgorithm(),
            SecretKeySpec(key, algorithm.jcaName)
        ) {
            encoder.encodeToString(it)
        }

        return jvmSigner.sign(value)
    }
}

private fun SignatureAlgorithm.toJvmSignatureAlgorithm(): io.jsonwebtoken.SignatureAlgorithm =
    when (this) {
        SignatureAlgorithm.HS256 -> io.jsonwebtoken.SignatureAlgorithm.HS256
        SignatureAlgorithm.HS384 -> io.jsonwebtoken.SignatureAlgorithm.HS384
        SignatureAlgorithm.HS512 -> io.jsonwebtoken.SignatureAlgorithm.HS512
        SignatureAlgorithm.RS256 -> io.jsonwebtoken.SignatureAlgorithm.RS256
        SignatureAlgorithm.RS384 -> io.jsonwebtoken.SignatureAlgorithm.RS384
        SignatureAlgorithm.RS512 -> io.jsonwebtoken.SignatureAlgorithm.RS512
        SignatureAlgorithm.ES256 -> io.jsonwebtoken.SignatureAlgorithm.ES256
        SignatureAlgorithm.ES384 -> io.jsonwebtoken.SignatureAlgorithm.ES384
        SignatureAlgorithm.ES512 -> io.jsonwebtoken.SignatureAlgorithm.ES512
        SignatureAlgorithm.PS256 -> io.jsonwebtoken.SignatureAlgorithm.PS256
        SignatureAlgorithm.PS384 -> io.jsonwebtoken.SignatureAlgorithm.PS384
        SignatureAlgorithm.PS512 -> io.jsonwebtoken.SignatureAlgorithm.PS512
        SignatureAlgorithm.NONE -> io.jsonwebtoken.SignatureAlgorithm.NONE
    }
