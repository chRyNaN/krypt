//[krypt-core](../../../index.md)/[com.chrynan.krypt.core](../index.md)/[RedactedProperty](index.md)

# RedactedProperty

[common]\
abstract class [RedactedProperty](index.md)&lt;[T](index.md)&gt;(redactedString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), repeatCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))

A wrapper class for any type that needs to be redacted when calling toString so that it doesn't output sensitive data. Note that the underlying [value](../../../../krypt-core/com.chrynan.krypt.core/-redacted-property/value.md) can still be accessed and any direct call to toString on that property will not be redacted.

## Constructors

| | |
|---|---|
| [RedactedProperty](-redacted-property.md) | [common]<br>fun [RedactedProperty](-redacted-property.md)(redactedString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "█", repeatCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 3) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [common]<br>override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Inheritors

| Name |
|---|
| [PublicRedactedProperty](../-public-redacted-property/index.md) |
| [SecureString](../-secure-string/index.md) |
