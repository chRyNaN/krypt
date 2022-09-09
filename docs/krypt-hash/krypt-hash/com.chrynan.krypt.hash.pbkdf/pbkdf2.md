//[krypt-hash](../../index.md)/[com.chrynan.krypt.hash.pbkdf](index.md)/[pbkdf2](pbkdf2.md)

# pbkdf2

[common]\
fun [Hasher.Companion](../com.chrynan.krypt.hash/-hasher/-companion/index.md).[pbkdf2](pbkdf2.md)(salt: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), iterationCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), hLength: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), dkLength: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), hashFunction: [HashFunction](../../../krypt-core/krypt-core/com.chrynan.krypt.core/-hash-function/index.md)&lt;[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;): [PBKDF2Hasher](-p-b-k-d-f2-hasher/index.md)

Creates a [PBKDF2Hasher](-p-b-k-d-f2-hasher/index.md) for the PBKDF2 function with the provided parameters.

Note that this function creates a [Hasher](../com.chrynan.krypt.hash/-hasher/index.md) with the provided [salt](pbkdf2.md) value, so subsequent invocations of this [Hasher](../com.chrynan.krypt.hash/-hasher/index.md)'s [Hasher.invoke](../../../krypt-hash/com.chrynan.krypt.hash/-hasher/invoke.md) function will utilize the same [salt](pbkdf2.md). However, each password should be combined with a unique salt value. So, one would have to create a different [PBKDF2Hasher](-p-b-k-d-f2-hasher/index.md) for each password value being hashed.

## See also

common

| | |
|---|---|
|  | [Wikipedia Explanation](https://en.wikipedia.org/wiki/PBKDF2) |

## Parameters

common

| | |
|---|---|
| salt | The cryptographic salt value that is utilized in the PBKDF2 algorithm to hash the provided value in the [PBKDF2Hasher.invoke](../../../krypt-hash/com.chrynan.krypt.hash.pbkdf/-p-b-k-d-f2-hasher/invoke.md) function. |
| iterationCount | The amount of iterations this PBKDF2 algorithm performs. |
| hLength | The byte length of the output of the provided [hashFunction](pbkdf2.md). |
| dkLength | The desired bit length of the derived key. |
