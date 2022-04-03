//[krypt-core](../../../index.md)/[com.chrynan.krypt.core](../index.md)/[HashFunction](index.md)

# HashFunction

[common]\
interface [HashFunction](index.md)&lt;[Input](index.md), [Result](index.md)&gt;

Represents a cryptographic hash function, or a secure one-way hash function that takes arbitrarily sized input data of type [Input](index.md) and outputs a value of type [Result](index.md), which contains or is a fixed size hash value ("message-digest") as a result of this function. The result of performing a hash function cannot be reversed, meaning that the input value cannot be obtained by reversing the hash, as a hash function is a one-way function. Different implementations of this interface may represent different hashing algorithms, such as "SHA256" or "Argon2ID". It is common to use a hash function with a password in an authentication flow for a system.

## See also

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
| [invoke](invoke.md) | [common]<br>abstract suspend operator fun [invoke](invoke.md)(source: [Input](index.md)): [Result](index.md)<br>Performs the hash with the provided [source](invoke.md) value and returns a [Result](index.md). |

## Extensions

| Name | Summary |
|---|---|
| [hash](../hash.md) | [common]<br>suspend fun &lt;[Input](../hash.md), [Result](../hash.md)&gt; [HashFunction](index.md)&lt;[Input](../hash.md), [Result](../hash.md)&gt;.[hash](../hash.md)(source: [Input](../hash.md)): [Result](../hash.md)<br>A convenience function that delegates to the [invoke](../invoke.md) function of the [HashFunction](index.md) interface. This is provided for preference, as it may be preferable to use "hash" instead of "invoke" at the call-site. |
