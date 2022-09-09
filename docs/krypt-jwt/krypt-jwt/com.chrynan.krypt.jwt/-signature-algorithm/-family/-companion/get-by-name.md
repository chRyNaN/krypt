//[krypt-jwt](../../../../../index.md)/[com.chrynan.krypt.jwt](../../../index.md)/[SignatureAlgorithm](../../index.md)/[Family](../index.md)/[Companion](index.md)/[getByName](get-by-name.md)

# getByName

[common]\
fun [getByName](get-by-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), ignoreCase: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): [SignatureAlgorithm.Family](../index.md)?

Retrieves the [SignatureAlgorithm.Family](../index.md) whose [SignatureAlgorithm.Family.typeName](../type-name.md) property equals the provided [value](get-by-name.md), optionally ingoring case sensitivity depending on the provided [ignoreCase](get-by-name.md) value, or `null` if no value was found that matches.
