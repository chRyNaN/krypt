//[krypt-hash](../../index.md)/[com.chrynan.krypt.hash.sha](index.md)

# Package com.chrynan.krypt.hash.sha

## Types

| Name | Summary |
|---|---|
| [SHA2Hasher](-s-h-a2-hasher/index.md) | [common]<br>interface [SHA2Hasher](-s-h-a2-hasher/index.md) : [ByteHasher](../com.chrynan.krypt.hash/-byte-hasher/index.md)&lt;[SHA2HashFunction.SupportedAlgorithm](-s-h-a2-hash-function/-supported-algorithm/index.md), [SHA2HashResult](-s-h-a2-hash-result/index.md)&gt; <br>A [ByteHasher](../com.chrynan.krypt.hash/-byte-hasher/index.md) that uses one of the variants of the SHA-2 algorithm. To create an instance of this class, use one of the factory functions, such as [sha256](sha256.md). |
| [SHA2HashFunction](-s-h-a2-hash-function/index.md) | [common]<br>interface [SHA2HashFunction](-s-h-a2-hash-function/index.md) : [HashFunction](../../../krypt-core/krypt-core/com.chrynan.krypt.core/-hash-function/index.md)&lt;[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt; <br>An SHA-2 [HashFunction](../../../krypt-core/krypt-core/com.chrynan.krypt.core/-hash-function/index.md) implementation. The supported variants of the SHA-2 algorithm are defined in the [SupportedAlgorithm](-s-h-a2-hash-function/-supported-algorithm/index.md) enum class. To utilize this hashing algorithm, use the [SHA2Hasher](-s-h-a2-hasher/index.md) interface and one of its factory functions, such as [sha256](sha256.md). |
| [SHA2HashResult](-s-h-a2-hash-result/index.md) | [common]<br>class [SHA2HashResult](-s-h-a2-hash-result/index.md) : [HashResult](../com.chrynan.krypt.hash/-hash-result/index.md)&lt;[SHA2HashFunction.SupportedAlgorithm](-s-h-a2-hash-function/-supported-algorithm/index.md), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt; |

## Functions

| Name | Summary |
|---|---|
| [sha224](sha224.md) | [common]<br>fun [Hasher.Companion](../com.chrynan.krypt.hash/-hasher/-companion/index.md).[sha224](sha224.md)(): [SHA2Hasher](-s-h-a2-hasher/index.md)<br>Creates a [SHA2Hasher](-s-h-a2-hasher/index.md) for the SHA-2 224 hashing algorithm. |
| [sha256](sha256.md) | [common]<br>fun [Hasher.Companion](../com.chrynan.krypt.hash/-hasher/-companion/index.md).[sha256](sha256.md)(): [SHA2Hasher](-s-h-a2-hasher/index.md)<br>Creates a [SHA2Hasher](-s-h-a2-hasher/index.md) for the SHA-2 256 hashing algorithm. |
| [sha384](sha384.md) | [common]<br>fun [Hasher.Companion](../com.chrynan.krypt.hash/-hasher/-companion/index.md).[sha384](sha384.md)(): [SHA2Hasher](-s-h-a2-hasher/index.md)<br>Creates a [SHA2Hasher](-s-h-a2-hasher/index.md) for the SHA-2 384 hashing algorithm. |
| [sha512](sha512.md) | [common]<br>fun [Hasher.Companion](../com.chrynan.krypt.hash/-hasher/-companion/index.md).[sha512](sha512.md)(): [SHA2Hasher](-s-h-a2-hasher/index.md)<br>Creates a [SHA2Hasher](-s-h-a2-hasher/index.md) for the SHA-2 512 hashing algorithm. |
