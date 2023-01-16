//[krypt-hash-argon](../../index.md)/[com.chrynan.krypt.hash.argon](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [Argon2HashAlgorithm](-argon2-hash-algorithm/index.md) | [common]<br>data class [Argon2HashAlgorithm](-argon2-hash-algorithm/index.md) : [HashAlgorithm](../../../krypt-hash/krypt-hash/com.chrynan.krypt.hash/-hash-algorithm/index.md) |
| [Argon2Hasher](-argon2-hasher/index.md) | [common]<br>interface [Argon2Hasher](-argon2-hasher/index.md) : [Hasher](../../../krypt-hash/krypt-hash/com.chrynan.krypt.hash/-hasher/index.md)&lt;[Argon2HashAlgorithm](-argon2-hash-algorithm/index.md), [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html), [SecureString](../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), [Argon2HashResult](-argon2-hash-result/index.md)&gt; |
| [Argon2HashResult](-argon2-hash-result/index.md) | [common]<br>data class [Argon2HashResult](-argon2-hash-result/index.md) : [HashResult](../../../krypt-hash/krypt-hash/com.chrynan.krypt.hash/-hash-result/index.md)&lt;[Argon2HashAlgorithm](-argon2-hash-algorithm/index.md), [SecureString](../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md)&gt; |
| [Argon2Type](-argon2-type/index.md) | [common]<br>enum [Argon2Type](-argon2-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[Argon2Type](-argon2-type/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [argon2](argon2.md) | [common]<br>fun [Hasher.Companion](../../../krypt-hash/krypt-hash/com.chrynan.krypt.hash/-hasher/-companion/index.md).[argon2](argon2.md)(type: [Argon2Type](-argon2-type/index.md) = Argon2Type.ID, saltLength: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 16, hashLength: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 32, parallelism: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, memory: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1 shl 12, iterations: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 3): [Argon2Hasher](-argon2-hasher/index.md) |
| [toArgon2](../../../krypt-hash-argon/krypt-hash-argon/com.chrynan.krypt.hash.argon/[jvm]to-argon2.md) | [android, jvm]<br>[android]<br>fun [Argon2Type](-argon2-type/index.md#2060505828%2FExtensions%2F-1915653165).[toArgon2]([android]to-argon2.md)(): Argon2<br>[jvm]<br>fun [Argon2Type](-argon2-type/index.md#2060505828%2FExtensions%2F-1550092817).[toArgon2]([jvm]to-argon2.md)(): Argon2 |
| [toJavaSecureString](../../../krypt-hash-argon/krypt-hash-argon/com.chrynan.krypt.hash.argon/[jvm]to-java-secure-string.md) | [android, jvm]<br>[android]<br>fun [SecureString](../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md).[toJavaSecureString]([android]to-java-secure-string.md)(eraseSource: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): SecureString<br>[jvm]<br>fun [SecureString](../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md).[toJavaSecureString]([jvm]to-java-secure-string.md)(eraseSource: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): SecureString |
