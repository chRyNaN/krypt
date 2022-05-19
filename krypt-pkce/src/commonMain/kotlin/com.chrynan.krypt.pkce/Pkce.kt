package com.chrynan.krypt.pkce

import com.chrynan.krypt.csprng.SecureRandom
import com.chrynan.krypt.encoding.Base64Encoder
import com.chrynan.krypt.encoding.Base64UrlEncoder
import com.chrynan.krypt.hash.Hasher
import com.chrynan.krypt.hash.sha.sha256

class Pkce(
    private val base64Encoder: Base64Encoder = Base64UrlEncoder(isWithPadding = false),
    private val random: SecureRandom = SecureRandom()
) {

    private val sha256Hasher = Hasher.sha256()

    fun generateCodeVerifier(byteLength: Int = 32): String {
        val bytes = random.nextBytes(byteLength)

        return base64Encoder.encodeToString(bytes)
    }

    suspend fun createCodeChallenge(verifier: String, method: CodeChallengeMethod = CodeChallengeMethod.S256): String =
        when (method) {
            CodeChallengeMethod.PLAIN -> verifier
            CodeChallengeMethod.S256 -> {
                val hash = sha256Hasher.invoke(verifier.encodeToByteArray()).hash

                base64Encoder.encodeToString(hash)
            }
        }

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
