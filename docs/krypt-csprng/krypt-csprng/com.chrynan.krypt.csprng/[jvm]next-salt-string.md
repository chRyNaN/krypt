//[krypt-csprng](../../index.md)/[com.chrynan.krypt.csprng](index.md)/[[jvm]nextSaltString]([jvm]next-salt-string.md)

# nextSaltString

[jvm]\
fun [SecureRandom](-secure-random/index.md).[nextSaltString]([jvm]next-salt-string.md)(byteCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 16, charset: [Charset](https://developer.android.com/reference/kotlin/java/nio/charset/Charset.html) = Charsets.UTF_8): [SecureString](../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md)

Retrieves a [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) from this [SecureRandom](-secure-random/index.md) to be used as a salt, which is typically used when hashing passwords. This is a convenience function which delegates to the [SecureRandom.nextBytes](-secure-random/[jvm]next-bytes.md) function.

## Parameters

jvm

| | |
|---|---|
| byteCount | The size of the returned [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html). |
| charset | The [Charset](https://developer.android.com/reference/kotlin/java/nio/charset/Charset.html) used for the returned salt. Defaults to [Charsets.UTF_8](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-charsets/-u-t-f_8.html). |
