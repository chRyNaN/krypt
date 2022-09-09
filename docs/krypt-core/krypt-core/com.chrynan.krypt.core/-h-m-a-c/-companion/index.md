//[krypt-core](../../../../index.md)/[com.chrynan.krypt.core](../../index.md)/[HMAC](../index.md)/[Companion](index.md)

# Companion

[common]\
object [Companion](index.md)

## Extensions

| Name | Summary |
|---|---|
| [invoke](../../invoke.md) | [common]<br>suspend operator fun [HMAC.Companion](index.md).[invoke](../../invoke.md)(key: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), message: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), hash: [HashFunction](../../-hash-function/index.md)&lt;[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;, blockSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>A function that can generate a HMAC (Hash-based message authentication code). A message authentication code (MAC) is a value used to verify the data integrity and authenticity of a message (or data). A HMAC is a way of computing a MAC for data using a cryptographic hash function. The returned value is a MAC that can be included with a message to verify its authenticity and to ensure that the message data has not been tampered with.<br>[common]<br>suspend operator fun [HMAC.Companion](index.md).[invoke](../../invoke.md)(key: [Key](../../-key/index.md), message: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), hash: [HashFunction](../../-hash-function/index.md)&lt;[ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;, blockSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>A convenience function for invoking the [invoke](../../invoke.md) function with the provided [key](../../-key/index.md) value. |
