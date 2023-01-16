//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[JWS](index.md)/[format](format.md)

# format

[common]\
open override fun [format](format.md)(json: Json, headerSerializer: KSerializer&lt;[H](index.md)&gt;, payloadSerializer: KSerializer&lt;[P](index.md)&gt;, encoder: [Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Actually builds the JWT and serializes it to a compact, URL-safe string according to the [JWT Compact Serialization](https://tools.ietf.org/html/draft-ietf-oauth-json-web-token-25#section-7) rules.

This will return a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value representing the encoded JWT with the following format:

```kotlin
Base64URL-Encoded-Header.Base64URL-Encoded-Payload.Base64URL-Encoded-Signature
```

Note that if this is invoked on a [JWT](../-j-w-t/index.md) and not a subtype (ex: [JWS](index.md)), then it will not include the trailing signature [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value. If this is a [JWS](index.md) instance then it will include the trailing signature [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value.

#### See also

common

| | |
|---|---|
|  | [JWT Specification](https://tools.ietf.org/html/draft-ietf-oauth-json-web-token-25#section-7) |

#### Parameters

common

| | |
|---|---|
| json | The Json object used to serialize the properties into JSON [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) values. |
| encoder | The [Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md) object used to Base64 URL encode the JSON [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) values. |
