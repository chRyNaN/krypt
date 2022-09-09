//[krypt-hash](../../../index.md)/[com.chrynan.krypt.hash.sha](../index.md)/[SHA2Hasher](index.md)

# SHA2Hasher

[common]\
interface [SHA2Hasher](index.md) : [ByteHasher](../../com.chrynan.krypt.hash/-byte-hasher/index.md)&lt;[SHA2HashFunction.SupportedAlgorithm](../-s-h-a2-hash-function/-supported-algorithm/index.md), [SHA2HashResult](../-s-h-a2-hash-result/index.md)&gt; 

A [ByteHasher](../../com.chrynan.krypt.hash/-byte-hasher/index.md) that uses one of the variants of the SHA-2 algorithm. To create an instance of this class, use one of the factory functions, such as [sha256](../sha256.md).

## See also

common

| | |
|---|---|
| [sha256](../sha256.md) |  |
| [com.chrynan.krypt.hash.sha.SHA2HashFunction](../-s-h-a2-hash-function/index.md) |  |
|  | [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [invoke](index.md#1151892548%2FFunctions%2F-1850566401) | [common]<br>abstract suspend operator fun [invoke](index.md#1151892548%2FFunctions%2F-1850566401)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [SHA2HashResult](../-s-h-a2-hash-result/index.md) |
| [matches](index.md#1555216721%2FFunctions%2F-1850566401) | [common]<br>open suspend override fun [matches](index.md#1555216721%2FFunctions%2F-1850566401)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), result: [SHA2HashResult](../-s-h-a2-hash-result/index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Performs the hash function on the provided [source](index.md#1555216721%2FFunctions%2F-1850566401) to obtain its result and compares it with the provided [result](index.md#1555216721%2FFunctions%2F-1850566401) to determine if the values match. |

## Properties

| Name | Summary |
|---|---|
| [algorithm](../../com.chrynan.krypt.hash/-hasher/algorithm.md) | [common]<br>abstract override val [algorithm](../../com.chrynan.krypt.hash/-hasher/algorithm.md): [SHA2HashFunction.SupportedAlgorithm](../-s-h-a2-hash-function/-supported-algorithm/index.md)<br>The algorithm this [HashEncoder](../../com.chrynan.krypt.hash/-hash-encoder/index.md) uses. |
| [algorithmName](../../com.chrynan.krypt.hash/-hash-encoder/algorithm-name.md) | [common]<br>open override val [algorithmName](../../com.chrynan.krypt.hash/-hash-encoder/algorithm-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
