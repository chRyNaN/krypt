//[krypt-core](../../../index.md)/[com.chrynan.krypt.core](../index.md)/[Endian](index.md)

# Endian

[common]\
enum [Endian](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[Endian](index.md)&gt; 

Represents the order of a &quot;word&quot; or a numeric value that consists of multiple bytes. In [Little](-little/index.md) Endian, the least significant (or last) byte is stored first. In [Big](-big/index.md) Endian, the most significant (or first) byte is stored first.

Note that technically, the endianness is abstracted away from Kotlin, and each target platform may represent the values using their desired endian order. However, sometimes when working with [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)s, it is required to convert them to numeric values, such as [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) or [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), so, in those scenarios, it is required to specify the order of how the [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)s are converted to the numerical value. Though this conversion is different from how the value is internally stored or represented, it will result in different numeric values depending on the order.

## See also

common

| | |
|---|---|
|  | [Wikipedia Explanation](https://en.wikipedia.org/wiki/Endianness) |

## Entries

| | |
|---|---|
| [Big](-big/index.md) | [common]<br>[Big](-big/index.md) |
| [Little](-little/index.md) | [common]<br>[Little](-little/index.md) |

## Properties

| Name | Summary |
|---|---|
| [name](-little/index.md#-372974862%2FProperties%2F-1475907568) | [common]<br>val [name](-little/index.md#-372974862%2FProperties%2F-1475907568): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](-little/index.md#-739389684%2FProperties%2F-1475907568) | [common]<br>val [ordinal](-little/index.md#-739389684%2FProperties%2F-1475907568): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
