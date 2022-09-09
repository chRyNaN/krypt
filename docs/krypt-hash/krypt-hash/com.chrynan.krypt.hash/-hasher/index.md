//[krypt-hash](../../../index.md)/[com.chrynan.krypt.hash](../index.md)/[Hasher](index.md)

# Hasher

[common]\
interface [Hasher](index.md)&lt;[Algorithm](index.md) : [HashAlgorithm](../-hash-algorithm/index.md), [Input](index.md), [Hash](index.md), [Result](index.md) : [HashResult](../-hash-result/index.md)&lt;[Algorithm](index.md), [Hash](index.md)&gt;&gt; : [HashEncoder](../-hash-encoder/index.md)&lt;[Algorithm](index.md), [Input](index.md), [Hash](index.md), [Result](index.md)&gt; , [HashMatcher](../-hash-matcher/index.md)&lt;[Algorithm](index.md), [Input](index.md), [Hash](index.md), [Result](index.md)&gt; 

A utility that is both a [HashEncoder](../-hash-encoder/index.md) and a [HashMatcher](../-hash-matcher/index.md). Different hash algorithm implementations extend this interface and provide a means of obtaining that [Hasher](index.md) implementation, typically via extension functions on the companion object.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [invoke](index.md#1807890646%2FFunctions%2F-1850566401) | [common]<br>abstract suspend operator fun [invoke](index.md#1807890646%2FFunctions%2F-1850566401)(source: [Input](index.md)): [Result](index.md) |
| [matches](matches.md) | [common]<br>open suspend override fun [matches](matches.md)(source: [Input](index.md), result: [Result](index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Performs the hash function on the provided [source](matches.md) to obtain its result and compares it with the provided [result](matches.md) to determine if the values match. |

## Properties

| Name | Summary |
|---|---|
| [algorithm](algorithm.md) | [common]<br>abstract override val [algorithm](algorithm.md): [Algorithm](index.md)<br>The algorithm this [HashEncoder](../-hash-encoder/index.md) uses. |
| [algorithmName](../-hash-encoder/algorithm-name.md) | [common]<br>open override val [algorithmName](../-hash-encoder/algorithm-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Inheritors

| Name |
|---|
| [ByteHasher](../-byte-hasher/index.md) |
