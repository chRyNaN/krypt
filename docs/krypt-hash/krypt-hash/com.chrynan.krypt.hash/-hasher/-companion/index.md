//[krypt-hash](../../../../index.md)/[com.chrynan.krypt.hash](../../index.md)/[Hasher](../index.md)/[Companion](index.md)

# Companion

[common]\
object [Companion](index.md)

## Extensions

| Name | Summary |
|---|---|
| [pbkdf2](../../../com.chrynan.krypt.hash.pbkdf/pbkdf2.md) | [common]<br>fun [Hasher.Companion](index.md).[pbkdf2](../../../com.chrynan.krypt.hash.pbkdf/pbkdf2.md)(salt: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), iterationCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), hLength: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), dkLength: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), hashFunction: [HashFunction](../../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-hash-function/index.md)&lt;[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;): [PBKDF2Hasher](../../../com.chrynan.krypt.hash.pbkdf/-p-b-k-d-f2-hasher/index.md)<br>Creates a [PBKDF2Hasher](../../../com.chrynan.krypt.hash.pbkdf/-p-b-k-d-f2-hasher/index.md) for the PBKDF2 function with the provided parameters. |
| [sha224](../../../com.chrynan.krypt.hash.sha/sha224.md) | [common]<br>fun [Hasher.Companion](index.md).[sha224](../../../com.chrynan.krypt.hash.sha/sha224.md)(): [SHA2Hasher](../../../com.chrynan.krypt.hash.sha/-s-h-a2-hasher/index.md)<br>Creates a [SHA2Hasher](../../../com.chrynan.krypt.hash.sha/-s-h-a2-hasher/index.md) for the SHA-2 224 hashing algorithm. |
| [sha256](../../../com.chrynan.krypt.hash.sha/sha256.md) | [common]<br>fun [Hasher.Companion](index.md).[sha256](../../../com.chrynan.krypt.hash.sha/sha256.md)(): [SHA2Hasher](../../../com.chrynan.krypt.hash.sha/-s-h-a2-hasher/index.md)<br>Creates a [SHA2Hasher](../../../com.chrynan.krypt.hash.sha/-s-h-a2-hasher/index.md) for the SHA-2 256 hashing algorithm. |
| [sha384](../../../com.chrynan.krypt.hash.sha/sha384.md) | [common]<br>fun [Hasher.Companion](index.md).[sha384](../../../com.chrynan.krypt.hash.sha/sha384.md)(): [SHA2Hasher](../../../com.chrynan.krypt.hash.sha/-s-h-a2-hasher/index.md)<br>Creates a [SHA2Hasher](../../../com.chrynan.krypt.hash.sha/-s-h-a2-hasher/index.md) for the SHA-2 384 hashing algorithm. |
| [sha512](../../../com.chrynan.krypt.hash.sha/sha512.md) | [common]<br>fun [Hasher.Companion](index.md).[sha512](../../../com.chrynan.krypt.hash.sha/sha512.md)(): [SHA2Hasher](../../../com.chrynan.krypt.hash.sha/-s-h-a2-hasher/index.md)<br>Creates a [SHA2Hasher](../../../com.chrynan.krypt.hash.sha/-s-h-a2-hasher/index.md) for the SHA-2 512 hashing algorithm. |
