//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[DefaultPayload](index.md)

# DefaultPayload

[common]\
data class [DefaultPayload](index.md) : [Payload](../-payload/index.md)

A default implementation of the [Payload](../-payload/index.md) interface. This implementation only has the properties defined by the [Payload](../-payload/index.md) interface and no extras. To create an instance of this class, use the [Payload](../-payload/index.md) constructor function.

## Properties

| Name | Summary |
|---|---|
| [audience](audience.md) | [common]<br>open override val [audience](audience.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;aud&quot; (audience) claim identifies the recipients that the JWT is intended for. |
| [expiration](expiration.md) | [common]<br>open override val [expiration](expiration.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?<br>The &quot;exp&quot; (expiration time) claim identifies the expiration time on or after which the JWT MUST NOT be accepted for processing. This value should be a &quot;Numeric Date&quot; which is a JSON number value representing the **seconds** since the Epoch. |
| [id](id.md) | [common]<br>open override val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;jti&quot; (JWT ID) claim provides a unique identifier for the JWT. |
| [issuedAt](issued-at.md) | [common]<br>open override val [issuedAt](issued-at.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?<br>The &quot;iat&quot; (issued at) claim identifies the time at which the JWT was issued. This value should be a &quot;Numeric Date&quot; which is a JSON number value representing the **seconds** since the Epoch. |
| [issuer](issuer.md) | [common]<br>open override val [issuer](issuer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;iss&quot; (issuer) claim identifies the principal that issued the JWT. |
| [notBefore](not-before.md) | [common]<br>open override val [notBefore](not-before.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?<br>The &quot;nbf&quot; (not before) claim identifies the time before which the JWT MUST NOT be accepted for processing. This value should be a &quot;Numeric Date&quot; which is a JSON number value representing the **seconds** since the Epoch. |
| [subject](subject.md) | [common]<br>open override val [subject](subject.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;sub&quot; (subject) claim identifies the principal that is the subject of the JWT. |
