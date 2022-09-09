//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[DefaultJWT](index.md)

# DefaultJWT

[common]\
data class [DefaultJWT](index.md)&lt;[H](index.md) : [Header](../-header/index.md), [P](index.md) : [Payload](../-payload/index.md)&gt; : [JWT](../-j-w-t/index.md)&lt;[H](index.md), [P](index.md)&gt; 

A default implementation of the [JWT](../-j-w-t/index.md) interface. This is an immutable data class, to obtain a copy of this instance, use the [copy](../../../../krypt-jwt/com.chrynan.krypt.jwt/-default-j-w-t/copy.md) function.

## Functions

| Name | Summary |
|---|---|
| [format](../-j-w-t/format.md) | [common]<br>open fun [format](../-j-w-t/format.md)(json: Json = Json, headerSerializer: KSerializer&lt;[H](index.md)&gt;, payloadSerializer: KSerializer&lt;[P](index.md)&gt;, encoder: [Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md) = Base64UrlEncoder()): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Actually builds the JWT and serializes it to a compact, URL-safe string according to the [JWT Compact Serialization](https://tools.ietf.org/html/draft-ietf-oauth-json-web-token-25#section-7) rules. |

## Properties

| Name | Summary |
|---|---|
| [header](header.md) | [common]<br>open override val [header](header.md): [H](index.md) |
| [payload](payload.md) | [common]<br>open override val [payload](payload.md): [P](index.md) |
