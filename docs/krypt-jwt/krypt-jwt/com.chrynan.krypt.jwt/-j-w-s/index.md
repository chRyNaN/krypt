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

## See also

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
| [signature](signature.md) | [common]<br>abstract val [signature](signature.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Inheritors

| Name |
|---|
| [DefaultJWS](../-default-j-w-s/index.md) |
