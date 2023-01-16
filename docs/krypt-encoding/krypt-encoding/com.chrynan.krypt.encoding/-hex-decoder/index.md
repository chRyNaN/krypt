//[krypt-encoding](../../../index.md)/[com.chrynan.krypt.encoding](../index.md)/[HexDecoder](index.md)

# HexDecoder

[common]\
class [HexDecoder](index.md) : [Decoder](../-decoder/index.md)

A [Decoder](../-decoder/index.md) that decodes a hexadecimal formatted [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html). Use the [decodeToByteArray](decode-to-byte-array.md) function for proper decoding.

## Constructors

| | |
|---|---|
| [HexDecoder](-hex-decoder.md) | [common]<br>fun [HexDecoder](-hex-decoder.md)() |

## Functions

| Name | Summary |
|---|---|
| [decodeToByteArray](decode-to-byte-array.md) | [common]<br>open override fun [decodeToByteArray](decode-to-byte-array.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Decodes the provided [source](decode-to-byte-array.md) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the format this decoder supports.<br>[common]<br>fun [decodeToByteArray](decode-to-byte-array.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) |
| [decodeToString](decode-to-string.md) | [common]<br>open override fun [decodeToString](decode-to-string.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Decodes the provided [source](decode-to-string.md) into a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the format this decoder supports. Note that the character encoding of the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) return value is defined by this decoder implementation. |

## Extensions

| Name | Summary |
|---|---|
| [decodeUtf8ToByteArray](../decode-utf8-to-byte-array.md) | [common]<br>fun [Decoder](../-decoder/index.md).[decodeUtf8ToByteArray](../decode-utf8-to-byte-array.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Decodes the provided UTF-8 formatted [String](../decode-utf8-to-byte-array.md) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the format this decoder supports. |
| [decodeUtf8ToString](../decode-utf8-to-string.md) | [common]<br>fun [Decoder](../-decoder/index.md).[decodeUtf8ToString](../decode-utf8-to-string.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Decodes the provided UTF-8 formatted [String](../decode-utf8-to-string.md) into a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the format this decoder supports. Note that the character encoding of the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) return value is defined by this decoder implementation. |
