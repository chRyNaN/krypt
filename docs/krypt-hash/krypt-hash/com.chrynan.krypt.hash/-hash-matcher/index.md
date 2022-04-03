//[krypt-hash](../../../index.md)/[com.chrynan.krypt.hash](../index.md)/[HashMatcher](index.md)

# HashMatcher

[common]\
interface [HashMatcher](index.md)&lt;[Algorithm](index.md) : [HashAlgorithm](../-hash-algorithm/index.md), [Input](index.md), [Hash](index.md), [Result](index.md) : [HashResult](../-hash-result/index.md)&lt;[Algorithm](index.md), [Hash](index.md)&gt;&gt;

A utility to determine whether an [Input](index.md) matches a [Result](index.md). This utility will perform the hash function with a provided [Input](index.md) and compare that result with the provided [Result](index.md) to determine if the values match.

## Functions

| Name | Summary |
|---|---|
| [matches](matches.md) | [common]<br>abstract suspend fun [matches](matches.md)(source: [Input](index.md), result: [Result](index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Performs the hash function on the provided [source](matches.md) to obtain its result and compares it with the provided [result](matches.md) to determine if the values match. |

## Properties

| Name | Summary |
|---|---|
| [algorithm](algorithm.md) | [common]<br>abstract val [algorithm](algorithm.md): [Algorithm](index.md)<br>The algorithm this [HashMatcher](index.md) uses. |

## Inheritors

| Name |
|---|
| [Hasher](../-hasher/index.md) |
