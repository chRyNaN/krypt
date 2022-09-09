//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[DefaultPayload](index.md)/[expiration](expiration.md)

# expiration

[common]\
open override val [expiration](expiration.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?

The &quot;exp&quot; (expiration time) claim identifies the expiration time on or after which the JWT MUST NOT be accepted for processing. This value should be a &quot;Numeric Date&quot; which is a JSON number value representing the **seconds** since the Epoch.

Value defaults to `null`.

## See also

common

| | |
|---|---|
|  | [Numerical Date](https://www.rfc-editor.org/rfc/rfc7519#section-2) |
