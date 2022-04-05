//[krypt-encoding](../../index.md)/[com.chrynan.krypt.encoding](index.md)

# Package com.chrynan.krypt.encoding

## Types

| Name | Summary |
|---|---|
| [Base64Decoder](-base64-decoder/index.md) | [common]<br>interface [Base64Decoder](-base64-decoder/index.md) : [Decoder](-decoder/index.md), [ByteStringDecoder](-byte-string-decoder/index.md)<br>A Base64 [Decoder](-decoder/index.md). |
| [Base64Encoder](-base64-encoder/index.md) | [common]<br>interface [Base64Encoder](-base64-encoder/index.md) : [Encoder](-encoder/index.md), [ByteStringEncoder](-byte-string-encoder/index.md)<br>A Base64 [Encoder](-encoder/index.md). |
| [Base64Type](-base64-type/index.md) | [common]<br>enum [Base64Type](-base64-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[Base64Type](-base64-type/index.md)&gt; <br>The type of characters used in Base 64 encoding/decoding. |
| [ByteStringDecoder](-byte-string-decoder/index.md) | [common]<br>interface [ByteStringDecoder](-byte-string-decoder/index.md) : [Decoder](-decoder/index.md)<br>An [Decoder](-decoder/index.md) that has overloaded functions for decoding ByteStrings. |
| [ByteStringEncoder](-byte-string-encoder/index.md) | [common]<br>interface [ByteStringEncoder](-byte-string-encoder/index.md) : [Encoder](-encoder/index.md)<br>An [Encoder](-encoder/index.md) that has overloaded functions for encoding ByteStrings. |
| [Decoder](-decoder/index.md) | [common]<br>interface [Decoder](-decoder/index.md)<br>A utility that can convert a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) input type in one format to either a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) or [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) type in another format. An [Encoder](-encoder/index.md) will encode data to a particular, whereas, a [Decoder](-decoder/index.md) will decode from that format into the original format. |
| [Encoder](-encoder/index.md) | [common]<br>interface [Encoder](-encoder/index.md)<br>A utility that can convert a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) input type in one format to either a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) or [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) type in another format. An [Encoder](-encoder/index.md) will data to a particular, whereas, a [Decoder](-decoder/index.md) will decode from that format into the original format. |

## Functions

| Name | Summary |
|---|---|
| [Base64Decoder](-base64-decoder.md) | [common]<br>fun [Base64Decoder](-base64-decoder.md)(isWithPadding: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): [Base64Decoder](-base64-decoder/index.md)<br>Creates a [Base64Decoder](-base64-decoder/index.md) with the [Base64Type.DEFAULT](-base64-type/-d-e-f-a-u-l-t/index.md) type.<br>[android, jvm]<br>[android]<br>fun [Base64Decoder](-base64-decoder.md)(type: [Base64Type](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-base64-type/index.md), charset: [Charset](https://developer.android.com/reference/kotlin/java/nio/charset/Charset.html)): [Base64Decoder](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-base64-decoder/index.md)<br>[jvm]<br>fun [Base64Decoder](-base64-decoder.md)(type: [Base64Type](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-base64-type/index.md), isWithPadding: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, charset: [Charset](https://developer.android.com/reference/kotlin/java/nio/charset/Charset.html)): [Base64Decoder](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-base64-decoder/index.md) |
| [Base64Encoder](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-base64-encoder.md) | [common]<br>fun [Base64Encoder](-base64-encoder.md)(isWithPadding: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): [Base64Encoder](-base64-encoder/index.md)<br>Creates a [Base64Encoder](-base64-encoder/index.md) with the [Base64Type.DEFAULT](-base64-type/-d-e-f-a-u-l-t/index.md) type.<br>[android, jvm]<br>[android]<br>fun [Base64Encoder]([android]-base64-encoder.md)(type: [Base64Type](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-base64-type/index.md), isWithPadding: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), charset: [Charset](https://developer.android.com/reference/kotlin/java/nio/charset/Charset.html)): [Base64Encoder](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-base64-encoder/index.md)<br>[jvm]<br>fun [Base64Encoder]([jvm]-base64-encoder.md)(type: [Base64Type](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-base64-type/index.md), isWithPadding: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), charset: [Charset](https://developer.android.com/reference/kotlin/java/nio/charset/Charset.html)): [Base64Encoder](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-base64-encoder/index.md) |
| [Base64MimeDecoder](-base64-mime-decoder.md) | [common]<br>fun [Base64MimeDecoder](-base64-mime-decoder.md)(isWithPadding: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): [Base64Decoder](-base64-decoder/index.md)<br>Creates a [Base64Decoder](-base64-decoder/index.md) with the [Base64Type.MIME](-base64-type/-m-i-m-e/index.md) type. |
| [Base64MimeEncoder](-base64-mime-encoder.md) | [common]<br>fun [Base64MimeEncoder](-base64-mime-encoder.md)(isWithPadding: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): [Base64Encoder](-base64-encoder/index.md)<br>Creates a [Base64Encoder](-base64-encoder/index.md) with the [Base64Type.MIME](-base64-type/-m-i-m-e/index.md) type. |
| [Base64UrlDecoder](-base64-url-decoder.md) | [common]<br>fun [Base64UrlDecoder](-base64-url-decoder.md)(isWithPadding: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): [Base64Decoder](-base64-decoder/index.md)<br>Creates a [Base64Decoder](-base64-decoder/index.md) with the [Base64Type.URL](-base64-type/-u-r-l/index.md) type. |
| [Base64UrlEncoder](-base64-url-encoder.md) | [common]<br>fun [Base64UrlEncoder](-base64-url-encoder.md)(isWithPadding: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): [Base64Encoder](-base64-encoder/index.md)<br>Creates a [Base64Encoder](-base64-encoder/index.md) with the [Base64Type.URL](-base64-type/-u-r-l/index.md) type. |