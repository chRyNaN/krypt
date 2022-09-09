//[krypt-uuid](../../../index.md)/[com.chrynan.krypt.uuid](../index.md)/[Uuid](index.md)

# Uuid

[common]\
class [Uuid](index.md) : [Comparable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)&lt;[Uuid](index.md)&gt; 

Represents a Universally Unique Identifier (UUID). A UUID represents a 128-bit value. The implementing class should be considered immutable.

## See also

common

| | |
|---|---|
|  | [Wikipedia Explanation](https://en.wikipedia.org/wiki/Universally_unique_identifier) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [compareTo](compare-to.md) | [common]<br>open operator override fun [compareTo](compare-to.md)(other: [Uuid](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

## Properties

| Name | Summary |
|---|---|
| [bytes](bytes.md) | [common]<br>val [bytes](bytes.md): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Retrieves the underlying [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) representing the 128-bit (16-byte) UUID value. |
| [leastSignificantBits](least-significant-bits.md) | [common]<br>val [leastSignificantBits](least-significant-bits.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Returns the least significant 64 bits of this UUID's 128 bit value. |
| [mostSignificantBits](most-significant-bits.md) | [common]<br>val [mostSignificantBits](most-significant-bits.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Returns the most significant 64 bits of this UUID's 128 bit value. |
| [variant](variant.md) | [common]<br>val [variant](variant.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The variant number of this [Uuid](index.md) instance. The [variant](variant.md) describes the layout of the UUID: |
| [version](version.md) | [common]<br>val [version](version.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The version number of this [Uuid](index.md) instance. The [version](version.md) specifies how this UUID was generated: |
