@file:Suppress("unused")

package com.chrynan.krypt.jwt

import com.chrynan.krypt.core.*
import com.chrynan.krypt.encoding.Base64UrlEncoder
import com.chrynan.krypt.encoding.Encoder
import com.chrynan.krypt.encoding.encodeUtf8ToString
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

suspend inline fun <reified H : Header, reified P : Payload> JWT<H, P>.signWith(
    key: SignatureAlgorithmKey,
    json: Json = Json,
    headerSerializer: KSerializer<H> = serializer(),
    payloadSerializer: KSerializer<P> = serializer(),
    encoder: Encoder = Base64UrlEncoder(),
    signer: JwtSigner = defaultJwtSigner
): JWS<H, P> = signWith(
    key = key.key,
    algorithm = key.algorithm,
    json = json,
    headerSerializer = headerSerializer,
    payloadSerializer = payloadSerializer,
    encoder = encoder,
    signer = signer
)

suspend inline fun <reified H : Header, reified P : Payload> JWT<H, P>.signWith(
    key: Key,
    algorithm: SignatureAlgorithm,
    json: Json = Json,
    headerSerializer: KSerializer<H> = serializer(),
    payloadSerializer: KSerializer<P> = serializer(),
    encoder: Encoder = Base64UrlEncoder(),
    signer: JwtSigner = defaultJwtSigner
): JWS<H, P> =
    signWith(
        key = key.encoded ?: error("Cannot sign JWT with a Key whose encoded property is null."),
        algorithm = algorithm,
        json = json,
        headerSerializer = headerSerializer,
        payloadSerializer = payloadSerializer,
        encoder = encoder,
        signer = signer
    )

suspend inline fun <reified H : Header, reified P : Payload> JWT<H, P>.signWith(
    key: ByteArray,
    algorithm: SignatureAlgorithm,
    json: Json = Json,
    headerSerializer: KSerializer<H> = serializer(),
    payloadSerializer: KSerializer<P> = serializer(),
    encoder: Encoder = Base64UrlEncoder(),
    signer: JwtSigner = defaultJwtSigner
): JWS<H, P> {
    if (algorithm == SignatureAlgorithm.NONE) error("Cannot sign with ${SignatureAlgorithm.NONE} type.")

    val compacted = this.safeCompact(
        json = json,
        headerSerializer = headerSerializer,
        payloadSerializer = payloadSerializer,
        encoder = encoder
    )

    val signature = signer.sign(
        key = key,
        algorithm = algorithm,
        value = compacted,
        encoder = encoder
    ).trim()

    return JWS(
        header = this.header,
        payload = this.payload,
        signature = signature
    )
}

suspend fun <H : Header, P : Payload> JWT<H, P>.signWith(
    signer: suspend (jwt: JWT<H, P>) -> String
): JWS<H, P> {
    val signature = signer(this)

    return JWS(
        header = this.header,
        payload = this.payload,
        signature = signature
    )
}

/**
 * A duplication of the [JWT.format] function used to assert that if this is invoked on a [JWS] (which extends from a
 * [JWT]), it properly invokes the [JWT] implementation and doesn't include the already computed signature value.
 */
@PublishedApi
internal fun <H : Header, P : Payload> JWT<H, P>.safeCompact(
    json: Json = Json,
    headerSerializer: KSerializer<H>,
    payloadSerializer: KSerializer<P>,
    encoder: Encoder = Base64UrlEncoder()
): String {
    val headerJsonString = json.encodeToString(serializer = headerSerializer, header)
    val payloadJsonString = json.encodeToString(serializer = payloadSerializer, payload)

    val encodedHeader = encoder.encodeUtf8ToString(headerJsonString).trim()
    val encodedPayload = encoder.encodeUtf8ToString(payloadJsonString).trim()

    return "$encodedHeader.$encodedPayload"
}
