//[krypt-core](../../../index.md)/[com.chrynan.krypt.core](../index.md)/[HashFunction](index.md)

# HashFunction

[common]\
interface [HashFunction](index.md)&lt;[Input](index.md), [Output](index.md)&gt;

Represents a cryptographic hash function, or a secure one-way hash function that takes arbitrarily sized input data of type [Input](index.md) and outputs a value of type [Output](index.md), which contains or is a fixed size hash value (&quot;message-digest&quot;) as a result of this function. The result of performing a hash function cannot be reversed, meaning that the input value cannot be obtained by reversing the hash, as a hash function is a one-way function. Different implementations of this interface may represent different hashing algorithms, such as &quot;SHA256&quot; or &quot;Argon2ID&quot;. It is common to use a hash function with a password in an authentication flow for a system.

#### See also

common

| | |
|---|---|
|  | [Key Derivation Function](https://en.wikipedia.org/wiki/Key_derivation_function) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [common]<br>abstract suspend operator fun [invoke](invoke.md)(source: [Input](index.md)): [Output](index.md)<br>Performs the hash with the provided [source](invoke.md) value and returns a [Output](index.md). |

## Properties

| Name | Summary |
|---|---|
| [algorithmName](algorithm-name.md) | [common]<br>abstract val [algorithmName](algorithm-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The name of the algorithm this [HashFunction](index.md) implements. |

## Extensions

| Name | Summary |
|---|---|
| [hash](../hash.md) | [common]<br>suspend fun &lt;[Input](../hash.md), [Output](../hash.md)&gt; [HashFunction](index.md)&lt;[Input](../hash.md), [Output](../hash.md)&gt;.[hash](../hash.md)(source: [Input](../hash.md)): [Output](../hash.md)<br>A convenience function that delegates to the [invoke](../invoke.md) function of the [HashFunction](index.md) interface. This is provided for preference, as it may be preferable to use &quot;hash&quot; instead of &quot;invoke&quot; at the call-site. |
