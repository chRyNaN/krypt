@file:Suppress("unused")

package com.chrynan.krypt.jwt

import kotlinx.serialization.SerialName

/**
 * An interface that represents reserved JWT payload claim names. JWT payloads can include more than just these
 * specified claims.
 *
 * Note that it is important to make sure that the [SerialName] values for each property are used correctly by
 * implementing classes. Refer to the [Names] object for the correct [SerialName] usage for each property.
 *
 * @see [JWT Specification](https://datatracker.ietf.org/doc/html/rfc7519#section-4.1)
 */
interface ReservedClaims {

    /**
     * The "iss" (issuer) claim identifies the principal that issued the JWT.
     *
     * Value defaults to `null`.
     *
     * @see [JWT Definition](https://datatracker.ietf.org/doc/html/rfc7519#section-4.1.1)
     */
    @SerialName(value = Names.ISSUER)
    val issuer: String?
        get() = null

    /**
     * The "sub" (subject) claim identifies the principal that is the subject of the JWT.
     *
     * Value defaults to `null`.
     *
     * @see [JWT Definition](https://datatracker.ietf.org/doc/html/rfc7519#section-4.1.2)
     */
    @SerialName(value = Names.SUBJECT)
    val subject: String?
        get() = null

    /**
     * The "aud" (audience) claim identifies the recipients that the JWT is intended for.
     *
     * Value defaults to `null`.
     *
     * @see [JWT Definition](https://datatracker.ietf.org/doc/html/rfc7519#section-4.1.3)
     */
    @SerialName(value = Names.AUDIENCE)
    val audience: String?
        get() = null

    /**
     * The "exp" (expiration time) claim identifies the expiration time on or after which the JWT MUST NOT be accepted
     * for processing. This value should be a "Numeric Date" which is a JSON number value representing the
     * **seconds** since the Epoch.
     *
     * Value defaults to `null`.
     *
     * @see [JWT Definition](https://datatracker.ietf.org/doc/html/rfc7519#section-4.1.4)
     * @see [Numerical Date](https://www.rfc-editor.org/rfc/rfc7519#section-2)
     */
    @SerialName(value = Names.EXPIRATION)
    val expiration: Long?
        get() = null

    /**
     * The "nbf" (not before) claim identifies the time before which the JWT MUST NOT be accepted for processing. This
     * value should be a "Numeric Date" which is a JSON number value representing the **seconds** since the Epoch.
     *
     * Value defaults to `null`.
     *
     * @see [JWT Definition](https://datatracker.ietf.org/doc/html/rfc7519#section-4.1.5)
     * @see [Numerical Date](https://www.rfc-editor.org/rfc/rfc7519#section-2)
     */
    @SerialName(value = Names.NOT_BEFORE)
    val notBefore: Long?
        get() = null

    /**
     * The "iat" (issued at) claim identifies the time at which the JWT was issued. This value should be a
     * "Numeric Date" which is a JSON number value representing the **seconds** since the Epoch.
     *
     * Value defaults to `null`.
     *
     * @see [JWT Definition](https://datatracker.ietf.org/doc/html/rfc7519#section-4.1.6)
     * @see [Numerical Date](https://www.rfc-editor.org/rfc/rfc7519#section-2)
     */
    @SerialName(value = Names.ISSUED_AT)
    val issuedAt: Long?
        get() = null

    /**
     * The "jti" (JWT ID) claim provides a unique identifier for the JWT.
     *
     * Value defaults to `null`.
     *
     * @see [JWT Definition](https://datatracker.ietf.org/doc/html/rfc7519#section-4.1.7)
     */
    @SerialName(value = Names.ID)
    val id: String?
        get() = null

    object Names {

        const val ISSUER = "iss"
        const val SUBJECT = "sub"
        const val AUDIENCE = "aud"
        const val EXPIRATION = "exp"
        const val NOT_BEFORE = "nbf"
        const val ISSUED_AT = "iat"
        const val ID = "jti"
    }
}
