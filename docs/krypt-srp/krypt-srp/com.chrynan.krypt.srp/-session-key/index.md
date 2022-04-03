//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[SessionKey](index.md)

# SessionKey

[common]\
@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)

class [SessionKey](index.md)(key: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html), clientProof: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html), hostProof: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)) : [RedactedProperty](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-redacted-property/index.md)&lt;[UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)&gt; 

Represents a generated shared session key and its associated proof data used in the SRP protocol.

A [SessionKey.value](../../../../krypt-srp/com.chrynan.krypt.srp/-session-key/value.md) can be used to further encrypt the communication between a client and host after they have verified each other. However, this functionality is outside the responsibility of this class.

**Note:** This class does not enforce any security, and, when initialized, should be treated securely.

## Constructors

| | |
|---|---|
| [SessionKey](-session-key.md) | [common]<br>fun [SessionKey](-session-key.md)(key: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html), clientProof: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html), hostProof: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](index.md#-182765597%2FFunctions%2F460253122) | [common]<br>override fun [toString](index.md#-182765597%2FFunctions%2F460253122)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [clientProof](client-proof.md) | [common]<br>val [clientProof](client-proof.md): [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html) |
| [hostProof](host-proof.md) | [common]<br>val [hostProof](host-proof.md): [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html) |
