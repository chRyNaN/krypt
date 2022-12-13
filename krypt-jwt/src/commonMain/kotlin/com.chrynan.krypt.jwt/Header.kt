package com.chrynan.krypt.jwt

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

/**
 * An interface representing a JWT Header. JWT Headers contain optional [ReservedHeaderParameters], but any other
 * parameter can be used. As such, a JWT Header is any serializable class that extends this interface.
 *
 * This represents a decoded Header, meaning a Kotlin object representation of the Header and **not** the Base64
 * encoded JSON [String] representation.
 *
 * Note that this interface works for both JWT and JWS.
 *
 * @see [JWT Specification](https://datatracker.ietf.org/doc/html/rfc7519#section-5)
 */
interface Header : ReservedHeaderParameters

/**
 * Creates a default instance of the [Header] interface. The returned type is [DefaultHeader], which is an immutable
 * data class, which copies can be made of using the `copy` function.
 *
 * @param [algorithm] [ReservedHeaderParameters.algorithm]
 * @param [jwkSetUrl] [ReservedHeaderParameters.jwkSetUrl]
 * @param [jwk] [ReservedHeaderParameters.jwk]
 * @param [keyId] [ReservedHeaderParameters.keyId]
 * @param [x5u] [ReservedHeaderParameters.x5u]
 * @param [x5c] [ReservedHeaderParameters.x5c]
 * @param [x5t] [ReservedHeaderParameters.x5t]
 * @param [x5tS256] [ReservedHeaderParameters.x5tS256]
 * @param [type] [ReservedHeaderParameters.type]
 * @param [contentType] [ReservedHeaderParameters.contentType]
 * @param [critical] [ReservedHeaderParameters.critical]
 */
@Suppress("FunctionName")
fun Header(
    algorithm: String? = null,
    jwkSetUrl: String? = null,
    jwk: String? = null,
    keyId: String? = null,
    x5u: String? = null,
    x5c: String? = null,
    x5t: String? = null,
    x5tS256: String? = null,
    type: String? = null,
    contentType: String? = null,
    critical: String? = null
): DefaultHeader = DefaultHeader(
    algorithm = algorithm,
    jwkSetUrl = jwkSetUrl,
    jwk = jwk,
    keyId = keyId,
    x5u = x5u,
    x5c = x5c,
    x5t = x5t,
    x5tS256 = x5tS256,
    type = type,
    contentType = contentType,
    critical = critical
)

/**
 * A default implementation of the [Header] interface. This implementation only has the properties defined by the
 * [Header] interface and no extras. To create an instance of this class, use the [Header] constructor function.
 */
@Serializable
data class DefaultHeader internal constructor(
    @SerialName(value = ReservedHeaderParameters.Names.ALGORITHM) override val algorithm: String?,
    @SerialName(value = ReservedHeaderParameters.Names.JWK_SET_URL) override val jwkSetUrl: String?,
    @SerialName(value = ReservedHeaderParameters.Names.JWK) override val jwk: String?,
    @SerialName(value = ReservedHeaderParameters.Names.KEY_ID) override val keyId: String?,
    @SerialName(value = ReservedHeaderParameters.Names.X5U) override val x5u: String?,
    @SerialName(value = ReservedHeaderParameters.Names.X5C) override val x5c: String?,
    @SerialName(value = ReservedHeaderParameters.Names.X5T) override val x5t: String?,
    @SerialName(value = ReservedHeaderParameters.Names.X5T_S256) override val x5tS256: String?,
    @SerialName(value = ReservedHeaderParameters.Names.TYPE) override val type: String?,
    @SerialName(value = ReservedHeaderParameters.Names.CONTENT_TYPE) override val contentType: String?,
    @SerialName(value = ReservedHeaderParameters.Names.CRITICAL) override val critical: String?
) : Header
