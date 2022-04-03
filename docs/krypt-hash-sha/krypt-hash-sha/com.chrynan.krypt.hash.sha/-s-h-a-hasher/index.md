//[krypt-hash-sha](../../../index.md)/[com.chrynan.krypt.hash.sha](../index.md)/[SHAHasher](index.md)

# SHAHasher

[common]\
interface [SHAHasher](index.md) : [Hasher](../../../../krypt-hash/krypt-hash/com.chrynan.krypt.hash/-hasher/index.md)&lt;[SHAHashAlgorithm](../-s-h-a-hash-algorithm/index.md), [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html), [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), [SHAHashResult](../-s-h-a-hash-result/index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [invoke](index.md#1626915062%2FFunctions%2F-1775027490) | [common]<br>abstract suspend operator fun [invoke](index.md#1626915062%2FFunctions%2F-1775027490)(source: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)): [SHAHashResult](../-s-h-a-hash-result/index.md) |
| [matches](index.md#-31835078%2FFunctions%2F-1775027490) | [common]<br>abstract suspend fun [matches](index.md#-31835078%2FFunctions%2F-1775027490)(source: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html), result: [SHAHashResult](../-s-h-a-hash-result/index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

## Properties

| Name | Summary |
|---|---|
| [algorithm](index.md#-921023547%2FProperties%2F-1775027490) | [common]<br>abstract override val [algorithm](index.md#-921023547%2FProperties%2F-1775027490): [SHAHashAlgorithm](../-s-h-a-hash-algorithm/index.md) |
