//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[DefaultHeader](index.md)

# DefaultHeader

[common]\
@Serializable

data class [DefaultHeader](index.md) : [Header](../-header/index.md)

A default implementation of the [Header](../-header/index.md) interface. This implementation only has the properties defined by the [Header](../-header/index.md) interface and no extras. To create an instance of this class, use the [Header](../-header/index.md) constructor function.

## Properties

| Name | Summary |
|---|---|
| [algorithm](algorithm.md) | [common]<br>open override val [algorithm](algorithm.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;alg&quot; (algorithm) Header Parameter identifies the cryptographic algorithm used to secure the JWS. |
| [contentType](content-type.md) | [common]<br>open override val [contentType](content-type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;cty&quot; (content type) Header Parameter is used by JWS applications to declare the media type [IANA.MediaTypes](https://datatracker.ietf.org/doc/html/rfc7515#ref-IANA.MediaTypes) of the secured content (the payload). |
| [critical](critical.md) | [common]<br>open override val [critical](critical.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;crit&quot; (critical) Header Parameter indicates that extensions to this specification and/or [JWA](https://datatracker.ietf.org/doc/html/rfc7515#ref-JWA) are being used that MUST be understood and processed. |
| [jwk](jwk.md) | [common]<br>open override val [jwk](jwk.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;jwk&quot; (JSON Web Key) Header Parameter is the public key that corresponds to the key used to digitally sign the JWS. |
| [jwkSetUrl](jwk-set-url.md) | [common]<br>open override val [jwkSetUrl](jwk-set-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;jku&quot; (JWK Set URL) Header Parameter is a URI [RFC3986](https://datatracker.ietf.org/doc/html/rfc3986) that refers to a resource for a set of JSON-encoded public keys, one of which corresponds to the key used to digitally sign the JWS. |
| [keyId](key-id.md) | [common]<br>open override val [keyId](key-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;kid&quot; (key ID) Header Parameter is a hint indicating which keywas used to secure the JWS. |
| [type](type.md) | [common]<br>open override val [type](type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;typ&quot; (type) Header Parameter is used by JWS applications to declare the media type [IANA.MediaTypes](https://datatracker.ietf.org/doc/html/rfc7515#ref-IANA.MediaTypes) of this complete JWS. |
| [x5c](x5c.md) | [common]<br>open override val [x5c](x5c.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;x5c&quot; (X.509 certificate chain) Header Parameter contains the X.509 public key certificate or certificate chain [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the JWS. |
| [x5t](x5t.md) | [common]<br>open override val [x5t](x5t.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;x5t&quot; (X.509 certificate SHA-1 thumbprint) Header Parameter is a base64url-encoded SHA-1 thumbprint (a.k.a. digest) of the DER encoding of the X.509 certificate [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the JWS. |
| [x5tS256](x5t-s256.md) | [common]<br>open override val [x5tS256](x5t-s256.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;x5t#S256&quot; (X.509 certificate SHA-256 thumbprint) Header Parameter is a base64url-encoded SHA-256 thumbprint (a.k.a. digest) of the DER encoding of the X.509 certificate [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the JWS. |
| [x5u](x5u.md) | [common]<br>open override val [x5u](x5u.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The &quot;x5u&quot; (X.509 URL) Header Parameter is a URI [RFC3986](https://datatracker.ietf.org/doc/html/rfc3986) that refers to a resource for the X.509 public key certificate or certificate chain [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the JWS. |
