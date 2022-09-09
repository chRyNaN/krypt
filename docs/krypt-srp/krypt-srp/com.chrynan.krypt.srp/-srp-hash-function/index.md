//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[SrpHashFunction](index.md)

# SrpHashFunction

[common]\
@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)

interface [SrpHashFunction](index.md) : [HashFunction](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-hash-function/index.md)&lt;[UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html), [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)&gt; 

An interface for a generic hash function used within the SRP protocol. The SRP protocol is agnostic of the hash function implementation as long as the inputs and outputs are of the expected values. The input and output is expected to be of type [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html).

## Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | [common]<br>abstract suspend operator override fun [invoke](invoke.md)(source: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)): [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)<br>Performs the hash function on the provided [source](invoke.md) to generate a [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html) value. |

## Properties

| Name | Summary |
|---|---|
| [algorithmName](index.md#1834603040%2FProperties%2F460253122) | [common]<br>abstract val [algorithmName](index.md#1834603040%2FProperties%2F460253122): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |

## Extensions

| Name | Summary |
|---|---|
| [invoke](../invoke.md) | [common]<br>@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)<br>suspend operator fun [SrpHashFunction](index.md).[invoke](../invoke.md)(source: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)): [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)<br>Converts the provided [source](../invoke.md) to a [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html) using UTF-8 encoding and calls the [invoke](../invoke.md) function on the result.<br>[common]<br>@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)<br>suspend operator fun [SrpHashFunction](index.md).[invoke](../invoke.md)(source: BigInteger): [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)<br>Converts the provided [source](../invoke.md) to a [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html) using the BigInteger.toUByteArray function and calls the [invoke](../invoke.md) function on the result. |
