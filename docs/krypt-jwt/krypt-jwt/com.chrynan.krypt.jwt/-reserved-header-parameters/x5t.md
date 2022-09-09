//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[ReservedHeaderParameters](index.md)/[x5t](x5t.md)

# x5t

[common]\
open val [x5t](x5t.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?

The &quot;x5t&quot; (X.509 certificate SHA-1 thumbprint) Header Parameter is a base64url-encoded SHA-1 thumbprint (a.k.a. digest) of the DER encoding of the X.509 certificate [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the JWS.

Value defaults to `null`.

## See also

common

| | |
|---|---|
|  | [JWS Definition](https://datatracker.ietf.org/doc/html/rfc7515#section-4.1.7) |
