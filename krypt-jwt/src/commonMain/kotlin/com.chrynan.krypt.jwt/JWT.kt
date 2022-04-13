@file:Suppress("unused")

package com.chrynan.krypt.jwt

import com.chrynan.krypt.encoding.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

/**
 * Represents a decoded JSON Web Token (JWT) without the Signature defined in a [JWS]. A JWT takes the following
 * encoded form:
 *
 * ```
 * Base64URL-Encoded-Header.Base64URL-Encoded-Payload.Base64URL-Encoded-Signature
 * ```
 *
 * The Header is a JSON object, which when encoded it is turned into a JSON [String] and Base64 URL encoded.
 *
 * The Payload is also a JSON object, which when encoded, is turned into a JSON [String] and Base64 URL encoded.
 *
 * The Signature is a result of taking the encoded Header and Payload, adding a period character between them, and
 * signing that, along with a secret key, using the signing algorithm specified in the Header. For example:
 *
 * ```
 * val signature = HMACSHA256(
 *     base64UrlEncode(header) + "." +
 *     base64UrlEncode(payload),
 *     secret)
 * ```
 *
 * This interface represents just the decoded [header] and [payload] of a JWT, and not the Signature which is obtained
 * after the other values are already encoded. For an extension of this interface, which includes the Signature, refer
 * to the [JWS] interface.
 *
 * To obtain an instance of this interface, use the [JWT] constructor function.
 *
 * @see [JWT Specification](https://datatracker.ietf.org/doc/html/rfc7519)
 * @see [jwt.io](https://jwt.io/introduction/)
 */
interface JWT<H : Header, P : Payload> {

    @SerialName(value = "header")
    val header: H

    @SerialName(value = "payload")
    val payload: P

    /**
     * Actually builds the JWT and serializes it to a compact, URL-safe string according to the
     * [JWT Compact Serialization](https://tools.ietf.org/html/draft-ietf-oauth-json-web-token-25#section-7) rules.
     *
     * This will return a [String] value representing the encoded JWT with the following format:
     *
     * ```
     * Base64URL-Encoded-Header.Base64URL-Encoded-Payload.Base64URL-Encoded-Signature
     * ```
     *
     * Note that if this is invoked on a [JWT] and not a subtype (ex: [JWS]), then it will not include the trailing
     * signature [String] value. If this is a [JWS] instance then it will include the trailing signature [String]
     * value.
     *
     * @param [json] The [Json] object used to serialize the properties into JSON [String] values.
     * @param [encoder] The [Encoder] object used to Base64 URL encode the JSON [String] values.
     *
     * @see [JWT Specification](https://tools.ietf.org/html/draft-ietf-oauth-json-web-token-25#section-7)
     */
    fun format(
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

    companion object {

        /**
         * Parses the provided [String] [value] representing an encoded JWT. This function returns a decoded and
         * deserialized [JWT] from the provided [value] if parsing was successful.
         *
         * Note that if the provided [value] includes a JWS, and it is desired to retain that information, use the
         * [JWS.Companion.parse] function instead, as that will return a [JWS] instance. If a signature is detected in
         * the [value], this function will internally delegate to the [JWS.Companion.parse] function, but the type
         * returned from this function is still [JWT].
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
        ): JWT<H, P> {
            val parts = value.split('.')

            if (parts.size > 2) {
                return JWS.parse(
                    value = value,
                    json = json,
                    headerSerializer = headerSerializer,
                    payloadSerializer = payloadSerializer,
                    decoder = decoder
                )
            }

            if (parts.size != 2) {
                error("Expecting a Header and Payload for the JWT value. Instead only had ${parts.size} parts.")
            }

            val decodedHeaderString = decoder.decodeUtf8ToString(parts[0]).trim()
            val decodedPayloadString = decoder.decodeUtf8ToString(parts[1]).trim()

            val header = json.decodeFromString(deserializer = headerSerializer, string = decodedHeaderString)
            val payload = json.decodeFromString(deserializer = payloadSerializer, string = decodedPayloadString)

            return JWT(header = header, payload = payload)
        }
    }
}

/**
 * A convenience function for invoking the [JWT.format] function with [KSerializer]s obtained from the [serializer]
 * function for the Header and Payload.
 */
inline fun <reified H : Header, reified P : Payload> JWT<H, P>.format(
    json: Json = Json,
    encoder: Encoder = Base64UrlEncoder()
): String = format(
    json = json,
    headerSerializer = serializer(),
    payloadSerializer = serializer(),
    encoder = encoder
)

/**
 * Creates an instance of a [JWT] with the provided [header] and [payload]. The returned type is [DefaultJWT], which is
 * an immutable data class.
 *
 * Note that no validation is performed by this function when creating a [JWT] instance.
 */
@Suppress("FunctionName")
fun <H : Header, P : Payload> JWT(
    header: H,
    payload: P
): DefaultJWT<H, P> = DefaultJWT(
    header = header,
    payload = payload
)

/**
 * A default implementation of the [JWT] interface. This is an immutable data class, to obtain a copy of this instance,
 * use the [copy] function.
 */
@Serializable
data class DefaultJWT<H : Header, P : Payload> internal constructor(
    @SerialName(value = "header") override val header: H,
    @SerialName(value = "payload") override val payload: P
) : JWT<H, P>
