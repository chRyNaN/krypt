//[krypt-core](../../../index.md)/[com.chrynan.krypt.core](../index.md)/[KeyPairGenerator](index.md)

# KeyPairGenerator

[common]\
interface [KeyPairGenerator](index.md)&lt;[PublicKey](index.md), [PrivateKey](index.md)&gt;

A component that generates a [KeyPair](../-key-pair/index.md) for a particular algorithm.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [common]<br>abstract suspend operator fun [invoke](invoke.md)(): [KeyPair](../-key-pair/index.md)&lt;[PublicKey](index.md), [PrivateKey](index.md)&gt;<br>Generates a new [KeyPair](../-key-pair/index.md) for use with the cryptographic [algorithm](algorithm.md). |

## Properties

| Name | Summary |
|---|---|
| [algorithm](algorithm.md) | [common]<br>abstract val [algorithm](algorithm.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The name of the cryptographic algorithm this [KeyPairGenerator](index.md) generates [KeyPair](../-key-pair/index.md)s for. |

## Extensions

| Name | Summary |
|---|---|
| [generate](../generate.md) | [common]<br>suspend fun &lt;[PublicKey](../generate.md), [PrivateKey](../generate.md)&gt; [KeyPairGenerator](index.md)&lt;[PublicKey](../generate.md), [PrivateKey](../generate.md)&gt;.[generate](../generate.md)(): [KeyPair](../-key-pair/index.md)&lt;[PublicKey](../generate.md), [PrivateKey](../generate.md)&gt;<br>A convenience function that calls the [invoke](../invoke.md) function. Which function is used is up to preference. |
