//[krypt-csprng](../../index.md)/[com.chrynan.krypt.csprng](index.md)/[nextSalt](next-salt.md)

# nextSalt

[common]\
fun [SecureRandom](-secure-random/index.md).[nextSalt](next-salt.md)(byteCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 16): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)

Retrieves a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) from this [SecureRandom](-secure-random/index.md) to be used as a salt, which is typically used when hashing passwords. This is a convenience function which delegates to the [SecureRandom.nextBytes](-secure-random/index.md#522760022%2FFunctions%2F-1023948260) function.

## Parameters

common

| | |
|---|---|
| byteCount | The size of the returned [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html). |
