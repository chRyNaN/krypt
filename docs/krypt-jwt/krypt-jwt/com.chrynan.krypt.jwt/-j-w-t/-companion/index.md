//[krypt-jwt](../../../../index.md)/[com.chrynan.krypt.jwt](../../index.md)/[JWT](../index.md)/[Companion](index.md)

# Companion

[common]\
object [Companion](index.md)

## Functions

| Name | Summary |
|---|---|
| [parse](parse.md) | [common]<br>inline fun &lt;[H](parse.md) : [Header](../../-header/index.md), [P](parse.md) : [Payload](../../-payload/index.md)&gt; [parse](parse.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), json: Json = Json, headerSerializer: KSerializer&lt;[H](parse.md)&gt; = serializer(), payloadSerializer: KSerializer&lt;[P](parse.md)&gt; = serializer(), decoder: [Decoder](../../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-decoder/index.md) = Base64UrlDecoder()): [JWT](../index.md)&lt;[H](parse.md), [P](parse.md)&gt;<br>Parses the provided [String](parse.md) representing an encoded JWT. This function returns a decoded and deserialized [JWT](../index.md) from the provided [value](parse.md) if parsing was successful. |
