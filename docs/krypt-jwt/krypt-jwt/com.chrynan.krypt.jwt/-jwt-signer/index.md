//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[JwtSigner](index.md)

# JwtSigner

[common]\
interface [JwtSigner](index.md)

## Functions

| Name | Summary |
|---|---|
| [sign](sign.md) | [common]<br>abstract suspend fun [sign](sign.md)(key: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), algorithm: [SignatureAlgorithm](../-signature-algorithm/index.md), value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), encoder: [Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Inheritors

| Name |
|---|
| [AndroidJwtSigner](../-android-jwt-signer/index.md) |
| [JvmJwtSigner](../-jvm-jwt-signer/index.md) |
