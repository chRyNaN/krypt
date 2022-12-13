@file:Suppress("unused")

package com.chrynan.krypt.jwt

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

/**
 * Representation of standard JWT signature algorithm names as defined in the
 * [JSON Web Algorithms Specification](https://tools.ietf.org/html/draft-ietf-jose-json-web-algorithms-31).
 *
 * Note that this class was adapted from the open source
 * [JJWT library](https://github.com/jwtk/jjwt/blob/master/api/src/main/java/io/jsonwebtoken/SignatureAlgorithm.java).
 *
 * @param [value] The JWA algorithm name constant.
 * @param [description] The JWA algorithm description.
 * @param [family] The cryptographic family name of the signature algorithm.
 * @param [jcaName] The name of the JCA algorithm used to compute the signature.
 * @param [jdkStandard] Returns `true` if the algorithm is supported by standard JDK distributions or `false` if the
 * algorithm implementation is not in the JDK and must be provided by a separate runtime JCA Provider (like
 * BouncyCastle for example). This is useful for the JVM platform.
 * @param [minKeyLength] Returns the minimum key length in bits (not bytes) that may be used with this algorithm
 * according to the [JWT JWA Specification (RFC 7518)](https://tools.ietf.org/html/rfc7518).
 *
 * @see [JSON Web Algorithms Specification](https://tools.ietf.org/html/draft-ietf-jose-json-web-algorithms-31)
 * @see [jjwt library](https://github.com/jwtk/jjwt/blob/master/api/src/main/java/io/jsonwebtoken/SignatureAlgorithm.java)
 */
