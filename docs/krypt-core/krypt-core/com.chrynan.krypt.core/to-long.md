//[krypt-core](../../index.md)/[com.chrynan.krypt.core](index.md)/[toLong](to-long.md)

# toLong

[common]\
fun [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html).[toLong](to-long.md)(startInclusive: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, endExclusive: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = size, order: [Endian](-endian/index.md) = Endian.Big): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)

Converts the specified indices of this [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) into a [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) value in the provider [order](to-long.md).

Note that [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)s are 64-bit (8 byte) values. An exception will be thrown if the index range is greater than eight or [startInclusive](to-long.md) is greater than or equal to [endExclusive](to-long.md).

## Parameters

common

| | |
|---|---|
| startInclusive | The first index to use in the conversion process of this [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) to an [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html). This defaults to zero. |
| endExclusive | The last, not included, index used in the conversion process of this [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) to an [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html). This defaults to [ByteArray.size](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/size.html). |
| order | The [Endian](-endian/index.md) order to use for the conversion process. This defaults to [Endian.Big](-endian/-big/index.md). Note that the resulting [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) value will be different for [Endian.Big](-endian/-big/index.md) and [Endian.Little](-endian/-little/index.md) order for the same [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html). |
