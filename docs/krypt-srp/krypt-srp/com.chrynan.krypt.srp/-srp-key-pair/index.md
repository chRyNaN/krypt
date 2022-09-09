//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[SrpKeyPair](index.md)

# SrpKeyPair

[common]\
class [SrpKeyPair](index.md)&lt;[T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(val privateKey: [PublicRedactedProperty](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-public-redacted-property/index.md)&lt;[T](index.md)&gt;, val publicKey: [PublicRedactedProperty](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-public-redacted-property/index.md)&lt;[T](index.md)&gt;) : [KeyPair](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-key-pair/index.md)&lt;[PublicRedactedProperty](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-public-redacted-property/index.md)&lt;[T](index.md)&gt;, [PublicRedactedProperty](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-public-redacted-property/index.md)&lt;[T](index.md)&gt;&gt; 

Represents a simple holder for a pair of keys (public and private).

**Note:** This class does not enforce any security, and, when initialized, should be treated securely.

## Constructors

| | |
|---|---|
| [SrpKeyPair](-srp-key-pair.md) | [common]<br>fun &lt;[T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [SrpKeyPair](-srp-key-pair.md)(privateKey: [PublicRedactedProperty](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-public-redacted-property/index.md)&lt;[T](index.md)&gt;, publicKey: [PublicRedactedProperty](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-public-redacted-property/index.md)&lt;[T](index.md)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [privateKey](private-key.md) | [common]<br>open override val [privateKey](private-key.md): [PublicRedactedProperty](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-public-redacted-property/index.md)&lt;[T](index.md)&gt; |
| [publicKey](public-key.md) | [common]<br>open override val [publicKey](public-key.md): [PublicRedactedProperty](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-public-redacted-property/index.md)&lt;[T](index.md)&gt; |
