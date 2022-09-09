//[krypt-hash](../../index.md)/[com.chrynan.krypt.hash](index.md)/[hash](hash.md)

# hash

[common]\
suspend fun &lt;[Algorithm](hash.md) : [HashAlgorithm](-hash-algorithm/index.md), [Result](hash.md) : [HashResult](-hash-result/index.md)&lt;[Algorithm](hash.md), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;&gt; [ByteHasher](-byte-hasher/index.md)&lt;[Algorithm](hash.md), [Result](hash.md)&gt;.[hash](hash.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Result](hash.md)

A convenience function that calls the [ByteHasher.hash](../../../krypt-core/com.chrynan.krypt.core/index.md) function with the provided [source](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value encoded to a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) using the [encodeToByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index.html) function. This encodes the provided [source](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) as a UTF-8 [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html).
