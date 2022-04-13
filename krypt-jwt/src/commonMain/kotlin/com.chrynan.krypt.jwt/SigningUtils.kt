@file:Suppress("unused")

package com.chrynan.krypt.jwt

import com.chrynan.krypt.core.Key

suspend fun <H : Header, P : Payload> JWT<H, P>.signWith(key: Key, algorithm: SignatureAlgorithm): JWS<H, P> =
    signWith(
        key = key.encoded ?: error("Cannot sign JWT with a Key whose encoded property is null."),
        algorithm = algorithm
    )

suspend fun <H : Header, P : Payload> JWT<H, P>.signWith(
    key: ByteArray,
    algorithm: SignatureAlgorithm
): JWS<H, P> = signWith {
    if (algorithm == SignatureAlgorithm.NONE) error("Cannot sign with ${SignatureAlgorithm.NONE} type.")

    TODO()
}

suspend fun <H : Header, P : Payload> JWT<H, P>.signWith(signer: suspend (jwt: JWT<H, P>) -> String): JWS<H, P> {
    val signature = signer(this)

    return JWS(
        header = this.header,
        payload = this.payload,
        signature = signature
    )
}
