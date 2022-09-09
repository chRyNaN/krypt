//[krypt-hash](../../../index.md)/[com.chrynan.krypt.hash](../index.md)/[ByteHasher](index.md)

# ByteHasher

[common]\
interface [ByteHasher](index.md)&lt;[Algorithm](index.md) : [HashAlgorithm](../-hash-algorithm/index.md), [Result](index.md) : [HashResult](../-hash-result/index.md)&lt;[Algorithm](index.md), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;&gt; : [Hasher](../-hasher/index.md)&lt;[Algorithm](index.md), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), [Result](index.md)&gt; 

A specialized and commonly used [Hasher](../-hasher/index.md) that operates on an input type of [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) and outputs a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) in the result.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [invoke](../../com.chrynan.krypt.hash.sha/-s-h-a2-hasher/index.md#1151892548%2FFunctions%2F-1850566401) | [common]<br>abstract suspend operator fun [invoke](../../com.chrynan.krypt.hash.sha/-s-h-a2-hasher/index.md#1151892548%2FFunctions%2F-1850566401)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [Result](index.md) |
| [matches](index.md#1134775892%2FFunctions%2F-1850566401) | [common]<br>open suspend override fun [matches](index.md#1134775892%2FFunctions%2F-1850566401)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), result: [Result](index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Performs the hash function on the provided [source](index.md#1134775892%2FFunctions%2F-1850566401) to obtain its result and compares it with the provided [result](index.md#1134775892%2FFunctions%2F-1850566401) to determine if the values match. |

## Properties

| Name | Summary |
|---|---|
| [algorithm](../-hasher/algorithm.md) | [common]<br>abstract override val [algorithm](../-hasher/algorithm.md): [Algorithm](index.md)<br>The algorithm this [HashEncoder](../-hash-encoder/index.md) uses. |
| [algorithmName](../-hash-encoder/algorithm-name.md) | [common]<br>open override val [algorithmName](../-hash-encoder/algorithm-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Inheritors

| Name |
|---|
| [PBKDF2Hasher](../../com.chrynan.krypt.hash.pbkdf/-p-b-k-d-f2-hasher/index.md) |
| [SHA2Hasher](../../com.chrynan.krypt.hash.sha/-s-h-a2-hasher/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [hash](../hash.md) | [common]<br>suspend fun &lt;[Algorithm](../hash.md) : [HashAlgorithm](../-hash-algorithm/index.md), [Result](../hash.md) : [HashResult](../-hash-result/index.md)&lt;[Algorithm](../hash.md), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;&gt; [ByteHasher](index.md)&lt;[Algorithm](../hash.md), [Result](../hash.md)&gt;.[hash](../hash.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Result](../hash.md)<br>A convenience function that calls the [ByteHasher.hash](../../../../krypt-core/com.chrynan.krypt.core/index.md) function with the provided [source](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value encoded to a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) using the [encodeToByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index.html) function. This encodes the provided [source](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) as a UTF-8 [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html). |
| [invoke](../invoke.md) | [common]<br>suspend fun &lt;[Algorithm](../invoke.md) : [HashAlgorithm](../-hash-algorithm/index.md), [Result](../invoke.md) : [HashResult](../-hash-result/index.md)&lt;[Algorithm](../invoke.md), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;&gt; [ByteHasher](index.md)&lt;[Algorithm](../invoke.md), [Result](../invoke.md)&gt;.[invoke](../invoke.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Result](../invoke.md)<br>A convenience function that calls the [ByteHasher.invoke](../../../../krypt-hash/com.chrynan.krypt.hash/-byte-hasher/invoke.md) function with the provided [source](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value encoded to a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) using the [encodeToByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index.html) function. This encodes the provided [source](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) as a UTF-8 [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html). |
