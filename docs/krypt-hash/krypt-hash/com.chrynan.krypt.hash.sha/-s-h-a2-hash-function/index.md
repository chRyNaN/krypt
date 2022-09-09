//[krypt-hash](../../../index.md)/[com.chrynan.krypt.hash.sha](../index.md)/[SHA2HashFunction](index.md)

# SHA2HashFunction

[common]\
interface [SHA2HashFunction](index.md) : [HashFunction](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-hash-function/index.md)&lt;[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt; 

An SHA-2 [HashFunction](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-hash-function/index.md) implementation. The supported variants of the SHA-2 algorithm are defined in the [SupportedAlgorithm](-supported-algorithm/index.md) enum class. To utilize this hashing algorithm, use the [SHA2Hasher](../-s-h-a2-hasher/index.md) interface and one of its factory functions, such as [sha256](../sha256.md).

## See also

common

| | |
|---|---|
|  | [FIPS 180-4](https://nvlpubs.nist.gov/nistpubs/FIPS/NIST.FIPS.180-4.pdf) |
| [com.chrynan.krypt.hash.sha.SHA2Hasher](../-s-h-a2-hasher/index.md) |  |
| [sha256](../sha256.md) |  |

## Types

| Name | Summary |
|---|---|
| [SupportedAlgorithm](-supported-algorithm/index.md) | [common]<br>enum [SupportedAlgorithm](-supported-algorithm/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[SHA2HashFunction.SupportedAlgorithm](-supported-algorithm/index.md)&gt; , [HashAlgorithm](../../com.chrynan.krypt.hash/-hash-algorithm/index.md)<br>The supported variants of the SHA-2 algorithm that the [SHA2HashFunction](index.md) implements. |

## Functions

| Name | Summary |
|---|---|
| [invoke](../-s-h-a2-hasher/index.md#1151892548%2FFunctions%2F-1850566401) | [common]<br>abstract suspend operator fun [invoke](../-s-h-a2-hasher/index.md#1151892548%2FFunctions%2F-1850566401)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) |

## Properties

| Name | Summary |
|---|---|
| [algorithm](algorithm.md) | [common]<br>abstract val [algorithm](algorithm.md): [SHA2HashFunction.SupportedAlgorithm](-supported-algorithm/index.md) |
| [algorithmName](algorithm-name.md) | [common]<br>open override val [algorithmName](algorithm-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
