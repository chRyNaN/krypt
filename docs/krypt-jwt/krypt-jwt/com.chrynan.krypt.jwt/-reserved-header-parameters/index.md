//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[ReservedHeaderParameters](index.md)

# ReservedHeaderParameters

[common]\
interface [ReservedHeaderParameters](index.md)

An interface that represents reserved JWT Header parameters. JWT Headers can include more than just these specified parameters.

Note that this interface includes both the reserved JWT Header parameters and the JWS Header parameters. Since all the parameters are optional, and this provides type safety and helps to prevent name clashes, it should be fine to include both the JWT and JWS Header parameters in one interface.

Note that it is important to make sure that the SerialName values for each property are used correctly by implementing classes. Refer to the [Names](-names/index.md) object for the correct SerialName usage for each property.

## See also

common

| | |
|---|---|
|  | [JWT Specification](https://datatracker.ietf.org/doc/html/rfc7519#section-5) |

## Types

| Name | Summary |
|---|---|
| [Names](-names/index.md) | [common]<br>object [Names](-names/index.md) |

## Properties

| Name | Summary |
|---|---|
| [algorithm](algorithm.md) | [common]<br>open val [algorithm](algorithm.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;alg&quot; (algorithm) Header Parameter identifies the cryptographic algorithm used to secure the JWS. |
| [contentType](content-type.md) | [common]<br>open val [contentType](content-type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;cty&quot; (content type) Header Parameter is used by JWS applications to declare the media type [IANA.MediaTypes](https://datatracker.ietf.org/doc/html/rfc7515#ref-IANA.MediaTypes) of the secured content (the payload). |
| [critical](critical.md) | [common]<br>open val [critical](critical.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;crit&quot; (critical) Header Parameter indicates that extensions to this specification and/or [JWA](https://datatracker.ietf.org/doc/html/rfc7515#ref-JWA) are being used that MUST be understood and processed. |
| [jwk](jwk.md) | [common]<br>open val [jwk](jwk.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;jwk&quot; (JSON Web Key) Header Parameter is the public key that corresponds to the key used to digitally sign the JWS. |
| [jwkSetUrl](jwk-set-url.md) | [common]<br>open val [jwkSetUrl](jwk-set-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;jku&quot; (JWK Set URL) Header Parameter is a URI [RFC3986](https://datatracker.ietf.org/doc/html/rfc3986) that refers to a resource for a set of JSON-encoded public keys, one of which corresponds to the key used to digitally sign the JWS. |
| [keyId](key-id.md) | [common]<br>open val [keyId](key-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;kid&quot; (key ID) Header Parameter is a hint indicating which keywas used to secure the JWS. |
| [type](type.md) | [common]<br>open val [type](type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;typ&quot; (type) Header Parameter is used by JWS applications to declare the media type [IANA.MediaTypes](https://datatracker.ietf.org/doc/html/rfc7515#ref-IANA.MediaTypes) of this complete JWS. |
| [x5c](x5c.md) | [common]<br>open val [x5c](x5c.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;x5c&quot; (X.509 certificate chain) Header Parameter contains the X.509 public key certificate or certificate chain [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the JWS. |
| [x5t](x5t.md) | [common]<br>open val [x5t](x5t.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;x5t&quot; (X.509 certificate SHA-1 thumbprint) Header Parameter is a base64url-encoded SHA-1 thumbprint (a.k.a. digest) of the DER encoding of the X.509 certificate [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the JWS. |
| [x5tS256](x5t-s256.md) | [common]<br>open val [x5tS256](x5t-s256.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;x5t#S256&quot; (X.509 certificate SHA-256 thumbprint) Header Parameter is a base64url-encoded SHA-256 thumbprint (a.k.a. digest) of the DER encoding of the X.509 certificate [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the JWS. |
| [x5u](x5u.md) | [common]<br>open val [x5u](x5u.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;x5u&quot; (X.509 URL) Header Parameter is a URI [RFC3986](https://datatracker.ietf.org/doc/html/rfc3986) that refers to a resource for the X.509 public key certificate or certificate chain [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the JWS. |

## Inheritors

| Name |
|---|
| [Header](../-header/index.md) |
