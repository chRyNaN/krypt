//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[Group](index.md)/[generator](generator.md)

# generator

[common]\
abstract val [generator](generator.md): BigInteger

The "generator" ("g") group parameter defined in the SRP specification. This value should be a generator of the multiplicative group modulo N, which means that for any X where 0 < X < N, there exists a value x for which g^x % N == X.

This is a BigInteger value, however it typically is a small value, such as '2', but depends on the above-mentioned requirements.

## See also

common

| | |
|---|---|
| com.ionspin.kotlin.bignum.integer.BigInteger |  |
