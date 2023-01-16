//[krypt-jwt](../../../../index.md)/[com.chrynan.krypt.jwt](../../index.md)/[JWT](../index.md)/[Companion](index.md)/[parse](parse.md)

# parse

[common]\
inline fun &lt;[H](parse.md) : [Header](../../-header/index.md), [P](parse.md) : [Payload](../../-payload/index.md)&gt; [parse](parse.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), json: Json = Json, headerSerializer: KSerializer&lt;[H](parse.md)&gt; = serializer(), payloadSerializer: KSerializer&lt;[P](parse.md)&gt; = serializer(), decoder: [Decoder](../../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-decoder/index.md) = Base64UrlDecoder()): [JWT](../index.md)&lt;[H](parse.md), [P](parse.md)&gt;

Parses the provided [String](parse.md) representing an encoded JWT. This function returns a decoded and deserialized [JWT](../index.md) from the provided [value](parse.md) if parsing was successful.

Note that if the provided [value](parse.md) includes a JWS, and it is desired to retain that information, use the [JWS.Companion.parse](../../-j-w-s/-companion/parse.md) function instead, as that will return a [JWS](../../-j-w-s/index.md) instance. If a signature is detected in the [value](parse.md), this function will internally delegate to the [JWS.Companion.parse](../../-j-w-s/-companion/parse.md) function, but the type returned from this function is still [JWT](../index.md).

#### Parameters

common

| | |
|---|---|
| value | The compacted and encoded [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) JSON Web Token. |
| json | The Json instance used for deserializing JSON [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) values into Kotlin types. |
| headerSerializer | The KSerializer used to deserialize the [Header](../../-header/index.md) type [H](parse.md). |
| payloadSerializer | The KSerializer used to deserialize the [Payload](../../-payload/index.md) type [P](parse.md). |
| decoder | The [Decoder](../../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-decoder/index.md) used to Base64 URL decode the sub-values within the [value](parse.md) JWT [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html). If the provided [Decoder](../../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-decoder/index.md) does not properly handle Base64 URL decoding, behavior is undefined. |
