//[krypt-jwt](../../index.md)/[com.chrynan.krypt.jwt](index.md)/[signatureUtf8](signature-utf8.md)

# signatureUtf8

[common]\
fun &lt;[H](signature-utf8.md) : [Header](-header/index.md), [P](signature-utf8.md) : [Payload](-payload/index.md)&gt; [JWS](-j-w-s/index.md)&lt;[H](signature-utf8.md), [P](signature-utf8.md)&gt;.[signatureUtf8](signature-utf8.md)(decoder: [Decoder](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-decoder/index.md) = Base64UrlDecoder()): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Decodes this [JWS](-j-w-s/index.md) Base64 URL Encoded [JWS.signature](-j-w-s/signature.md) value as a UTF-8 encoded [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).
