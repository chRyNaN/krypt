//[krypt-core](../../../index.md)/[com.chrynan.krypt.core](../index.md)/[KeyPair](index.md)

# KeyPair

[common]\
interface [KeyPair](index.md)&lt;[PublicKey](index.md), [PrivateKey](index.md)&gt;

Represents a grouping of a [publicKey](public-key.md) and [privateKey](private-key.md) key. Typically, this is used for asymmetric encryption algorithms. Key pairs should be treated securely.

Note that this interface was inspired by the [java.security.KeyPair interface](https://docs.oracle.com/javase/8/docs/api/java/security/KeyPair.html).

## See also

common

| | |
|---|---|
|  | [java.security.KeyPair interface](https://docs.oracle.com/javase/8/docs/api/java/security/KeyPair.html) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [privateKey](private-key.md) | [common]<br>abstract val [privateKey](private-key.md): [PrivateKey](index.md) |
| [publicKey](public-key.md) | [common]<br>abstract val [publicKey](public-key.md): [PublicKey](index.md) |
