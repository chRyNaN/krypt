@file:Suppress("unused")

package com.chrynan.krypt.pkce

import com.chrynan.krypt.csprng.SecureRandom
import com.chrynan.krypt.encoding.Base64Encoder
import com.chrynan.krypt.encoding.Base64UrlEncoder
import com.chrynan.krypt.hash.Hasher
import com.chrynan.krypt.hash.sha.sha256

/**
 * A class implementing the Proof Key for Code Exchange (PKCE, pronounced "pixy"),
 * [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636), protocol. This class contains functions that can be used
 * to perform the protocol. However, note that the communication of the values between the parties involved is not
 * handled by this class and must be handled out-of-band.
 *
 * @property [base64Encoder] The [Base64Encoder] utility used in the protocol to encode values to a Base64 URL encoded
 * [String]s.
 * @property [random] The [SecureRandom] utility used to generate the code verifier for the protocol.
 *
 * @see [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636)
 */
@Suppress("SpellCheckingInspection")
class Pkce(
    private val base64Encoder: Base64Encoder = Base64UrlEncoder(isWithPadding = false),
    private val random: SecureRandom = SecureRandom()
) {

    private val sha256Hasher = Hasher.sha256()

    /**
     * Generates a "code_verifier" specified in the PKCE protocol. This value is considered a secure key.
     *
     * @see [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636#section-4.1)
     */
    fun generateCodeVerifier(byteLength: Int = 32): String {
        val bytes = random.nextBytes(byteLength)

        return base64Encoder.encodeToString(bytes)
    }

    /**
     * Creates a "code_challenge", specified in the PKCE protocol, from the provided [verifier], using the provided
     * transformation [method]. If the provided [method] is [CodeChallengeMethod.PLAIN], then the [verifier] is simply
     * returned, otherwise, if the provided [method] is [CodeChallengeMethod.S256], an SHA-256 hash opertaion is
     * performed and the result is returned.
     *
     * @see [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636#section-4.2)
     */
    @Suppress("MemberVisibilityCanBePrivate")
    suspend fun createCodeChallenge(verifier: String, method: CodeChallengeMethod = CodeChallengeMethod.S256): String =
        when (method) {
            CodeChallengeMethod.PLAIN -> verifier
            CodeChallengeMethod.S256 -> {
                val hash = sha256Hasher.invoke(verifier.encodeToByteArray()).hash

                base64Encoder.encodeToString(hash)
            }
        }

    /**
     * Verifies that the provided [verifier] equals the provied [challenge] after it is transformed using the provided
     * [method]. Returns `true` if the values are equal, `false` otherwise.
     *
     * @see [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636#section-4.6)
     */
    suspend fun isValid(
        verifier: String,
        challenge: String,
        method: CodeChallengeMethod = CodeChallengeMethod.S256
    ): Boolean =
        when (method) {
            CodeChallengeMethod.PLAIN -> verifier == challenge
            CodeChallengeMethod.S256 -> createCodeChallenge(verifier = verifier, method = method) == challenge
        }
}
