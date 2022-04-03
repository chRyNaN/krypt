//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[KeyPairGenerator](index.md)

# KeyPairGenerator

[common]\
interface [KeyPairGenerator](index.md)&lt;[T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

An interface representing a component that can generate a [KeyPair](../-key-pair/index.md) value.

## Functions

| Name | Summary |
|---|---|
| [generateKeyPair](generate-key-pair.md) | [common]<br>abstract suspend fun [generateKeyPair](generate-key-pair.md)(): [KeyPair](../-key-pair/index.md)&lt;[T](index.md)&gt;<br>Generates a new [KeyPair](../-key-pair/index.md). |

## Inheritors

| Name |
|---|
| [Client](../-client/index.md) |
| [Host](../-host/index.md) |
