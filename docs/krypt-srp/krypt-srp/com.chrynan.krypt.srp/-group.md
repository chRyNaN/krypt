//[krypt-srp](../../index.md)/[com.chrynan.krypt.srp](index.md)/[Group](-group.md)

# Group

[common]\
fun [Group](-group.md)(prime: BigInteger, generator: BigInteger): [Group](-group/index.md)

Creates an instance of a [Group](-group/index.md) for use in the Secure Remote Password (SRP) protocol with the provided values.

## See also

common

| | |
|---|---|
| [com.chrynan.krypt.srp.Group](-group/index.md) |  |

## Parameters

common

| | |
|---|---|
| prime | (a.k.a. &quot;N&quot;) Is a group parameter defined in the SRP specification. This value should be a **safe prime**, which is a prime number of the form `N = 2q + 1`, where `q` is also a prime. |
| generator | (a.k.a. &quot;g&quot;) group parameter defined in the SRP specification. This value should be a generator of the multiplicative group modulo N, which means that for any X where 0 < X < N, there exists a value x for which g^x % N == X.<br>**Note:** That while there are requirements for the values [prime](-group.md) and [generator](-group.md) defined by the SRP protocol, no validation or verification is performed by this function, instead it is left up to the implementor to perform. |

[common]\
fun [Group](-group.md)(primeString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), primeBase: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 16, generator: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Group](-group/index.md)

Creates an instance of a [Group](-group/index.md) for use in the Secure Remote Password (SRP) protocol with the provided values.

## See also

common

| | |
|---|---|
| [com.chrynan.krypt.srp.Group](-group/index.md) |  |

## Parameters

common

| | |
|---|---|
| primeString | Is converted into the [Group.prime](-group/prime.md) using the [primeBase](-group.md) value. |
| primeBase | Is used to convert the [primeString](-group.md) into the [Group.prime](-group/prime.md) value.<br>[Group.prime](-group/prime.md) (a.k.a. &quot;N&quot;) Is a group parameter defined in the SRP specification. This value should be a **safe prime**, which is a prime number of the form `N = 2q + 1`, where `q` is also a prime. |
| generator | (a.k.a. &quot;g&quot;) group parameter defined in the SRP specification. This value should be a generator of the multiplicative group modulo N, which means that for any X where 0 < X < N, there exists a value x for which g^x % N == X.<br>**Note:** That while there are requirements for the values [Group.prime](-group/prime.md) and [generator](-group.md) defined by the SRP protocol, no validation or verification is performed by this function, instead it is left up to the implementor to perform. |
