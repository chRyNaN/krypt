//[krypt-core](../../../index.md)/[com.chrynan.krypt.core](../index.md)/[Key](index.md)

# Key

[common]\
interface [Key](index.md)

Represents a cryptographic key used in cryptographic algorithms, such as hashing and encrypting. For instance, this could represent either a symmetric or asymmetric key for encryption algorithms. Sub-implementations should provide any extra required properties specific to the algorithm they support. Keys should be treated securely. Whenever possible, [Key](index.md) implementations should be delegated to their platform specific implementations. This will ensure correct algorithm implementation and safe usage.

Note that this interface was inspired by the [java.security.Key interface](https://docs.oracle.com/javase/8/docs/api/java/security/Key.html).

## See also

common

| | |
|---|---|
|  | [java.security.Key interface](https://docs.oracle.com/javase/8/docs/api/java/security/Key.html) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [algorithm](algorithm.md) | [common]<br>abstract val [algorithm](algorithm.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The standard algorithm name for this key. |
| [encoded](encoded.md) | [common]<br>abstract val [encoded](encoded.md): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)?<br>The key value in its primary encoding format, or `null` if this key does not support encoding. |
| [format](format.md) | [common]<br>abstract val [format](format.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The name of the primary encoding format for this key, or `null` if this key does not support encoding. |

## Inheritors

| Name |
|---|
| [SecretKey](../-secret-key/index.md) |
