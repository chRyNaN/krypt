//[krypt-hash](../../../../index.md)/[com.chrynan.krypt.hash.sha](../../index.md)/[SHA2HashFunction](../index.md)/[SupportedAlgorithm](index.md)

# SupportedAlgorithm

[common]\
enum [SupportedAlgorithm](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[SHA2HashFunction.SupportedAlgorithm](index.md)&gt; , [HashAlgorithm](../../../com.chrynan.krypt.hash/-hash-algorithm/index.md)

The supported variants of the SHA-2 algorithm that the [SHA2HashFunction](../index.md) implements.

## Entries

| | |
|---|---|
| [SHA_224](-s-h-a_224/index.md) | [common]<br>[SHA_224](-s-h-a_224/index.md) |
| [SHA_256](-s-h-a_256/index.md) | [common]<br>[SHA_256](-s-h-a_256/index.md) |
| [SHA_384](-s-h-a_384/index.md) | [common]<br>[SHA_384](-s-h-a_384/index.md) |
| [SHA_512](-s-h-a_512/index.md) | [common]<br>[SHA_512](-s-h-a_512/index.md) |

## Functions

| Name | Summary |
|---|---|
| [isCompatible](../../../com.chrynan.krypt.hash/-hash-algorithm/is-compatible.md) | [common]<br>open fun [isCompatible](../../../com.chrynan.krypt.hash/-hash-algorithm/is-compatible.md)(other: [HashAlgorithm](../../../com.chrynan.krypt.hash/-hash-algorithm/index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines whether this [HashAlgorithm](../../../com.chrynan.krypt.hash/-hash-algorithm/index.md) is compatible with the provided [other](../../../com.chrynan.krypt.hash/-hash-algorithm/index.md). |

## Properties

| Name | Summary |
|---|---|
| [algorithmName](algorithm-name.md) | [common]<br>val [algorithmName](algorithm-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [name](-s-h-a_512/index.md#-372974862%2FProperties%2F-1850566401) | [common]<br>val [name](-s-h-a_512/index.md#-372974862%2FProperties%2F-1850566401): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](-s-h-a_512/index.md#-739389684%2FProperties%2F-1850566401) | [common]<br>val [ordinal](-s-h-a_512/index.md#-739389684%2FProperties%2F-1850566401): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [version](version.md) | [common]<br>open override val [version](version.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) version of the algorithm. |
