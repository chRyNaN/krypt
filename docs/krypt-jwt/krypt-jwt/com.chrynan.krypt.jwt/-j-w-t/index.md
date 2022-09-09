//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[JWT](index.md)

# JWT

[common]\
interface [JWT](index.md)&lt;[H](index.md) : [Header](../-header/index.md), [P](index.md) : [Payload](../-payload/index.md)&gt;

Represents a decoded JSON Web Token (JWT) without the Signature defined in a [JWS](../-j-w-s/index.md). A JWT takes the following encoded form:

```kotlin
Base64URL-Encoded-Header.Base64URL-Encoded-Payload.Base64URL-Encoded-Signature
```

The Header is a JSON object, which when encoded it is turned into a JSON [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) and Base64 URL encoded.

The Payload is also a JSON object, which when encoded, is turned into a JSON [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) and Base64 URL encoded.

The Signature is a result of taking the encoded Header and Payload, adding a period character between them, and signing that, along with a secret key, using the signing algorithm specified in the Header. For example:

```kotlin
val signature = HMACSHA256(
    base64UrlEncode(header) + "." +
    base64UrlEncode(payload),
    secret)
```

This interface represents just the decoded [header](header.md) and [payload](payload.md) of a JWT, and not the Signature which is obtained after the other values are already encoded. For an extension of this interface, which includes the Signature, refer to the [JWS](../-j-w-s/index.md) interface.

To obtain an instance of this interface, use the [JWT](index.md) constructor function.

## See also

common

| | |
|---|---|
|  | [JWT Specification](https://datatracker.ietf.org/doc/html/rfc7519) |
| jwt.io | (https://jwt.io/introduction/) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [format](format.md) | [common]<br>open fun [format](format.md)(json: Json = Json, headerSerializer: KSerializer&lt;[H](index.md)&gt;, payloadSerializer: KSerializer&lt;[P](index.md)&gt;, encoder: [Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md) = Base64UrlEncoder()): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Actually builds the JWT and serializes it to a compact, URL-safe string according to the [JWT Compact Serialization](https://tools.ietf.org/html/draft-ietf-oauth-json-web-token-25#section-7) rules. |

## Properties

| Name | Summary |
|---|---|
| [header](header.md) | [common]<br>abstract val [header](header.md): [H](index.md) |
| [payload](payload.md) | [common]<br>abstract val [payload](payload.md): [P](index.md) |

## Inheritors

| Name |
|---|
| [JWS](../-j-w-s/index.md) |
| [DefaultJWT](../-default-j-w-t/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [format](../format.md) | [common]<br>inline fun &lt;[H](../format.md) : [Header](../-header/index.md), [P](../format.md) : [Payload](../-payload/index.md)&gt; [JWT](index.md)&lt;[H](../format.md), [P](../format.md)&gt;.[format](../format.md)(json: Json = Json, encoder: [Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md) = Base64UrlEncoder()): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A convenience function for invoking the [JWT.format](format.md) function with KSerializers obtained from the serializer function for the Header and Payload. |
| [signWith](../sign-with.md) | [common]<br>suspend fun &lt;[H](../sign-with.md) : [Header](../-header/index.md), [P](../sign-with.md) : [Payload](../-payload/index.md)&gt; [JWT](index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;.[signWith](../sign-with.md)(key: [Key](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-key/index.md), algorithm: [SignatureAlgorithm](../-signature-algorithm/index.md)): [JWS](../-j-w-s/index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;<br>suspend fun &lt;[H](../sign-with.md) : [Header](../-header/index.md), [P](../sign-with.md) : [Payload](../-payload/index.md)&gt; [JWT](index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;.[signWith](../sign-with.md)(key: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), algorithm: [SignatureAlgorithm](../-signature-algorithm/index.md)): [JWS](../-j-w-s/index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;<br>suspend fun &lt;[H](../sign-with.md) : [Header](../-header/index.md), [P](../sign-with.md) : [Payload](../-payload/index.md)&gt; [JWT](index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;.[signWith](../sign-with.md)(signer: suspend (jwt: [JWT](index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;) -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [JWS](../-j-w-s/index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt; |
