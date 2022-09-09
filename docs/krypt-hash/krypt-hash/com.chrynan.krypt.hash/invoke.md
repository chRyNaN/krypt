//[krypt-hash](../../index.md)/[com.chrynan.krypt.hash](index.md)/[invoke](invoke.md)

# invoke

[common]\
suspend fun &lt;[Algorithm](invoke.md) : [HashAlgorithm](-hash-algorithm/index.md), [Result](invoke.md) : [HashResult](-hash-result/index.md)&lt;[Algorithm](invoke.md), [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)&gt;&gt; [ByteHasher](-byte-hasher/index.md)&lt;[Algorithm](invoke.md), [Result](invoke.md)&gt;.[invoke](invoke.md)(source: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Result](invoke.md)

A convenience function that calls the [ByteHasher.invoke](../../../krypt-hash/com.chrynan.krypt.hash/-byte-hasher/invoke.md) function with the provided [source](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value encoded to a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) using the [encodeToByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index.html) function. This encodes the provided [source](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) as a UTF-8 [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html).
