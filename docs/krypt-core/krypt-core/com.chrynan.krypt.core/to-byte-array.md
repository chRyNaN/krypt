//[krypt-core](../../index.md)/[com.chrynan.krypt.core](index.md)/[toByteArray](to-byte-array.md)

# toByteArray

[common]\
fun [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html).[toByteArray](to-byte-array.md)(order: [Endian](-endian/index.md) = Endian.Big): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)

Converts this [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) value into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) representation in the provided [order](to-byte-array.md).

Note that [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)s are 32-bit (4 byte) values. The resulting [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) will have a [ByteArray.size](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/size.html) of 4.

## Parameters

common

| | |
|---|---|
| order | The [Endian](-endian/index.md) order to use for the conversion process. This defaults to [Endian.Big](-endian/-big/index.md). |

[common]\
fun [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html).[toByteArray](to-byte-array.md)(order: [Endian](-endian/index.md) = Endian.Big): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)

Converts this [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) value into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) representation in the provided [order](to-byte-array.md).

Note that [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)s are 64-bit (8 byte) values. The resulting [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) will have a [ByteArray.size](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/size.html) of 8.

## Parameters

common

| | |
|---|---|
| order | The [Endian](-endian/index.md) order to use for the conversion process. This defaults to [Endian.Big](-endian/-big/index.md). |

[common]\
fun [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html).[toByteArray](to-byte-array.md)(order: [Endian](-endian/index.md) = Endian.Big): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)

Converts this [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) by converting each [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) in this array into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) with the provided [order](to-byte-array.md) and appending the results.

## See also

common

| | |
|---|---|
| [Int.toByteArray](to-byte-array.md) |  |

[common]\
fun [LongArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html).[toByteArray](to-byte-array.md)(order: [Endian](-endian/index.md) = Endian.Big): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)

Converts this [LongArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html) into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) by converting each [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) in this array into a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) with the provided [order](to-byte-array.md) and appending the results.

## See also

common

| | |
|---|---|
| [Long.toByteArray](to-byte-array.md) |  |
