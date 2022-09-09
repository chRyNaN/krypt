//[krypt-core](../../../index.md)/[com.chrynan.krypt.core](../index.md)/[KeyGenerator](index.md)

# KeyGenerator

[common]\
interface [KeyGenerator](index.md)&lt;[K](index.md) : [Key](../-key/index.md)&gt;

A component that generates a [Key](../-key/index.md) of type [K](index.md) for a particular [algorithm](algorithm.md).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [common]<br>abstract suspend operator fun [invoke](invoke.md)(): [K](index.md)<br>Generates a new [Key](../-key/index.md) of type [K](index.md) for use with the cryptographic [algorithm](algorithm.md). |

## Properties

| Name | Summary |
|---|---|
| [algorithm](algorithm.md) | [common]<br>abstract val [algorithm](algorithm.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The name of the cryptographic algorithm this [KeyGenerator](index.md) generates keys for. |

## Extensions

| Name | Summary |
|---|---|
| [generate](../generate.md) | [common]<br>suspend fun &lt;[K](../generate.md) : [Key](../-key/index.md)&gt; [KeyGenerator](index.md)&lt;[K](../generate.md)&gt;.[generate](../generate.md)(): [K](../generate.md)<br>A convenience function that calls the [KeyGenerator.invoke](invoke.md) function. Which function is used is up to preference. |
