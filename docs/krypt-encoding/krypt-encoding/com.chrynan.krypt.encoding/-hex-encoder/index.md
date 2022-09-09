//[krypt-encoding](../../../index.md)/[com.chrynan.krypt.encoding](../index.md)/[HexEncoder](index.md)

# HexEncoder

[common]\
class [HexEncoder](index.md)(lowercase: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) : [Encoder](../-encoder/index.md)

An [Encoder](../-encoder/index.md) that encodes a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) into a hexadecimal [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value.

## Constructors

| | |
|---|---|
| [HexEncoder](-hex-encoder.md) | [common]<br>fun [HexEncoder](-hex-encoder.md)(lowercase: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [encodeToByteArray](encode-to-byte-array.md) | [common]<br>open override fun [encodeToByteArray](encode-to-byte-array.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Encodes the provided [source](encode-to-byte-array.md) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the format this encoder supports. |
| [encodeToString](encode-to-string.md) | [common]<br>open override fun [encodeToString](encode-to-string.md)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Encodes the provided [source](encode-to-string.md) into a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) in the format this encoder supports. Note that the character encoding of the [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) return value is defined by this encoder implementation. |
