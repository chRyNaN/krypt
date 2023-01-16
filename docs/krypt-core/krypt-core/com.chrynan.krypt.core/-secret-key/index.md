//[krypt-core](../../../index.md)/[com.chrynan.krypt.core](../index.md)/[SecretKey](index.md)

# SecretKey

[common]\
interface [SecretKey](index.md) : [Key](../-key/index.md)

Represents a secret key for a symmetric encryption algorithm.

Note that this interface was inspired by the [javax.crypto.SecretKey interface](https://docs.oracle.com/javase/8/docs/api/javax/crypto/SecretKey.html).

#### See also

common

| | |
|---|---|
| javax.crypto.SecretKey | (https://docs.oracle.com/javase/8/docs/api/javax/crypto/SecretKey.html) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [algorithm](../-key/algorithm.md) | [common]<br>abstract val [algorithm](../-key/algorithm.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The standard algorithm name for this key. |
| [encoded](encoded.md) | [common]<br>open override val [encoded](encoded.md): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)?<br>Secret keys should return the raw key bytes for the [encoded](encoded.md) property. This property delegates to the [raw](raw.md) property by default. |
| [format](format.md) | [common]<br>open override val [format](format.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Secret keys should return &quot;RAW&quot; for their [format](format.md) and the raw key bytes for the [encoded](encoded.md) property. |
| [raw](raw.md) | [common]<br>abstract val [raw](raw.md): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)?<br>The raw key bytes for this key. |
