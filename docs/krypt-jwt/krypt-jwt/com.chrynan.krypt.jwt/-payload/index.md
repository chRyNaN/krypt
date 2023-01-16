//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[Payload](index.md)

# Payload

[common]\
interface [Payload](index.md) : [ReservedClaims](../-reserved-claims/index.md)

An interface representing a JWT Payload. JWT Payloads contain optional [ReservedClaims](../-reserved-claims/index.md), but any other property can be used. As such, a JWT Payload is any serializable class that extends this interface.

This represents a decoded Payload, meaning a Kotlin object representation of the Payload and **not** the Base64 encoded JSON [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) representation.

Note that this interface works for both JWT and JWS.

#### See also

common

| | |
|---|---|
|  | [JWT Specification](https://datatracker.ietf.org/doc/html/rfc7519#section-4.1) |

## Properties

| Name | Summary |
|---|---|
| [audience](../-reserved-claims/audience.md) | [common]<br>open val [audience](../-reserved-claims/audience.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;aud&quot; (audience) claim identifies the recipients that the JWT is intended for. |
| [expiration](../-reserved-claims/expiration.md) | [common]<br>open val [expiration](../-reserved-claims/expiration.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?<br>The &quot;exp&quot; (expiration time) claim identifies the expiration time on or after which the JWT MUST NOT be accepted for processing. This value should be a &quot;Numeric Date&quot; which is a JSON number value representing the **seconds** since the Epoch. |
| [id](../-reserved-claims/id.md) | [common]<br>open val [id](../-reserved-claims/id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;jti&quot; (JWT ID) claim provides a unique identifier for the JWT. |
| [issuedAt](../-reserved-claims/issued-at.md) | [common]<br>open val [issuedAt](../-reserved-claims/issued-at.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?<br>The &quot;iat&quot; (issued at) claim identifies the time at which the JWT was issued. This value should be a &quot;Numeric Date&quot; which is a JSON number value representing the **seconds** since the Epoch. |
| [issuer](../-reserved-claims/issuer.md) | [common]<br>open val [issuer](../-reserved-claims/issuer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;iss&quot; (issuer) claim identifies the principal that issued the JWT. |
| [notBefore](../-reserved-claims/not-before.md) | [common]<br>open val [notBefore](../-reserved-claims/not-before.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?<br>The &quot;nbf&quot; (not before) claim identifies the time before which the JWT MUST NOT be accepted for processing. This value should be a &quot;Numeric Date&quot; which is a JSON number value representing the **seconds** since the Epoch. |
| [subject](../-reserved-claims/subject.md) | [common]<br>open val [subject](../-reserved-claims/subject.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;sub&quot; (subject) claim identifies the principal that is the subject of the JWT. |

## Inheritors

| Name |
|---|
| [DefaultPayload](../-default-payload/index.md) |
