//[krypt-pkce](../../../index.md)/[com.chrynan.krypt.pkce](../index.md)/[CodeChallengeMethod](index.md)

# CodeChallengeMethod

[common]\
enum [CodeChallengeMethod](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[CodeChallengeMethod](index.md)&gt; 

Represents the supported transformation methods in the PKCE protocol. Currently, the only supported methods are [PLAIN](-p-l-a-i-n/index.md) and [S256](-s256/index.md). The [PLAIN](-p-l-a-i-n/index.md) method performs no operation, while the [S256](-s256/index.md) performs an SHA-256 hash.

## Entries

| | |
|---|---|
| [PLAIN](-p-l-a-i-n/index.md) | [common]<br>[PLAIN](-p-l-a-i-n/index.md) |
| [S256](-s256/index.md) | [common]<br>[S256](-s256/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [common]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [CodeChallengeMethod](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [common]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[CodeChallengeMethod](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

## Properties

| Name | Summary |
|---|---|
| [name](-s256/index.md#-372974862%2FProperties%2F-1794242802) | [common]<br>val [name](-s256/index.md#-372974862%2FProperties%2F-1794242802): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](-s256/index.md#-739389684%2FProperties%2F-1794242802) | [common]<br>val [ordinal](-s256/index.md#-739389684%2FProperties%2F-1794242802): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [typeName](type-name.md) | [common]<br>val [typeName](type-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