@Serializable
enum class SignatureAlgorithm(
    val value: String,
    val description: String,
    val family: Family,
    val jcaName: String?,
    val jdkStandard: Boolean,
    val digestLength: Int,
    val minKeyLength: Int,
    val pkcsName: String? = jcaName
) {

    /**
     * JWA name for {@code No digital signature or MAC performed}
     */
    @SerialName(value = "none")
    NONE(
        value = "none",
        description = "No digital signature or MAC performed",
        family = Family.NONE,
        jcaName = null,
        jdkStandard = false,
        digestLength = 0,
        minKeyLength = 0
    ),

    /**
     * JWA algorithm name for {@code HMAC using SHA-256}
     */
    @SerialName(value = "HS256")
    HS256(
        value = "HS256",
        description = "HMAC using SHA-256",
        family = Family.HMAC,
        jcaName = "HmacSHA256",
        jdkStandard = true,
        digestLength = 256,
        minKeyLength = 256,
        pkcsName = "1.2.840.113549.2.9"
    ),

    /**
     * JWA algorithm name for {@code HMAC using SHA-384}
     */
    @SerialName(value = "HS384")
    HS384(
        value = "HS384",
        description = "HMAC using SHA-384",
        family = Family.HMAC,
        jcaName = "HmacSHA384",
        jdkStandard = true,
        digestLength = 384,
        minKeyLength = 384,
        pkcsName = "1.2.840.113549.2.10"
    ),

    /**
     * JWA algorithm name for {@code HMAC using SHA-512}
     */
    @SerialName(value = "HS512")
    HS512(
        value = "HS512",
        description = "HMAC using SHA-512",
        family = Family.HMAC,
        jcaName = "HmacSHA512",
        jdkStandard = true,
        digestLength = 512,
        minKeyLength = 512,
        pkcsName = "1.2.840.113549.2.11"
    ),

    /**
     * JWA algorithm name for {@code RSASSA-PKCS-v1_5 using SHA-256}
     */
    @SerialName(value = "RS256")
    RS256(
        value = "RS256",
        description = "RSASSA-PKCS-v1_5 using SHA-256",
        family = Family.RSA,
        jcaName = "SHA256withRSA",
        jdkStandard = true,
        digestLength = 256,
        minKeyLength = 2048
    ),

    /**
     * JWA algorithm name for {@code RSASSA-PKCS-v1_5 using SHA-384}
     */
    @SerialName(value = "RS384")
    RS384(
        value = "RS384",
        description = "RSASSA-PKCS-v1_5 using SHA-384",
        family = Family.RSA,
        jcaName = "SHA384withRSA",
        jdkStandard = true,
        digestLength = 384,
        minKeyLength = 2048
    ),

    /**
     * JWA algorithm name for {@code RSASSA-PKCS-v1_5 using SHA-512}
     */
    @SerialName(value = "RS512")
    RS512(
        value = "RS512",
        description = "RSASSA-PKCS-v1_5 using SHA-512",
        family = Family.RSA,
        jcaName = "SHA512withRSA",
        jdkStandard = true,
        digestLength = 512,
        minKeyLength = 2048
    ),

    /**
     * JWA algorithm name for {@code ECDSA using P-256 and SHA-256}
     */
    @SerialName(value = "ES256")
    ES256(
        value = "ES256",
        description = "ECDSA using P-256 and SHA-256",
        family = Family.ECDSA,
        jcaName = "SHA256withECDSA",
        jdkStandard = true,
        digestLength = 256,
        minKeyLength = 256
    ),

    /**
     * JWA algorithm name for {@code ECDSA using P-384 and SHA-384}
     */
    @SerialName(value = "ES384")
    ES384(
        value = "ES384",
        description = "ECDSA using P-384 and SHA-384",
        family = Family.ECDSA,
        jcaName = "SHA384withECDSA",
        jdkStandard = true,
        digestLength = 384,
        minKeyLength = 384
    ),

    /**
     * JWA algorithm name for {@code ECDSA using P-521 and SHA-512}
     */
    @SerialName(value = "ES512")
    ES512(
        value = "ES512",
        description = "ECDSA using P-521 and SHA-512",
        family = Family.ECDSA,
        jcaName = "SHA512withECDSA",
        jdkStandard = true,
        digestLength = 512,
        minKeyLength = 521
    ),

    /**
     * JWA algorithm name for {@code RSASSA-PSS using SHA-256 and MGF1 with SHA-256}.  <b>This algorithm requires
     * Java 11 or later or a JCA provider like BouncyCastle to be in the runtime classpath.</b>  If on Java 10 or
     * earlier, BouncyCastle will be used automatically if found in the runtime classpath.
     */
    @SerialName(value = "PS256")
    PS256(
        value = "PS256",
        description = "RSASSA-PSS using SHA-256 and MGF1 with SHA-256",
        family = Family.RSA,
        jcaName = "RSASSA-PSS",
        jdkStandard = false,
        digestLength = 256,
        minKeyLength = 2048
    ),

    /**
     * JWA algorithm name for {@code RSASSA-PSS using SHA-384 and MGF1 with SHA-384}.  <b>This algorithm requires
     * Java 11 or later or a JCA provider like BouncyCastle to be in the runtime classpath.</b>  If on Java 10 or
     * earlier, BouncyCastle will be used automatically if found in the runtime classpath.
     */
    @SerialName(value = "PS384")
    PS384(
        value = "PS384",
        description = "RSASSA-PSS using SHA-384 and MGF1 with SHA-384",
        family = Family.RSA,
        jcaName = "RSASSA-PSS",
        jdkStandard = false,
        digestLength = 384,
        minKeyLength = 2048
    ),

    /**
     * JWA algorithm name for {@code RSASSA-PSS using SHA-512 and MGF1 with SHA-512}. <b>This algorithm requires
     * Java 11 or later or a JCA provider like BouncyCastle to be in the runtime classpath.</b>  If on Java 10 or
     * earlier, BouncyCastle will be used automatically if found in the runtime classpath.
     */
    @SerialName(value = "PS512")
    PS512(
        value = "PS512",
        description = "RSASSA-PSS using SHA-512 and MGF1 with SHA-512",
        family = Family.RSA,
        jcaName = "RSASSA-PSS",
        jdkStandard = false,
        digestLength = 512,
        minKeyLength = 2048
    );

    companion object {

        /**
         * Retrieves the [SignatureAlgorithm] whose [SignatureAlgorithm.value] property equals the provided [value],
         * optionally ignoring case sensitivity depending on the provided [ignoreCase] value, or `null` if no value was
         * found that matches.
         */
        fun getByName(value: String, ignoreCase: Boolean = true): SignatureAlgorithm? =
            values().firstOrNull { it.value.equals(value, ignoreCase) }
    }

    @Serializable
    enum class Family(val typeName: String) {

        @SerialName(value = "None")
        NONE(typeName = "None"),

        @SerialName(value = "RSA")
        RSA(typeName = "RSA"),

        @SerialName(value = "ECDSA")
        ECDSA(typeName = "ECDSA"),

        @SerialName(value = "HMAC")
        HMAC(typeName = "HMAC");

        companion object {

            /**
             * Retrieves the [SignatureAlgorithm.Family] whose [SignatureAlgorithm.Family.typeName] property equals the
             * provided [value], optionally ingoring case sensitivity depending on the provided [ignoreCase] value, or
             * `null` if no value was found that matches.
             */
            fun getByName(value: String, ignoreCase: Boolean = true): Family? =
                values().firstOrNull { it.typeName.equals(value, ignoreCase) }
        }
    }
}

/**
 * Returns `true` if the enum instance represents an HMAC signature algorithm, `false` otherwise.
 *
 * @return `true` if the enum instance represents an HMAC signature algorithm, `false` otherwise.
 */
fun SignatureAlgorithm.isHmac(): Boolean = family == SignatureAlgorithm.Family.HMAC

/**
 * Returns `true` if the enum instance represents an RSA public/private key pair signature algorithm,
 * `false` otherwise.
 *
 * @return `true` if the enum instance represents an RSA public/private key pair signature algorithm,
 * `false` otherwise.
 */
fun SignatureAlgorithm.isRsa(): Boolean = family == SignatureAlgorithm.Family.RSA

/**
 * Returns `true` if the enum instance represents an Elliptic Curve ECDSA signature algorithm, `false`
 * otherwise.
 *
 * @return `true` if the enum instance represents an Elliptic Curve ECDSA signature algorithm, `false`
 * otherwise.
 */
fun SignatureAlgorithm.isEllipticCurve(): Boolean = family == SignatureAlgorithm.Family.ECDSA
