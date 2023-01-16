//[krypt-encoding](../../../index.md)/[com.chrynan.krypt.encoding](../index.md)/[ByteStringDecoder](index.md)

# ByteStringDecoder

[common]\
interface [ByteStringDecoder](index.md) : [Decoder](../-decoder/index.md)

An [Decoder](../-decoder/index.md) that has overloaded functions for decoding ByteStrings.

## Functions

| Name | Summary |
|---|---|
| [decodeToByteArray](decode-to-byte-array.md) | [common]<br>open fun [decodeToByteArray](decode-to-byte-array.md)(source: ByteString): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>[common]<br>abstract fun [decodeToByteArray](../-decoder/decode-to-byte-array.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Decodes the provided [source](../-decoder/decode-to-byte-array.md) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the format this decoder supports. |
| [decodeToString](decode-to-string.md) | [common]<br>open fun [decodeToString](decode-to-string.md)(source: ByteString): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>[common]<br>abstract fun [decodeToString](../-decoder/decode-to-string.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Decodes the provided [source](../-decoder/decode-to-string.md) into a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the format this decoder supports. Note that the character encoding of the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) return value is defined by this decoder implementation. |

## Inheritors

| Name |
|---|
| [Base64Decoder](../-base64-decoder/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [decodeUtf8ToByteArray](../decode-utf8-to-byte-array.md) | [common]<br>fun [Decoder](../-decoder/index.md).[decodeUtf8ToByteArray](../decode-utf8-to-byte-array.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Decodes the provided UTF-8 formatted [String](../decode-utf8-to-byte-array.md) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the format this decoder supports. |
| [decodeUtf8ToString](../decode-utf8-to-string.md) | [common]<br>fun [Decoder](../-decoder/index.md).[decodeUtf8ToString](../decode-utf8-to-string.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Decodes the provided UTF-8 formatted [String](../decode-utf8-to-string.md) into a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the format this decoder supports. Note that the character encoding of the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) return value is defined by this decoder implementation. |
