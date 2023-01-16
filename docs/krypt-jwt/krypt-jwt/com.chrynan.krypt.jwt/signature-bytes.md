//[krypt-jwt](../../index.md)/[com.chrynan.krypt.jwt](index.md)/[signatureBytes](signature-bytes.md)

# signatureBytes

[common]\
fun &lt;[H](signature-bytes.md) : [Header](-header/index.md), [P](signature-bytes.md) : [Payload](-payload/index.md)&gt; [JWS](-j-w-s/index.md)&lt;[H](signature-bytes.md), [P](signature-bytes.md)&gt;.[signatureBytes](signature-bytes.md)(decoder: [Decoder](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-decoder/index.md) = Base64UrlDecoder()): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)

Decodes this [JWS](-j-w-s/index.md) Base64 URL Encoded [JWS.signature](-j-w-s/signature.md) value as a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html).
