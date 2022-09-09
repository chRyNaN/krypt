//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[VerifierResult](index.md)

# VerifierResult

[common]\
@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)

class [VerifierResult](index.md)(val identifier: [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), val salt: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html), val verifier: BigInteger)

Represents a generated verifier and its associated data used in the SRP protocol.

**Note:** This class does not enforce any security, and, when initialized, should be treated securely.

## Constructors

| | |
|---|---|
| [VerifierResult](-verifier-result.md) | [common]<br>fun [VerifierResult](-verifier-result.md)(identifier: [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), salt: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html), verifier: BigInteger) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [identifier](identifier.md) | [common]<br>val [identifier](identifier.md): [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md) |
| [salt](salt.md) | [common]<br>val [salt](salt.md): [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html) |
| [verifier](verifier.md) | [common]<br>val [verifier](verifier.md): BigInteger |
