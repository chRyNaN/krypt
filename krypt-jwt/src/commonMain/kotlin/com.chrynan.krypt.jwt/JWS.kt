package com.chrynan.krypt.jwt

import com.chrynan.krypt.encoding.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

/**
 * Represents a JSON Web Signature (JWS), along with the decoded JSON Web Token (JWT) properties. This is an extension
 * on the [JWT] interface but provides the [signature] value.
 *
 * The Signature is a result of taking the encoded [JWT.header] and [JWT.payload], adding a period character between
 * them, and signing that, along with a secret key, using the signing algorithm specified in the Header. For example:
 *
 * ```
 * val signature = HMACSHA256(
 *     base64UrlEncode(header) + "." +
 *     base64UrlEncode(payload),
 *     secret)
 * ```
 *
 * A [JWS] provides integrity protection for a [JWT]. Because the Header and Payload of the JWT are signed by the
 * creator of the token, it can easily be verified to make sure that the data was not tampered with. The signature
 * algorithm can practically be any cryptographic signature algorithm, symmetric or asymmetric, but the natively
 * supported options are defined by the [SignatureAlgorithm] enum class.
 *
 * A JWT takes the following
 * encoded form:
 *
 * ```
 * Base64URL-Encoded-Header.Base64URL-Encoded-Payload.Base64URL-Encoded-Signature
 * ```
 *
 * @see [JWS Specification](https://datatracker.ietf.org/doc/html/rfc7515)
 */
interface JWS<H : Header, P : Payload> : JWT<H, P> {

    /**
     * The signature represented as a Base64 URL encoded [String] of the signature [ByteArray].
     */
    @SerialName(value = "signature")
    val signature: String

    override fun format(
        json: Json,
        headerSerializer: KSerializer<H>,
        payloadSerializer: KSerializer<P>,
        encoder: Encoder
    ): String {
        val headerJsonString = json.encodeToString(serializer = headerSerializer, header)
        val payloadJsonString = json.encodeToString(serializer = payloadSerializer, payload)

        val encodedHeader = encoder.encodeUtf8ToString(headerJsonString).trim()
        val encodedPayload = encoder.encodeUtf8ToString(payloadJsonString).trim()

        return "$encodedHeader.$encodedPayload.${signature.trim()}"
    }

    companion object {

        /**
         * Parses the provided [String] [value] representing an encoded JWS (a JWT with the signature). This function
         * returns a decoded and deserialized [JWS] from the provided [value] if parsing was successful.
         *
         * Note that if the provided [value] does not include a signature part, the parsing will fail. In that case, it
         * is best to call the [JWT.Companion.parse] function, which will return a [JWS] if it detects a signature, but
         * typed as a [JWT] return value. Then, a simple type check could be performed to know whether the result is a
         * [JWT] or a [JWS].
         *
         * @param [value] The compacted and encoded [String] JSON Web Token.
         * @param [json] The [Json] instance used for deserializing JSON [String] values into Kotlin types.
         * @param [headerSerializer] The [KSerializer] used to deserialize the [Header] type [H].
         * @param [payloadSerializer] The [KSerializer] used to deserialize the [Payload] type [P].
         * @param [decoder] The [Decoder] used to Base64 URL decode the sub-values within the [value] JWT [String]. If
         * the provided [Decoder] does not properly handle Base64 URL decoding, behavior is undefined.
         */
        inline fun <reified H : Header, reified P : Payload> parse(
            value: String,
            json: Json = Json,
            headerSerializer: KSerializer<H> = serializer(),
            payloadSerializer: KSerializer<P> = serializer(),
            decoder: Decoder = Base64UrlDecoder()
        ): JWS<H, P> {
            val parts = value.split('.')

            if (parts.size != 3) {
                error("Expecting a Header, Payload, and Signature for the JWS value. Instead only had ${parts.size} parts.")
            }

            val decodedHeaderString = decoder.decodeUtf8ToString(parts[0]).trim()
            val decodedPayloadString = decoder.decodeUtf8ToString(parts[1]).trim()
            val signature = decoder.decodeUtf8ToString(parts[2]).trim()

            val header = json.decodeFromString(deserializer = headerSerializer, string = decodedHeaderString)
            val payload = json.decodeFromString(deserializer = payloadSerializer, string = decodedPayloadString)

            return JWS(header = header, payload = payload, signature = signature)
        }
    }
}

/**
 * Creates an instance of a [JWS] with the provided [header], [payload], and signature. The returned type is
 * [DefaultJWS], which is an immutable data class.
 *
 * Note that no validation is performed by this function when creating a [JWS] instance.
 */
@Suppress("FunctionName")
fun <H : Header, P : Payload> JWS(
    header: H,
    payload: P,
    signature: String
): DefaultJWS<H, P> = DefaultJWS(
    header = header,
    payload = payload,
    signature = signature
)

/**
 * Decodes this [JWS] Base64 URL Encoded [JWS.signature] value as a [ByteArray].
 */
@Suppress("unused")
fun <H : Header, P : Payload> JWS<H, P>.signatureBytes(decoder: Decoder = Base64UrlDecoder()): ByteArray =
    decoder.decodeUtf8ToByteArray(signature)

/**
 * Decodes this [JWS] Base64 URL Encoded [JWS.signature] value as a UTF-8 encoded [String].
 */
@Suppress("unused")
fun <H : Header, P : Payload> JWS<H, P>.signatureUtf8(decoder: Decoder = Base64UrlDecoder()): String =
    decoder.decodeUtf8ToByteArray(signature).decodeToString()

/**
 * A default implementation of the [JWS] interface. This is an immutable data class, to obtain a copy of this instance,
 * use the [copy] function.
 */
@Serializable
data class DefaultJWS<H : Header, P : Payload> internal constructor(
    @SerialName(value = "header") override val header: H,
    @SerialName(value = "payload") override val payload: P,
    @SerialName(value = "signature") override val signature: String
) : JWS<H, P>
