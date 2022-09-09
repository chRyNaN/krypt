//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[Header](index.md)

# Header

[common]\
interface [Header](index.md) : [ReservedHeaderParameters](../-reserved-header-parameters/index.md)

An interface representing a JWT Header. JWT Headers contain optional [ReservedHeaderParameters](../-reserved-header-parameters/index.md), but any other parameter can be used. As such, a JWT Header is any serializable class that extends this interface.

This represents a decoded Header, meaning a Kotlin object representation of the Header and **not** the Base64 encoded JSON [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) representation.

Note that this interface works for both JWT and JWS.

## See also

common

| | |
|---|---|
|  | [JWT Specification](https://datatracker.ietf.org/doc/html/rfc7519#section-5) |

## Properties

| Name | Summary |
|---|---|
| [algorithm](../-reserved-header-parameters/algorithm.md) | [common]<br>open val [algorithm](../-reserved-header-parameters/algorithm.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;alg&quot; (algorithm) Header Parameter identifies the cryptographic algorithm used to secure the JWS. |
| [contentType](../-reserved-header-parameters/content-type.md) | [common]<br>open val [contentType](../-reserved-header-parameters/content-type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;cty&quot; (content type) Header Parameter is used by JWS applications to declare the media type [IANA.MediaTypes](https://datatracker.ietf.org/doc/html/rfc7515#ref-IANA.MediaTypes) of the secured content (the payload). |
| [critical](../-reserved-header-parameters/critical.md) | [common]<br>open val [critical](../-reserved-header-parameters/critical.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;crit&quot; (critical) Header Parameter indicates that extensions to this specification and/or [JWA](https://datatracker.ietf.org/doc/html/rfc7515#ref-JWA) are being used that MUST be understood and processed. |
| [jwk](../-reserved-header-parameters/jwk.md) | [common]<br>open val [jwk](../-reserved-header-parameters/jwk.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;jwk&quot; (JSON Web Key) Header Parameter is the public key that corresponds to the key used to digitally sign the JWS. |
| [jwkSetUrl](../-reserved-header-parameters/jwk-set-url.md) | [common]<br>open val [jwkSetUrl](../-reserved-header-parameters/jwk-set-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;jku&quot; (JWK Set URL) Header Parameter is a URI [RFC3986](https://datatracker.ietf.org/doc/html/rfc3986) that refers to a resource for a set of JSON-encoded public keys, one of which corresponds to the key used to digitally sign the JWS. |
| [keyId](../-reserved-header-parameters/key-id.md) | [common]<br>open val [keyId](../-reserved-header-parameters/key-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;kid&quot; (key ID) Header Parameter is a hint indicating which keywas used to secure the JWS. |
| [type](../-reserved-header-parameters/type.md) | [common]<br>open val [type](../-reserved-header-parameters/type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;typ&quot; (type) Header Parameter is used by JWS applications to declare the media type [IANA.MediaTypes](https://datatracker.ietf.org/doc/html/rfc7515#ref-IANA.MediaTypes) of this complete JWS. |
| [x5c](../-reserved-header-parameters/x5c.md) | [common]<br>open val [x5c](../-reserved-header-parameters/x5c.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;x5c&quot; (X.509 certificate chain) Header Parameter contains the X.509 public key certificate or certificate chain [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the JWS. |
| [x5t](../-reserved-header-parameters/x5t.md) | [common]<br>open val [x5t](../-reserved-header-parameters/x5t.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;x5t&quot; (X.509 certificate SHA-1 thumbprint) Header Parameter is a base64url-encoded SHA-1 thumbprint (a.k.a. digest) of the DER encoding of the X.509 certificate [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the JWS. |
| [x5tS256](../-reserved-header-parameters/x5t-s256.md) | [common]<br>open val [x5tS256](../-reserved-header-parameters/x5t-s256.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;x5t#S256&quot; (X.509 certificate SHA-256 thumbprint) Header Parameter is a base64url-encoded SHA-256 thumbprint (a.k.a. digest) of the DER encoding of the X.509 certificate [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the JWS. |
| [x5u](../-reserved-header-parameters/x5u.md) | [common]<br>open val [x5u](../-reserved-header-parameters/x5u.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;x5u&quot; (X.509 URL) Header Parameter is a URI [RFC3986](https://datatracker.ietf.org/doc/html/rfc3986) that refers to a resource for the X.509 public key certificate or certificate chain [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the JWS. |

## Inheritors

| Name |
|---|
| [DefaultHeader](../-default-header/index.md) |
