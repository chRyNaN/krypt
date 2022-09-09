//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[SrpKeyPairGenerator](index.md)

# SrpKeyPairGenerator

[common]\
interface [SrpKeyPairGenerator](index.md)&lt;[T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; : [KeyPairGenerator](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-key-pair-generator/index.md)&lt;[PublicRedactedProperty](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-public-redacted-property/index.md)&lt;[T](index.md)&gt;, [PublicRedactedProperty](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-public-redacted-property/index.md)&lt;[T](index.md)&gt;&gt; 

An interface representing a component that can generate a [SrpKeyPair](../-srp-key-pair/index.md) value.

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [common]<br>abstract suspend operator override fun [invoke](invoke.md)(): [SrpKeyPair](../-srp-key-pair/index.md)&lt;[T](index.md)&gt; |

## Properties

| Name | Summary |
|---|---|
| [algorithm](algorithm.md) | [common]<br>open override val [algorithm](algorithm.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
