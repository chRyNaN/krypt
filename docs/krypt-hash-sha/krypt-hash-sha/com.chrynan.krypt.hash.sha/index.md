//[krypt-hash-sha](../../index.md)/[com.chrynan.krypt.hash.sha](index.md)

# Package com.chrynan.krypt.hash.sha

## Types

| Name | Summary |
|---|---|
| [SHAHashAlgorithm](-s-h-a-hash-algorithm/index.md) | [common]<br>data class [SHAHashAlgorithm](-s-h-a-hash-algorithm/index.md) : [HashAlgorithm](../../../krypt-hash/krypt-hash/com.chrynan.krypt.hash/-hash-algorithm/index.md) |
| [SHAHasher](-s-h-a-hasher/index.md) | [common]<br>interface [SHAHasher](-s-h-a-hasher/index.md) : [Hasher](../../../krypt-hash/krypt-hash/com.chrynan.krypt.hash/-hasher/index.md)&lt;[SHAHashAlgorithm](-s-h-a-hash-algorithm/index.md), [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html), [SecureString](../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), [SHAHashResult](-s-h-a-hash-result/index.md)&gt; |
| [SHAHashResult](-s-h-a-hash-result/index.md) | [common]<br>data class [SHAHashResult](-s-h-a-hash-result/index.md) : [HashResult](../../../krypt-hash/krypt-hash/com.chrynan.krypt.hash/-hash-result/index.md)&lt;[SHAHashAlgorithm](-s-h-a-hash-algorithm/index.md), [SecureString](../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md)&gt; |
| [SHAOutputFormat](-s-h-a-output-format/index.md) | [common]<br>enum [SHAOutputFormat](-s-h-a-output-format/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[SHAOutputFormat](-s-h-a-output-format/index.md)&gt; |
| [SHAType](-s-h-a-type/index.md) | [common]<br>enum [SHAType](-s-h-a-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[SHAType](-s-h-a-type/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [sha1](sha1.md) | [common]<br>fun [Hasher.Companion](../../../krypt-hash/krypt-hash/com.chrynan.krypt.hash/-hasher/-companion/index.md).[sha1](sha1.md)(outputFormat: [SHAOutputFormat](-s-h-a-output-format/index.md) = SHAOutputFormat.UTF_8): [SHAHasher](-s-h-a-hasher/index.md) |
| [sha256](sha256.md) | [common]<br>fun [Hasher.Companion](../../../krypt-hash/krypt-hash/com.chrynan.krypt.hash/-hasher/-companion/index.md).[sha256](sha256.md)(outputFormat: [SHAOutputFormat](-s-h-a-output-format/index.md) = SHAOutputFormat.UTF_8): [SHAHasher](-s-h-a-hasher/index.md) |
| [sha512](sha512.md) | [common]<br>fun [Hasher.Companion](../../../krypt-hash/krypt-hash/com.chrynan.krypt.hash/-hasher/-companion/index.md).[sha512](sha512.md)(outputFormat: [SHAOutputFormat](-s-h-a-output-format/index.md) = SHAOutputFormat.UTF_8): [SHAHasher](-s-h-a-hasher/index.md) |
