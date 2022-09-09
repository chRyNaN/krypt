//[krypt-core](../../index.md)/[com.chrynan.krypt.core](index.md)/[invoke](invoke.md)

# invoke

[common]\
suspend operator fun [HMAC.Companion](-h-m-a-c/-companion/index.md).[invoke](invoke.md)(key: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), message: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), hash: [HashFunction](-hash-function/index.md)&lt;[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;, blockSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)

A function that can generate a HMAC (Hash-based message authentication code). A message authentication code (MAC) is a value used to verify the data integrity and authenticity of a message (or data). A HMAC is a way of computing a MAC for data using a cryptographic hash function. The returned value is a MAC that can be included with a message to verify its authenticity and to ensure that the message data has not been tampered with.

Any cryptographic hash function may be used in the calculation of a HMAC. This function, which represents the calculation of a HMAC, takes a [hash](invoke.md) parameter which is a [HashFunction](-hash-function/index.md) with an input and output of [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html).

## See also

common

| | |
|---|---|
|  | [Wikipedia Explanation](https://en.wikipedia.org/wiki/HMAC) |

## Parameters

common

| | |
|---|---|
| key | The cryptographic key used in the HMAC calculation. |
| message | The message, or data, value that a HMAC is to be generated for. |
| hash | The [HashFunction](-hash-function/index.md) used in the HMAC calculation. |
| blockSize | The block size of the [hash](invoke.md) function. This depends on the actual hash function algorithm being used. |

[common]\
suspend operator fun [HMAC.Companion](-h-m-a-c/-companion/index.md).[invoke](invoke.md)(key: [Key](-key/index.md), message: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), hash: [HashFunction](-hash-function/index.md)&lt;[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;, blockSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)

A convenience function for invoking the [invoke](invoke.md) function with the provided [key](-key/index.md) value.

## See also

common

| | |
|---|---|
| [invoke](invoke.md) |  |

[common]\
operator fun [SecureString.Companion](-secure-string/-companion/index.md).[invoke](invoke.md)(charSequence: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)): [SecureString](-secure-string/index.md)
