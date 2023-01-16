//[krypt-hash](../../index.md)/[com.chrynan.krypt.hash.pbkdf](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [PBKDF2Algorithm](-p-b-k-d-f2-algorithm/index.md) | [common]<br>data class [PBKDF2Algorithm](-p-b-k-d-f2-algorithm/index.md) : [HashAlgorithm](../com.chrynan.krypt.hash/-hash-algorithm/index.md) |
| [PBKDF2Hasher](-p-b-k-d-f2-hasher/index.md) | [common]<br>interface [PBKDF2Hasher](-p-b-k-d-f2-hasher/index.md) : [ByteHasher](../com.chrynan.krypt.hash/-byte-hasher/index.md)&lt;[PBKDF2Algorithm](-p-b-k-d-f2-algorithm/index.md), [PBKDF2HashResult](-p-b-k-d-f2-hash-result/index.md)&gt; <br>A [ByteHasher](../com.chrynan.krypt.hash/-byte-hasher/index.md) that uses the PBKDF2 (password-based key derivation function 2) algorithm. To create an instance of this use the [Hasher.Companion.pbkdf2](pbkdf2.md) function. |
| [PBKDF2HashResult](-p-b-k-d-f2-hash-result/index.md) | [common]<br>class [PBKDF2HashResult](-p-b-k-d-f2-hash-result/index.md) : [HashResult](../com.chrynan.krypt.hash/-hash-result/index.md)&lt;[PBKDF2Algorithm](-p-b-k-d-f2-algorithm/index.md), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt; |

## Functions

| Name | Summary |
|---|---|
| [pbkdf2](pbkdf2.md) | [common]<br>fun [Hasher.Companion](../com.chrynan.krypt.hash/-hasher/-companion/index.md).[pbkdf2](pbkdf2.md)(salt: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), iterationCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), hLength: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), dkLength: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), hashFunction: [HashFunction](../../../krypt-core/krypt-core/com.chrynan.krypt.core/-hash-function/index.md)&lt;[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;): [PBKDF2Hasher](-p-b-k-d-f2-hasher/index.md)<br>Creates a [PBKDF2Hasher](-p-b-k-d-f2-hasher/index.md) for the PBKDF2 function with the provided parameters. |
