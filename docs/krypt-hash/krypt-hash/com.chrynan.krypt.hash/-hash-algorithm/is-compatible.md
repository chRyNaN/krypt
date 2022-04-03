//[krypt-hash](../../../index.md)/[com.chrynan.krypt.hash](../index.md)/[HashAlgorithm](index.md)/[isCompatible](is-compatible.md)

# isCompatible

[common]\
open fun [isCompatible](is-compatible.md)(other: [HashAlgorithm](index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Determines whether this [HashAlgorithm](index.md) is compatible with the provided [other](index.md).

The default implementation compares the [name](name.md) and [version](version.md) of the properties.
