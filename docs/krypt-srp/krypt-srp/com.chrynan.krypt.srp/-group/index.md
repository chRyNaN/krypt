//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[Group](index.md)

# Group

[common]\
interface [Group](index.md)

Represents the &quot;Group&quot; parameters (&quot;N&quot; a.k.a. &quot;prime&quot;, and &quot;g&quot; a.k.a. &quot;generator&quot;) in the Secure Remote Password Protocol (SRP) algorithm.

These group parameter values, used in the SRP algorithm, must be agreed upon by the client and server. They can be hardcoded in advance, or the server can supply them to the client by sending them along with the salt.

The [prime](prime.md) and [generator](generator.md) properties should satisfy the following requirements defined in the SRP protocol specification:

- 
   The [prime](prime.md) (N) value should be a **safe prime**, which is a prime number of the form `N = 2q + 1`, where `q` is also a prime.
- 
   The [generator](generator.md) (g) value should be a generator of the multiplicative group modulo N, which means that for any X where 0 < X < N, there exists a value x for which g^x % N == X.

**Note:** That while there are requirements for the values [prime](prime.md) and [generator](generator.md) defined by the SRP protocol, no validation or verification is performed by this interface, instead is left up to the implementor to perform.

## See also

common

| | |
|---|---|
|  | [Swift Implementation (Referenced on Dec 21, 2021)](https://github.com/Bouke/SRP/blob/master/Sources/Group.swift) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md)<br>A companion object on the [Group](index.md) interface which can be useful to provide implementations of the [Group](index.md) interface as extension properties. |

## Properties

| Name | Summary |
|---|---|
| [generator](generator.md) | [common]<br>abstract val [generator](generator.md): BigInteger<br>The &quot;generator&quot; (&quot;g&quot;) group parameter defined in the SRP specification. This value should be a generator of the multiplicative group modulo N, which means that for any X where 0 < X < N, there exists a value x for which g^x % N == X. |
| [prime](prime.md) | [common]<br>abstract val [prime](prime.md): BigInteger<br>The &quot;prime&quot; (&quot;N&quot;) group parameter defined in the SRP specification. This value should be a **safe prime**, which is a prime number of the form `N = 2q + 1`, where `q` is also a prime. |

## Extensions

| Name | Summary |
|---|---|
| [g](../g.md) | [common]<br>val [Group](index.md).[g](../g.md): BigInteger<br>An alias property for [Group.generator](generator.md). |
| [N](../-n.md) | [common]<br>val [Group](index.md).[N](../-n.md): BigInteger<br>An alias property for [Group.prime](prime.md). |
