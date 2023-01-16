//[krypt-jwt](../../index.md)/[com.chrynan.krypt.jwt](index.md)/[Header](-header.md)

# Header

[common]\
fun [Header](-header.md)(algorithm: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, jwkSetUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, jwk: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, keyId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, x5u: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, x5c: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, x5t: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, x5tS256: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, type: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, contentType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, critical: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [DefaultHeader](-default-header/index.md)

Creates a default instance of the [Header](-header/index.md) interface. The returned type is [DefaultHeader](-default-header/index.md), which is an immutable data class, which copies can be made of using the `copy` function.

#### Parameters

common

| | |
|---|---|
| algorithm | [ReservedHeaderParameters.algorithm](-reserved-header-parameters/algorithm.md) |
| jwkSetUrl | [ReservedHeaderParameters.jwkSetUrl](-reserved-header-parameters/jwk-set-url.md) |
| jwk | [ReservedHeaderParameters.jwk](-reserved-header-parameters/jwk.md) |
| keyId | [ReservedHeaderParameters.keyId](-reserved-header-parameters/key-id.md) |
| x5u | [ReservedHeaderParameters.x5u](-reserved-header-parameters/x5u.md) |
| x5c | [ReservedHeaderParameters.x5c](-reserved-header-parameters/x5c.md) |
| x5t | [ReservedHeaderParameters.x5t](-reserved-header-parameters/x5t.md) |
| x5tS256 | [ReservedHeaderParameters.x5tS256](-reserved-header-parameters/x5t-s256.md) |
| type | [ReservedHeaderParameters.type](-reserved-header-parameters/type.md) |
| contentType | [ReservedHeaderParameters.contentType](-reserved-header-parameters/content-type.md) |
| critical | [ReservedHeaderParameters.critical](-reserved-header-parameters/critical.md) |
