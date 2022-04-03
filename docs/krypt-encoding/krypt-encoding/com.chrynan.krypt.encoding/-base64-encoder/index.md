//[krypt-encoding](../../../index.md)/[com.chrynan.krypt.encoding](../index.md)/[Base64Encoder](index.md)

# Base64Encoder

[common]\
interface [Base64Encoder](index.md) : [Encoder](../-encoder/index.md), [ByteStringEncoder](../-byte-string-encoder/index.md)

A Base64 [Encoder](../-encoder/index.md).

## See also

common

| | |
|---|---|
|  | [Wikipedia explanation](https://en.wikipedia.org/wiki/Base64) |

## Functions

| Name | Summary |
|---|---|
| [encodeToByteArray](encode-to-byte-array.md) | [common]<br>open fun [encodeToByteArray](encode-to-byte-array.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Converts a UTF-8 character encoded [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) into a Base64 [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) representation.<br>[common]<br>open fun [encodeToByteArray](../-byte-string-encoder/encode-to-byte-array.md)(source: ByteString): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>[common]<br>abstract fun [encodeToByteArray](../-encoder/encode-to-byte-array.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Encodes the provided [source](../-encoder/encode-to-byte-array.md) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the format this encoder supports. |
| [encodeToString](encode-to-string.md) | [common]<br>open fun [encodeToString](encode-to-string.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Converts a UTF-8 character encoded [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) into a Base64 [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) representation.<br>[common]<br>open fun [encodeToString](../-byte-string-encoder/encode-to-string.md)(source: ByteString): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>[common]<br>abstract fun [encodeToString](../-encoder/encode-to-string.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Encodes the provided [source](../-encoder/encode-to-string.md) into a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the format this encoder supports. Note that the character encoding of the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) return value is defined by this encoder implementation. |

## Properties

| Name | Summary |
|---|---|
| [type](type.md) | [common]<br>abstract val [type](type.md): [Base64Type](../-base64-type/index.md)<br>The [Base64Type](../-base64-type/index.md) of encoding this encoder performs. |
