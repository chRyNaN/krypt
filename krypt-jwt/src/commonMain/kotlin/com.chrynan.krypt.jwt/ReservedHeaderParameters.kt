@file:Suppress("unused")

package com.chrynan.krypt.jwt

import kotlinx.serialization.SerialName

/**
 * An interface that represents reserved JWT Header parameters. JWT Headers can include more than just these specified
 * parameters.
 *
 * Note that this interface includes both the reserved JWT Header parameters and the JWS Header parameters. Since all
 * the parameters are optional, and this provides type safety and helps to prevent name clashes, it should be fine to
 * include both the JWT and JWS Header parameters in one interface.
 *
 * Note that it is important to make sure that the [SerialName] values for each property are used correctly by
 * implementing classes. Refer to the [Names] object for the correct [SerialName] usage for each property.
 *
 * @see [JWS Specification](https://datatracker.ietf.org/doc/html/rfc7515#section-4.1)
 * @see [JWT Specification](https://datatracker.ietf.org/doc/html/rfc7519#section-5)
 */
interface ReservedHeaderParameters {

    /**
     * The "alg" (algorithm) Header Parameter identifies the cryptographic algorithm used to secure the JWS.
     *
     * Value defaults to `null`.
     *
     * @see [JWS Definition](https://datatracker.ietf.org/doc/html/rfc7515#section-4.1.1)
     */
    @SerialName(value = Names.ALGORITHM)
    val algorithm: String?
        get() = null

    /**
     * The "jku" (JWK Set URL) Header Parameter is a URI [RFC3986](https://datatracker.ietf.org/doc/html/rfc3986) that
     * refers to a resource for a set of JSON-encoded public keys, one of which corresponds to the key used to
     * digitally sign the JWS.
     *
     * Value defaults to `null`.
     *
     * @see [JWS Definition](https://datatracker.ietf.org/doc/html/rfc7515#section-4.1.2)
     */
    @SerialName(value = Names.JWK_SET_URL)
    val jwkSetUrl: String?
        get() = null

    /**
     * The "jwk" (JSON Web Key) Header Parameter is the public key that corresponds to the key used to digitally sign
     * the JWS.
     *
     * Value defaults to `null`.
     *
     * @see [JWS Definition](https://datatracker.ietf.org/doc/html/rfc7515#section-4.1.3)
     */
    @SerialName(value = Names.JWK)
    val jwk: String?
        get() = null

    /**
     * The "kid" (key ID) Header Parameter is a hint indicating which keywas used to secure the JWS.
     *
     * Value defaults to `null`.
     *
     * @see [JWS Definition](https://datatracker.ietf.org/doc/html/rfc7515#section-4.1.4)
     */
    @SerialName(value = Names.KEY_ID)
    val keyId: String?
        get() = null

    /**
     * The "x5u" (X.509 URL) Header Parameter is a URI [RFC3986](https://datatracker.ietf.org/doc/html/rfc3986) that
     * refers to a resource for the X.509 public key certificate or certificate chain
     * [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the
     * JWS.
     *
     * Value defaults to `null`.
     *
     * @see [JWS Definition](https://datatracker.ietf.org/doc/html/rfc7515#section-4.1.5)
     */
    @SerialName(value = Names.X5U)
    val x5u: String?
        get() = null

    /**
     * The "x5c" (X.509 certificate chain) Header Parameter contains the X.509 public key certificate or certificate
     * chain [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign
     * the JWS.
     *
     * Value defaults to `null`.
     *
     * @see [JWS Definition](https://datatracker.ietf.org/doc/html/rfc7515#section-4.1.6)
     */
    @SerialName(value = Names.X5C)
    val x5c: String?
        get() = null

    /**
     * The "x5t" (X.509 certificate SHA-1 thumbprint) Header Parameter is a base64url-encoded SHA-1 thumbprint
     * (a.k.a. digest) of the DER encoding of the X.509 certificate
     * [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the
     * JWS.
     *
     * Value defaults to `null`.
     *
     * @see [JWS Definition](https://datatracker.ietf.org/doc/html/rfc7515#section-4.1.7)
     */
    @SerialName(value = Names.X5T)
    val x5t: String?
        get() = null

    /**
     * The "x5t#S256" (X.509 certificate SHA-256 thumbprint) Header Parameter is a base64url-encoded SHA-256 thumbprint
     * (a.k.a. digest) of the DER encoding of the X.509 certificate
     * [RFC5280](https://datatracker.ietf.org/doc/html/rfc5280) corresponding to the key used to digitally sign the
     * JWS.
     *
     * Value defaults to `null`.
     *
     * @see [JWS Definition](https://datatracker.ietf.org/doc/html/rfc7515#section-4.1.8)
     */
    @SerialName(value = Names.X5T_S256)
    val x5tS256: String?
        get() = null

    /**
     * The "typ" (type) Header Parameter is used by JWS applications to declare the media type
     * [IANA.MediaTypes](https://datatracker.ietf.org/doc/html/rfc7515#ref-IANA.MediaTypes) of this complete JWS.
     *
     * Value defaults to `null`.
     *
     * @see [JWS Definition](https://datatracker.ietf.org/doc/html/rfc7515#section-4.1.9)
     * @see [JWT Definition](https://datatracker.ietf.org/doc/html/rfc7519#section-5.1)
     */
    @SerialName(value = Names.TYPE)
    val type: String?
        get() = null

    /**
     * The "cty" (content type) Header Parameter is used by JWS applications to declare the media type
     * [IANA.MediaTypes](https://datatracker.ietf.org/doc/html/rfc7515#ref-IANA.MediaTypes) of the secured content
     * (the payload).
     *
     * Value defaults to `null`.
     *
     * @see [JWS Definition](https://datatracker.ietf.org/doc/html/rfc7515#section-4.1.10)
     * @see [JWT Definition](https://datatracker.ietf.org/doc/html/rfc7519#section-5.2)
     */
    @SerialName(value = Names.CONTENT_TYPE)
    val contentType: String?
        get() = null

    /**
     * The "crit" (critical) Header Parameter indicates that extensions to this specification and/or
     * [JWA](https://datatracker.ietf.org/doc/html/rfc7515#ref-JWA) are being used that MUST be understood and
     * processed.
     *
     * Value defaults to `null`.
     *
     * @see [JWS Definition](https://datatracker.ietf.org/doc/html/rfc7515#section-4.1.11)
     */
    @SerialName(value = Names.CRITICAL)
    val critical: String?
        get() = null

    object Names {

        const val ALGORITHM = "alg"
        const val JWK_SET_URL = "jku"
        const val JWK = "jwk"
        const val KEY_ID = "kid"
        const val X5U = "x5u"
        const val X5C = "x5c"
        const val X5T = "x5t"
        const val X5T_S256 = "x5t#S256"
        const val TYPE = "typ"
        const val CONTENT_TYPE = "cty"
        const val CRITICAL = "crit"
    }
}
