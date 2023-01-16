//[krypt-jwt](../../../../index.md)/[com.chrynan.krypt.jwt](../../index.md)/[JWS](../index.md)/[Companion](index.md)/[parse](parse.md)

# parse

[common]\
inline fun &lt;[H](parse.md) : [Header](../../-header/index.md), [P](parse.md) : [Payload](../../-payload/index.md)&gt; [parse](parse.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), json: Json = Json, headerSerializer: KSerializer&lt;[H](parse.md)&gt; = serializer(), payloadSerializer: KSerializer&lt;[P](parse.md)&gt; = serializer(), decoder: [Decoder](../../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-decoder/index.md) = Base64UrlDecoder()): [JWS](../index.md)&lt;[H](parse.md), [P](parse.md)&gt;

Parses the provided [String](parse.md) representing an encoded JWS (a JWT with the signature). This function returns a decoded and deserialized [JWS](../index.md) from the provided [value](parse.md) if parsing was successful.

Note that if the provided [value](parse.md) does not include a signature part, the parsing will fail. In that case, it is best to call the [JWT.Companion.parse](../../-j-w-t/-companion/parse.md) function, which will return a [JWS](../index.md) if it detects a signature, but typed as a [JWT](../../-j-w-t/index.md) return value. Then, a simple type check could be performed to know whether the result is a [JWT](../../-j-w-t/index.md) or a [JWS](../index.md).

#### Parameters

common

| | |
|---|---|
| value | The compacted and encoded [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) JSON Web Token. |
| json | The Json instance used for deserializing JSON [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) values into Kotlin types. |
| headerSerializer | The KSerializer used to deserialize the [Header](../../-header/index.md) type [H](parse.md). |
| payloadSerializer | The KSerializer used to deserialize the [Payload](../../-payload/index.md) type [P](parse.md). |
| decoder | The [Decoder](../../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-decoder/index.md) used to Base64 URL decode the sub-values within the [value](parse.md) JWT [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html). If the provided [Decoder](../../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-decoder/index.md) does not properly handle Base64 URL decoding, behavior is undefined. |
