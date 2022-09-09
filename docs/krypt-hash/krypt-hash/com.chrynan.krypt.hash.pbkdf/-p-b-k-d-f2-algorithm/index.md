//[krypt-hash](../../../index.md)/[com.chrynan.krypt.hash.pbkdf](../index.md)/[PBKDF2Algorithm](index.md)

# PBKDF2Algorithm

[common]\
data class [PBKDF2Algorithm](index.md) : [HashAlgorithm](../../com.chrynan.krypt.hash/-hash-algorithm/index.md)

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isCompatible](../../com.chrynan.krypt.hash/-hash-algorithm/is-compatible.md) | [common]<br>open fun [isCompatible](../../com.chrynan.krypt.hash/-hash-algorithm/is-compatible.md)(other: [HashAlgorithm](../../com.chrynan.krypt.hash/-hash-algorithm/index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines whether this [HashAlgorithm](../../com.chrynan.krypt.hash/-hash-algorithm/index.md) is compatible with the provided [other](../../com.chrynan.krypt.hash/-hash-algorithm/index.md). |

## Properties

| Name | Summary |
|---|---|
| [dkLength](dk-length.md) | [common]<br>val [dkLength](dk-length.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [hLength](h-length.md) | [common]<br>val [hLength](h-length.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [iterationCount](iteration-count.md) | [common]<br>val [iterationCount](iteration-count.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [name](name.md) | [common]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) name of the algorithm. |
| [salt](salt.md) | [common]<br>val [salt](salt.md): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) |
| [version](version.md) | [common]<br>open override val [version](version.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) version of the algorithm. |
