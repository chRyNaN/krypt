//[krypt-srp](../../index.md)/[com.chrynan.krypt.srp](index.md)/[invoke](invoke.md)

# invoke

[common]\

@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)

suspend operator fun [SrpHashFunction](-srp-hash-function/index.md).[invoke](invoke.md)(source: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)): [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)

Converts the provided [source](invoke.md) to a [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html) using UTF-8 encoding and calls the [invoke](invoke.md) function on the result.

## See also

common

| | |
|---|---|
| [com.chrynan.krypt.srp.SrpHashFunction](-srp-hash-function/invoke.md) |  |

[common]\

@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)

suspend operator fun [SrpHashFunction](-srp-hash-function/index.md).[invoke](invoke.md)(source: BigInteger): [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)

Converts the provided [source](invoke.md) to a [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html) using the BigInteger.toUByteArray function and calls the [invoke](invoke.md) function on the result.

## See also

common

| | |
|---|---|
| [com.chrynan.krypt.srp.SrpHashFunction](-srp-hash-function/invoke.md) |  |
