//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[ReservedClaims](index.md)/[notBefore](not-before.md)

# notBefore

[common]\
open val [notBefore](not-before.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?

The &quot;nbf&quot; (not before) claim identifies the time before which the JWT MUST NOT be accepted for processing. This value should be a &quot;Numeric Date&quot; which is a JSON number value representing the **seconds** since the Epoch.

Value defaults to `null`.

## See also

common

| | |
|---|---|
|  | [Numerical Date](https://www.rfc-editor.org/rfc/rfc7519#section-2) |
