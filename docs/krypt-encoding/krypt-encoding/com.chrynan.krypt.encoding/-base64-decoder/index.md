//[krypt-encoding](../../../index.md)/[com.chrynan.krypt.encoding](../index.md)/[Base64Decoder](index.md)

# Base64Decoder

[common]\
interface [Base64Decoder](index.md) : [Decoder](../-decoder/index.md), [ByteStringDecoder](../-byte-string-decoder/index.md)

A Base64 [Decoder](../-decoder/index.md).

## See also

common

| | |
|---|---|
|  | [Wikipedia explanation](https://en.wikipedia.org/wiki/Base64) |

## Functions

| Name | Summary |
|---|---|
| [decodeToByteArray](decode-to-byte-array.md) | [common]<br>open fun [decodeToByteArray](decode-to-byte-array.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Converts a Base64 encoded [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) representation.<br>[common]<br>open fun [decodeToByteArray](../-byte-string-decoder/decode-to-byte-array.md)(source: ByteString): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>[common]<br>abstract fun [decodeToByteArray](../-decoder/decode-to-byte-array.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Decodes the provided [source](../-decoder/decode-to-byte-array.md) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the format this decoder supports. |
| [decodeToString](decode-to-string.md) | [common]<br>open fun [decodeToString](decode-to-string.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Converts a Base64 encoded [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) into a UTF-8 character encoded [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) representation.<br>[common]<br>open fun [decodeToString](../-byte-string-decoder/decode-to-string.md)(source: ByteString): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>[common]<br>abstract fun [decodeToString](../-decoder/decode-to-string.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Decodes the provided [source](../-decoder/decode-to-string.md) into a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the format this decoder supports. Note that the character encoding of the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) return value is defined by this decoder implementation. |

## Properties

| Name | Summary |
|---|---|
| [type](type.md) | [common]<br>abstract val [type](type.md): [Base64Type](../-base64-type/index.md)<br>The [Base64Type](../-base64-type/index.md) of decoding this decoder performs. |
