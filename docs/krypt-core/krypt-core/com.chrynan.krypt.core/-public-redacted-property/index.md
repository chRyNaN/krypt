//[krypt-core](../../../index.md)/[com.chrynan.krypt.core](../index.md)/[PublicRedactedProperty](index.md)

# PublicRedactedProperty

[common]\
class [PublicRedactedProperty](index.md)&lt;[T](index.md)&gt;(value: [T](index.md), redactedString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), repeatCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [RedactedProperty](../-redacted-property/index.md)&lt;[T](index.md)&gt; 

A [RedactedProperty](../-redacted-property/index.md) that allows for the underlying [value](value.md) to be accessed publicly.

## Constructors

| | |
|---|---|
| [PublicRedactedProperty](-public-redacted-property.md) | [common]<br>fun &lt;[T](index.md)&gt; [PublicRedactedProperty](-public-redacted-property.md)(value: [T](index.md), redactedString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "█", repeatCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 3) |

## Functions

| Name | Summary |
|---|---|
| [equals](../-redacted-property/equals.md) | [common]<br>open operator override fun [equals](../-redacted-property/equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](../-redacted-property/hash-code.md) | [common]<br>open override fun [hashCode](../-redacted-property/hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](../-redacted-property/to-string.md) | [common]<br>override fun [toString](../-redacted-property/to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [value](value.md) | [common]<br>open override val [value](value.md): [T](index.md) |
