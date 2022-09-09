//[krypt-jwt](../../index.md)/[com.chrynan.krypt.jwt](index.md)/[format](format.md)

# format

[common]\
inline fun &lt;[H](format.md) : [Header](-header/index.md), [P](format.md) : [Payload](-payload/index.md)&gt; [JWT](-j-w-t/index.md)&lt;[H](format.md), [P](format.md)&gt;.[format](format.md)(json: Json = Json, encoder: [Encoder](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md) = Base64UrlEncoder()): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

A convenience function for invoking the [JWT.format](-j-w-t/format.md) function with KSerializers obtained from the serializer function for the Header and Payload.
