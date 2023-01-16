//[krypt-encoding](../../../index.md)/[com.chrynan.krypt.encoding](../index.md)/[BitEncoder](index.md)

# BitEncoder

[common]\
class [BitEncoder](index.md)(byteGroupSeparator: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot; &quot;, convertToUByte: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, padWithZeros: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, removeSign: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) : [Encoder](../-encoder/index.md)

An [Encoder](../-encoder/index.md) that encodes a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) into a bit [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value. For example: &quot;11111111 00000000&quot;.

## Constructors

| | |
|---|---|
| [BitEncoder](-bit-encoder.md) | [common]<br>fun [BitEncoder](-bit-encoder.md)(byteGroupSeparator: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot; &quot;, convertToUByte: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, padWithZeros: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, removeSign: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) |

## Functions

| Name | Summary |
|---|---|
| [encodeToByteArray](encode-to-byte-array.md) | [common]<br>open override fun [encodeToByteArray](encode-to-byte-array.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Encodes the provided [source](encode-to-byte-array.md) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the format this encoder supports. |
| [encodeToString](encode-to-string.md) | [common]<br>open override fun [encodeToString](encode-to-string.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Encodes the provided [source](encode-to-string.md) into a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the format this encoder supports. Note that the character encoding of the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) return value is defined by this encoder implementation. |

## Extensions

| Name | Summary |
|---|---|
| [encodeUtf8ToByteArray](../encode-utf8-to-byte-array.md) | [common]<br>fun [Encoder](../-encoder/index.md).[encodeUtf8ToByteArray](../encode-utf8-to-byte-array.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Encodes the provided UTF-8 formatted [String](../encode-utf8-to-byte-array.md) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the format this encoder supports. |
| [encodeUtf8ToString](../encode-utf8-to-string.md) | [common]<br>fun [Encoder](../-encoder/index.md).[encodeUtf8ToString](../encode-utf8-to-string.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Encodes the provided UTF-8 formatted [String](../encode-utf8-to-string.md) into a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the format this encoder supports. Note that the character encoding of the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) return value is defined by this encoder implementation. |
