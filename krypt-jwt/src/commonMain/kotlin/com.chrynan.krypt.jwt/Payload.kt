package com.chrynan.krypt.jwt

/**
 * An interface representing a JWT Payload. JWT Payloads contain optional [ReservedClaims], but any other property can
 * be used. As such, a JWT Payload is any serializable class that extends this interface.
 *
 * This represents a decoded Payload, meaning a Kotlin object representation of the Payload and **not** the Base64
 * encoded JSON [String] representation.
 *
 * Note that this interface works for both JWT and JWS.
 *
 * @see [JWT Specification](https://datatracker.ietf.org/doc/html/rfc7519#section-4.1)
 */
interface Payload : ReservedClaims

/**
 * Creates a default instance of the [Payload] interface. The returned type is [DefaultPayload], which is an immutable
 * data class, which copies can be made of using the `copy` function.
 *
 * @param [issuer] [ReservedClaims.issuer]
 * @param [subject] [ReservedClaims.subject]
 * @param [audience] [ReservedClaims.audience]
 * @param [expiration] [ReservedClaims.expiration]
 * @param [notBefore] [ReservedClaims.notBefore]
 * @param [issuedAt] [ReservedClaims.issuedAt]
 * @param [id] [ReservedClaims.id]
 */
@Suppress("FunctionName")
fun Payload(
    issuer: String? = null,
    subject: String? = null,
    audience: String? = null,
    expiration: Long? = null,
    notBefore: Long? = null,
    issuedAt: Long? = null,
    id: String? = null
): DefaultPayload = DefaultPayload(
    issuer = issuer,
    subject = subject,
    audience = audience,
    expiration = expiration,
    notBefore = notBefore,
    issuedAt = issuedAt,
    id = id
)

/**
 * A default implementation of the [Payload] interface. This implementation only has the properties defined by the
 * [Payload] interface and no extras. To create an instance of this class, use the [Payload] constructor function.
 */
data class DefaultPayload internal constructor(
    override val issuer: String?,
    override val subject: String?,
    override val audience: String?,
    override val expiration: Long?,
    override val notBefore: Long?,
    override val issuedAt: Long?,
    override val id: String?
) : Payload
