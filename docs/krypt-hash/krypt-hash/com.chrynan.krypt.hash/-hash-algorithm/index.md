//[krypt-hash](../../../index.md)/[com.chrynan.krypt.hash](../index.md)/[HashAlgorithm](index.md)

# HashAlgorithm

[common]\
interface [HashAlgorithm](index.md)

Defines the type of algorithm that is performed by a [Hasher](../-hasher/index.md).

## Functions

| Name | Summary |
|---|---|
| [isCompatible](is-compatible.md) | [common]<br>open fun [isCompatible](is-compatible.md)(other: [HashAlgorithm](index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines whether this [HashAlgorithm](index.md) is compatible with the provided [other](index.md). |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [common]<br>abstract val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) name of the algorithm. |
| [version](version.md) | [common]<br>abstract val [version](version.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) version of the algorithm. |
