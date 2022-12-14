@file:Suppress("unused")

package com.chrynan.krypt.jwt

import com.chrynan.krypt.encoding.Encoder
import io.jsonwebtoken.impl.crypto.DefaultJwtSigner
import javax.crypto.spec.SecretKeySpec

internal actual val defaultJwtSigner: JwtSigner = AndroidJwtSigner()

class AndroidJwtSigner : JwtSigner {

    override suspend fun sign(
        key: ByteArray,
        algorithm: SignatureAlgorithm,
        value: String,
        encoder: Encoder
    ): String {
        val jvmSigner = DefaultJwtSigner(
            algorithm.toAndroidSignatureAlgorithm(),
            SecretKeySpec(key, algorithm.jcaName)
        ) {
            encoder.encodeToString(it)
        }

        return jvmSigner.sign(value)
    }
}
