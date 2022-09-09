//[krypt-hash-argon](../../../index.md)/[com.chrynan.krypt.hash.argon](../index.md)/[Argon2Hasher](index.md)

# Argon2Hasher

[common]\
interface [Argon2Hasher](index.md) : [Hasher](../../../../krypt-hash/krypt-hash/com.chrynan.krypt.hash/-hasher/index.md)&lt;[Argon2HashAlgorithm](../-argon2-hash-algorithm/index.md), [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html), [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), [Argon2HashResult](../-argon2-hash-result/index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [invoke](index.md#1626915062%2FFunctions%2F402468135) | [common]<br>abstract suspend operator fun [invoke](index.md#1626915062%2FFunctions%2F402468135)(source: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)): [Argon2HashResult](../-argon2-hash-result/index.md) |
| [matches](index.md#-2129810173%2FFunctions%2F402468135) | [common]<br>open suspend override fun [matches](index.md#-2129810173%2FFunctions%2F402468135)(source: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html), result: [Argon2HashResult](../-argon2-hash-result/index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

## Properties

| Name | Summary |
|---|---|
| [algorithm](index.md#-921023547%2FProperties%2F402468135) | [common]<br>abstract override val [algorithm](index.md#-921023547%2FProperties%2F402468135): [Argon2HashAlgorithm](../-argon2-hash-algorithm/index.md) |
| [algorithmName](index.md#1949452417%2FProperties%2F402468135) | [common]<br>open override val [algorithmName](index.md#1949452417%2FProperties%2F402468135): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
