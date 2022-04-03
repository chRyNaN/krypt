//[krypt-encoding](../../../index.md)/[com.chrynan.krypt.encoding](../index.md)/[ByteStringEncoder](index.md)

# ByteStringEncoder

[common]\
interface [ByteStringEncoder](index.md) : [Encoder](../-encoder/index.md)

An [Encoder](../-encoder/index.md) that has overloaded functions for encoding ByteStrings.

## Functions

| Name | Summary |
|---|---|
| [encodeToByteArray](encode-to-byte-array.md) | [common]<br>open fun [encodeToByteArray](encode-to-byte-array.md)(source: ByteString): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>[common]<br>abstract fun [encodeToByteArray](../-encoder/encode-to-byte-array.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Encodes the provided [source](../-encoder/encode-to-byte-array.md) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the format this encoder supports. |
| [encodeToString](encode-to-string.md) | [common]<br>open fun [encodeToString](encode-to-string.md)(source: ByteString): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>[common]<br>abstract fun [encodeToString](../-encoder/encode-to-string.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Encodes the provided [source](../-encoder/encode-to-string.md) into a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the format this encoder supports. Note that the character encoding of the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) return value is defined by this encoder implementation. |

## Inheritors

| Name |
|---|
| [Base64Encoder](../-base64-encoder/index.md) |
