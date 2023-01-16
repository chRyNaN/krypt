//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[JWS](index.md)

# JWS

[common]\
interface [JWS](index.md)&lt;[H](index.md) : [Header](../-header/index.md), [P](index.md) : [Payload](../-payload/index.md)&gt; : [JWT](../-j-w-t/index.md)&lt;[H](index.md), [P](index.md)&gt; 

Represents a JSON Web Signature (JWS), along with the decoded JSON Web Token (JWT) properties. This is an extension on the [JWT](../-j-w-t/index.md) interface but provides the [signature](signature.md) value.

The Signature is a result of taking the encoded [JWT.header](../-j-w-t/header.md) and [JWT.payload](../-j-w-t/payload.md), adding a period character between them, and signing that, along with a secret key, using the signing algorithm specified in the Header. For example:

```kotlin
val signature = HMACSHA256(
    base64UrlEncode(header) + "." +
    base64UrlEncode(payload),
    secret)
```

A [JWS](index.md) provides integrity protection for a [JWT](../-j-w-t/index.md). Because the Header and Payload of the JWT are signed by the creator of the token, it can easily be verified to make sure that the data was not tampered with. The signature algorithm can practically be any cryptographic signature algorithm, symmetric or asymmetric, but the natively supported options are defined by the [SignatureAlgorithm](../-signature-algorithm/index.md) enum class.

A JWT takes the following encoded form:

```kotlin
Base64URL-Encoded-Header.Base64URL-Encoded-Payload.Base64URL-Encoded-Signature
```

#### See also

common

