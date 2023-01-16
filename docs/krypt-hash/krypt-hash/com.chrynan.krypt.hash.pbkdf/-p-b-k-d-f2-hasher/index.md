//[krypt-hash](../../../index.md)/[com.chrynan.krypt.hash.pbkdf](../index.md)/[PBKDF2Hasher](index.md)

# PBKDF2Hasher

[common]\
interface [PBKDF2Hasher](index.md) : [ByteHasher](../../com.chrynan.krypt.hash/-byte-hasher/index.md)&lt;[PBKDF2Algorithm](../-p-b-k-d-f2-algorithm/index.md), [PBKDF2HashResult](../-p-b-k-d-f2-hash-result/index.md)&gt; 

A [ByteHasher](../../com.chrynan.krypt.hash/-byte-hasher/index.md) that uses the PBKDF2 (password-based key derivation function 2) algorithm. To create an instance of this use the [Hasher.Companion.pbkdf2](../pbkdf2.md) function.

#### See also

common

| | |
|---|---|
|  | [Wikipedia Explanation](https://en.wikipedia.org/wiki/PBKDF2) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [invoke](../../com.chrynan.krypt.hash.sha/-s-h-a2-hasher/index.md#1151892548%2FFunctions%2F-1850566401) | [common]<br>abstract suspend operator fun [invoke](../../com.chrynan.krypt.hash.sha/-s-h-a2-hasher/index.md#1151892548%2FFunctions%2F-1850566401)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [PBKDF2HashResult](../-p-b-k-d-f2-hash-result/index.md) |
| [matches](index.md#1199567407%2FFunctions%2F-1850566401) | [common]<br>open suspend override fun [matches](index.md#1199567407%2FFunctions%2F-1850566401)(source: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), result: [PBKDF2HashResult](../-p-b-k-d-f2-hash-result/index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Performs the hash function on the provided [source](index.md#1199567407%2FFunctions%2F-1850566401) to obtain its result and compares it with the provided [result](index.md#1199567407%2FFunctions%2F-1850566401) to determine if the values match. |

## Properties

| Name | Summary |
|---|---|
| [algorithm](../../com.chrynan.krypt.hash/-hasher/algorithm.md) | [common]<br>abstract override val [algorithm](../../com.chrynan.krypt.hash/-hasher/algorithm.md): [PBKDF2Algorithm](../-p-b-k-d-f2-algorithm/index.md)<br>The algorithm this [HashEncoder](../../com.chrynan.krypt.hash/-hash-encoder/index.md) uses. |
| [algorithmName](../../com.chrynan.krypt.hash/-hash-encoder/algorithm-name.md) | [common]<br>open override val [algorithmName](../../com.chrynan.krypt.hash/-hash-encoder/algorithm-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Extensions

| Name | Summary |
|---|---|
| [hash](../../com.chrynan.krypt.hash/hash.md) | [common]<br>suspend fun &lt;[Algorithm](../../com.chrynan.krypt.hash/hash.md) : [HashAlgorithm](../../com.chrynan.krypt.hash/-hash-algorithm/index.md), [Result](../../com.chrynan.krypt.hash/hash.md) : [HashResult](../../com.chrynan.krypt.hash/-hash-result/index.md)&lt;[Algorithm](../../com.chrynan.krypt.hash/hash.md), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;&gt; [ByteHasher](../../com.chrynan.krypt.hash/-byte-hasher/index.md)&lt;[Algorithm](../../com.chrynan.krypt.hash/hash.md), [Result](../../com.chrynan.krypt.hash/hash.md)&gt;.[hash](../../com.chrynan.krypt.hash/hash.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Result](../../com.chrynan.krypt.hash/hash.md)<br>A convenience function that calls the [ByteHasher.hash](../../../../krypt-core/com.chrynan.krypt.core/index.md) function with the provided [source](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value encoded to a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) using the [encodeToByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index.html) function. This encodes the provided [source](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) as a UTF-8 [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html). |
| [invoke](../../com.chrynan.krypt.hash/invoke.md) | [common]<br>suspend fun &lt;[Algorithm](../../com.chrynan.krypt.hash/invoke.md) : [HashAlgorithm](../../com.chrynan.krypt.hash/-hash-algorithm/index.md), [Result](../../com.chrynan.krypt.hash/invoke.md) : [HashResult](../../com.chrynan.krypt.hash/-hash-result/index.md)&lt;[Algorithm](../../com.chrynan.krypt.hash/invoke.md), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;&gt; [ByteHasher](../../com.chrynan.krypt.hash/-byte-hasher/index.md)&lt;[Algorithm](../../com.chrynan.krypt.hash/invoke.md), [Result](../../com.chrynan.krypt.hash/invoke.md)&gt;.[invoke](../../com.chrynan.krypt.hash/invoke.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Result](../../com.chrynan.krypt.hash/invoke.md)<br>A convenience function that calls the [ByteHasher.invoke](../../../../krypt-hash/com.chrynan.krypt.hash/-byte-hasher/invoke.md) function with the provided [source](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value encoded to a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) using the [encodeToByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index.html) function. This encodes the provided [source](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) as a UTF-8 [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html). |
