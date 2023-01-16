//[krypt-core](../../index.md)/[com.chrynan.krypt.core](index.md)/[toInt](to-int.md)

# toInt

[common]\
fun [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html).[toInt](to-int.md)(startInclusive: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, endExclusive: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = size, order: [Endian](-endian/index.md) = Endian.Big): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Converts the specified indices of this [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) into an [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) value in the provider [order](to-int.md).

Note that [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)s are 32-bit (4 byte) values. An exception will be thrown if the index range is greater than four or [startInclusive](to-int.md) is greater than or equal to [endExclusive](to-int.md).

#### Parameters

common

| | |
|---|---|
| startInclusive | The first index to use in the conversion process of this [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) to an [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html). This defaults to zero. |
| endExclusive | The last, not included, index used in the conversion process of this [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) to an [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html). This defaults to [ByteArray.size](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/size.html). |
| order | The [Endian](-endian/index.md) order to use for the conversion process. This defaults to [Endian.Big](-endian/-big/index.md). Note that the resulting [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) value will be different for [Endian.Big](-endian/-big/index.md) and [Endian.Little](-endian/-little/index.md) order for the same [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html). |
