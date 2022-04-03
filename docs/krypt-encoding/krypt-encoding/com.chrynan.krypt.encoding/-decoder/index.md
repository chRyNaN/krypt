//[krypt-encoding](../../../index.md)/[com.chrynan.krypt.encoding](../index.md)/[Decoder](index.md)

# Decoder

[common]\
interface [Decoder](index.md)

A utility that can convert a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) input type in one format to either a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) or [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) type in another format. An [Encoder](../-encoder/index.md) will encode data to a particular, whereas, a [Decoder](index.md) will decode from that format into the original format.

## Functions

| Name | Summary |
|---|---|
| [decodeToByteArray](decode-to-byte-array.md) | [common]<br>abstract fun [decodeToByteArray](decode-to-byte-array.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Decodes the provided [source](decode-to-byte-array.md) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the format this decoder supports. |
| [decodeToString](decode-to-string.md) | [common]<br>abstract fun [decodeToString](decode-to-string.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Decodes the provided [source](decode-to-string.md) into a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the format this decoder supports. Note that the character encoding of the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) return value is defined by this decoder implementation. |

## Inheritors

| Name |
|---|
| [Base64Decoder](../-base64-decoder/index.md) |
| [ByteStringDecoder](../-byte-string-decoder/index.md) |
