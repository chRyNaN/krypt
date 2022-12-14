@file:Suppress("unused")

package com.chrynan.krypt.jwt

import io.jsonwebtoken.impl.crypto.DefaultJwtSigner
import javax.crypto.spec.SecretKeySpec
import com.chrynan.krypt.encoding.Encoder

actual val defaultJwtSigner: JwtSigner = JvmJwtSigner()

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
