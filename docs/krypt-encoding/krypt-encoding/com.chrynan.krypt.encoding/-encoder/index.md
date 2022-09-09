//[krypt-encoding](../../../index.md)/[com.chrynan.krypt.encoding](../index.md)/[Encoder](index.md)

# Encoder

[common]\
interface [Encoder](index.md)

A utility that can convert a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) input type in one format to either a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) or [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) type in another format. An [Encoder](index.md) will data to a particular, whereas, a [Decoder](../-decoder/index.md) will decode from that format into the original format.

## Functions

| Name | Summary |
|---|---|
| [encodeToByteArray](encode-to-byte-array.md) | [common]<br>abstract fun [encodeToByteArray](encode-to-byte-array.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Encodes the provided [source](encode-to-byte-array.md) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the format this encoder supports. |
| [encodeToString](encode-to-string.md) | [common]<br>abstract fun [encodeToString](encode-to-string.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Encodes the provided [source](encode-to-string.md) into a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the format this encoder supports. Note that the character encoding of the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) return value is defined by this encoder implementation. |

## Inheritors

| Name |
|---|
| [Base64Encoder](../-base64-encoder/index.md) |
| [BitEncoder](../-bit-encoder/index.md) |
| [ByteStringEncoder](../-byte-string-encoder/index.md) |
| [HexEncoder](../-hex-encoder/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [encodeUtf8ToByteArray](../encode-utf8-to-byte-array.md) | [common]<br>fun [Encoder](index.md).[encodeUtf8ToByteArray](../encode-utf8-to-byte-array.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Encodes the provided UTF-8 formatted [String](../encode-utf8-to-byte-array.md) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the format this encoder supports. |
| [encodeUtf8ToString](../encode-utf8-to-string.md) | [common]<br>fun [Encoder](index.md).[encodeUtf8ToString](../encode-utf8-to-string.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Encodes the provided UTF-8 formatted [String](../encode-utf8-to-string.md) into a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the format this encoder supports. Note that the character encoding of the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) return value is defined by this encoder implementation. |
