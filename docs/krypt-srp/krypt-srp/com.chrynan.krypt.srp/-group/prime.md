//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[Group](index.md)/[prime](prime.md)

# prime

[common]\
abstract val [prime](prime.md): BigInteger

The &quot;prime&quot; (&quot;N&quot;) group parameter defined in the SRP specification. This value should be a **safe prime**, which is a prime number of the form `N = 2q + 1`, where `q` is also a prime.

This is a BigInteger value whose size should be a rather large amount of bits. Typical bit counts could be 1024, 2048, 4096, etc.

#### See also

common

| |
|---|
| BigInteger |
