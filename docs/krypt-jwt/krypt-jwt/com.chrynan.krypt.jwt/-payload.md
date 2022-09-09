//[krypt-jwt](../../index.md)/[com.chrynan.krypt.jwt](index.md)/[Payload](-payload.md)

# Payload

[common]\
fun [Payload](-payload.md)(issuer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, subject: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, audience: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, expiration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, notBefore: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, issuedAt: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [DefaultPayload](-default-payload/index.md)

Creates a default instance of the [Payload](-payload/index.md) interface. The returned type is [DefaultPayload](-default-payload/index.md), which is an immutable data class, which copies can be made of using the `copy` function.

## Parameters

common

| | |
|---|---|
| issuer | [ReservedClaims.issuer](-reserved-claims/issuer.md) |
| subject | [ReservedClaims.subject](-reserved-claims/subject.md) |
| audience | [ReservedClaims.audience](-reserved-claims/audience.md) |
| expiration | [ReservedClaims.expiration](-reserved-claims/expiration.md) |
| notBefore | [ReservedClaims.notBefore](-reserved-claims/not-before.md) |
| issuedAt | [ReservedClaims.issuedAt](-reserved-claims/issued-at.md) |
| id | [ReservedClaims.id](-reserved-claims/id.md) |
