//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[ReservedClaims](index.md)

# ReservedClaims

[common]\
interface [ReservedClaims](index.md)

An interface that represents reserved JWT payload claim names. JWT payloads can include more than just these specified claims.

Note that it is important to make sure that the SerialName values for each property are used correctly by implementing classes. Refer to the [Names](-names/index.md) object for the correct SerialName usage for each property.

#### See also

common

| | |
|---|---|
|  | [JWT Specification](https://datatracker.ietf.org/doc/html/rfc7519#section-4.1) |

## Types

| Name | Summary |
|---|---|
| [Names](-names/index.md) | [common]<br>object [Names](-names/index.md) |

## Properties

| Name | Summary |
|---|---|
| [audience](audience.md) | [common]<br>open val [audience](audience.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;aud&quot; (audience) claim identifies the recipients that the JWT is intended for. |
| [expiration](expiration.md) | [common]<br>open val [expiration](expiration.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?<br>The &quot;exp&quot; (expiration time) claim identifies the expiration time on or after which the JWT MUST NOT be accepted for processing. This value should be a &quot;Numeric Date&quot; which is a JSON number value representing the **seconds** since the Epoch. |
| [id](id.md) | [common]<br>open val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;jti&quot; (JWT ID) claim provides a unique identifier for the JWT. |
| [issuedAt](issued-at.md) | [common]<br>open val [issuedAt](issued-at.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?<br>The &quot;iat&quot; (issued at) claim identifies the time at which the JWT was issued. This value should be a &quot;Numeric Date&quot; which is a JSON number value representing the **seconds** since the Epoch. |
| [issuer](issuer.md) | [common]<br>open val [issuer](issuer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;iss&quot; (issuer) claim identifies the principal that issued the JWT. |
| [notBefore](not-before.md) | [common]<br>open val [notBefore](not-before.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?<br>The &quot;nbf&quot; (not before) claim identifies the time before which the JWT MUST NOT be accepted for processing. This value should be a &quot;Numeric Date&quot; which is a JSON number value representing the **seconds** since the Epoch. |
| [subject](subject.md) | [common]<br>open val [subject](subject.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;sub&quot; (subject) claim identifies the principal that is the subject of the JWT. |

## Inheritors

| Name |
|---|
| [Payload](../-payload/index.md) |
