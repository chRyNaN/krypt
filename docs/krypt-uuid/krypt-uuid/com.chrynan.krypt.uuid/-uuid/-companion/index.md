//[krypt-uuid](../../../../index.md)/[com.chrynan.krypt.uuid](../../index.md)/[Uuid](../index.md)/[Companion](index.md)

# Companion

[common]\
object [Companion](index.md)

## Functions

| Name | Summary |
|---|---|
| [from](from.md) | [common]<br>fun [from](from.md)(value: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [Uuid](../index.md)<br>Creates a [Uuid](../index.md) from the provided [ByteArray](from.md) representation of a [Uuid](../index.md).<br>[common]<br>fun [from](from.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Uuid](../index.md)<br>Creates a [Uuid](../index.md) from the provided [String](from.md) representation of a [Uuid](../index.md).<br>[common]<br>fun [from](from.md)(mostSignificantBits: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), leastSignificantBits: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Uuid](../index.md)<br>Creates a [Uuid](../index.md) from the provided [mostSignificantBits](from.md) and [leastSignificantBits](from.md) values which are the most significant and least significant bits of a [Uuid](../index.md), which together represent the full 128-bits of a UUID. |