| | |
|---|---|
|  | [JWS Specification](https://datatracker.ietf.org/doc/html/rfc7515) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [format](format.md) | [common]<br>open override fun [format](format.md)(json: Json, headerSerializer: KSerializer&lt;[H](index.md)&gt;, payloadSerializer: KSerializer&lt;[P](index.md)&gt;, encoder: [Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Actually builds the JWT and serializes it to a compact, URL-safe string according to the [JWT Compact Serialization](https://tools.ietf.org/html/draft-ietf-oauth-json-web-token-25#section-7) rules. |

## Properties

| Name | Summary |
|---|---|
| [header](../-j-w-t/header.md) | [common]<br>abstract val [header](../-j-w-t/header.md): [H](index.md) |
| [payload](../-j-w-t/payload.md) | [common]<br>abstract val [payload](../-j-w-t/payload.md): [P](index.md) |
| [signature](signature.md) | [common]<br>abstract val [signature](signature.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The signature represented as a Base64 URL encoded [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) of the signature [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html). |

## Inheritors

| Name |
|---|
| [DefaultJWS](../-default-j-w-s/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [compact](../compact.md) | [common]<br>fun &lt;[H](../compact.md) : [Header](../-header/index.md), [P](../compact.md) : [Payload](../-payload/index.md)&gt; [JWT](../-j-w-t/index.md)&lt;[H](../compact.md), [P](../compact.md)&gt;.[compact](../compact.md)(json: Json = Json, headerSerializer: KSerializer&lt;[H](../compact.md)&gt;, payloadSerializer: KSerializer&lt;[P](../compact.md)&gt;, encoder: [Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md) = Base64UrlEncoder()): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A convenience function for invoking the [JWT.format](../-j-w-t/format.md) function. The &quot;compact&quot; name is used in other JWT library implementations, and IIRC the specification itself, but I prefer the &quot;format&quot; name, so I include both for personal preference.<br>[common]<br>inline fun &lt;[H](../compact.md) : [Header](../-header/index.md), [P](../compact.md) : [Payload](../-payload/index.md)&gt; [JWT](../-j-w-t/index.md)&lt;[H](../compact.md), [P](../compact.md)&gt;.[compact](../compact.md)(json: Json = Json, encoder: [Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md) = Base64UrlEncoder()): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A convenience function for invoking the [format](../format.md) function. The &quot;compact&quot; name is used in other JWT library implementations, and IIRC the specification itself, but I prefer the &quot;format&quot; name, so I include both for personal preference. |
| [format](../format.md) | [common]<br>inline fun &lt;[H](../format.md) : [Header](../-header/index.md), [P](../format.md) : [Payload](../-payload/index.md)&gt; [JWT](../-j-w-t/index.md)&lt;[H](../format.md), [P](../format.md)&gt;.[format](../format.md)(json: Json = Json, encoder: [Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md) = Base64UrlEncoder()): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A convenience function for invoking the [JWT.format](../-j-w-t/format.md) function with KSerializers obtained from the serializer function for the Header and Payload. |
| [signatureBytes](../signature-bytes.md) | [common]<br>fun &lt;[H](../signature-bytes.md) : [Header](../-header/index.md), [P](../signature-bytes.md) : [Payload](../-payload/index.md)&gt; [JWS](index.md)&lt;[H](../signature-bytes.md), [P](../signature-bytes.md)&gt;.[signatureBytes](../signature-bytes.md)(decoder: [Decoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-decoder/index.md) = Base64UrlDecoder()): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Decodes this [JWS](index.md) Base64 URL Encoded [JWS.signature](signature.md) value as a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html). |
| [signatureUtf8](../signature-utf8.md) | [common]<br>fun &lt;[H](../signature-utf8.md) : [Header](../-header/index.md), [P](../signature-utf8.md) : [Payload](../-payload/index.md)&gt; [JWS](index.md)&lt;[H](../signature-utf8.md), [P](../signature-utf8.md)&gt;.[signatureUtf8](../signature-utf8.md)(decoder: [Decoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-decoder/index.md) = Base64UrlDecoder()): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Decodes this [JWS](index.md) Base64 URL Encoded [JWS.signature](signature.md) value as a UTF-8 encoded [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html). |
| [signWith](../sign-with.md) | [common]<br>inline suspend fun &lt;[H](../sign-with.md) : [Header](../-header/index.md), [P](../sign-with.md) : [Payload](../-payload/index.md)&gt; [JWT](../-j-w-t/index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;.[signWith](../sign-with.md)(key: [SignatureAlgorithmKey](../-signature-algorithm-key/index.md), json: Json = Json, headerSerializer: KSerializer&lt;[H](../sign-with.md)&gt; = serializer(), payloadSerializer: KSerializer&lt;[P](../sign-with.md)&gt; = serializer(), encoder: [Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md) = Base64UrlEncoder(), signer: [JwtSigner](../-jwt-signer/index.md) = defaultJwtSigner): [JWS](index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;<br>inline suspend fun &lt;[H](../sign-with.md) : [Header](../-header/index.md), [P](../sign-with.md) : [Payload](../-payload/index.md)&gt; [JWT](../-j-w-t/index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;.[signWith](../sign-with.md)(key: [Key](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-key/index.md), algorithm: [SignatureAlgorithm](../-signature-algorithm/index.md), json: Json = Json, headerSerializer: KSerializer&lt;[H](../sign-with.md)&gt; = serializer(), payloadSerializer: KSerializer&lt;[P](../sign-with.md)&gt; = serializer(), encoder: [Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md) = Base64UrlEncoder(), signer: [JwtSigner](../-jwt-signer/index.md) = defaultJwtSigner): [JWS](index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;<br>inline suspend fun &lt;[H](../sign-with.md) : [Header](../-header/index.md), [P](../sign-with.md) : [Payload](../-payload/index.md)&gt; [JWT](../-j-w-t/index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;.[signWith](../sign-with.md)(key: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), algorithm: [SignatureAlgorithm](../-signature-algorithm/index.md), json: Json = Json, headerSerializer: KSerializer&lt;[H](../sign-with.md)&gt; = serializer(), payloadSerializer: KSerializer&lt;[P](../sign-with.md)&gt; = serializer(), encoder: [Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md) = Base64UrlEncoder(), signer: [JwtSigner](../-jwt-signer/index.md) = defaultJwtSigner): [JWS](index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;<br>suspend fun &lt;[H](../sign-with.md) : [Header](../-header/index.md), [P](../sign-with.md) : [Payload](../-payload/index.md)&gt; [JWT](../-j-w-t/index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;.[signWith](../sign-with.md)(signer: suspend (jwt: [JWT](../-j-w-t/index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt;) -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [JWS](index.md)&lt;[H](../sign-with.md), [P](../sign-with.md)&gt; |
