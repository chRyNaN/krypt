@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.chrynan.krypt.srp

import com.chrynan.krypt.core.SecureString
import com.chrynan.krypt.csprng.SecureRandom
import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlin.random.nextUBytes

/**
 * Represents the client in the SRP protocol. The client is the party that initiates authentication and must prove
 * knowledge of the correct password.
 *
 * There are three parts of the SRP protocol: Registration, Authentication, and Verification. However, the
 * Authentication and Verification parts could be grouped together for simplicity. The client is responsible for
 * initiating both all the parts.
 *
 * - **Registration** is where a client registers with a host service. The client gives the host service a
 * generated verifier value, which is derived from the hashed password, along with salt and identifier values. The host
 * chooses whether to register the client or not.
 * - **Authentication** is where an already registered client proves to a host that it is aware of the identifier and
 * password, without having to provide the host the password value. It does this by generating a shared session key
 * derived from the identifier, salt, and password values.
 * - **Verification** is where the client and host verify that their generated shared session keys are equivalent to
 * the others.
 *
 * With this process, the host never knows the actual password, but is still able to verify the client has knowledge of
 * the password. This provides a layer of security by avoiding sending a password over a communication channel and
 * preventing accidental leakage of the password value from the host.
 *
 * Use the [calculateVerifier] function during the registration process. This generates the salt and verifier which can
 * then be sent to the host. For example:
 *
 * ```kotlin
 * // Registration:
 *
 * val result = srpClient.calculateVerifier(identifier = email, secret = password)
 *
 * api.register(identifier = result.identifier, salt = result.sal, verifier = result.verifier)
 * ```
 *
 * Use the [generateKeyPair], [processChallenge], and [verifySession] functions during the authentication and
 * verification processes. For example:
 *
 * ```kotlin
 * // Authentication:
 *
 * val keyPair = srpClient.generateKeyPair()
 *
 * val (salt, hostPublicKey) = api.obtainSaltAndHostPublicKeyFor(identifier = email)
 *
 * val sessionKey = srpClient.processChallenge(
 *                      keyPair = keyPair,
 *                      identifier = email,
 *                      secret = password,
 *                      salt = salt,
 *                      hostPublicKey = hostPublicKey)
 *
 * // Verification:
 *
 * val hostProof = api.obtainHostKeyProof(clientKeyProof = sessionKey.clientProof)
 *
 * val isAuthenticated = srpClient.verifySession(sharedSessionKey = sessionKey, hostKeyProof = hostProof)
 * ```
 *
 * **Note:** This class is stateless, so it is fine to use it for multiple sessions.
 *
 * **Note:** The communication between a [Client] and [Host] is outside the responsibility of this library. Typically,
 * this is done via HTTPS. However, this library is agnostic of the communication protocol used. In the above examples,
 * an 'api' property is used to indicate the communication between the [Client] and [Host].
 *
 * @see [Host]
 */
@ExperimentalUnsignedTypes
class Client(
    private val group: Group = Group.N2048,
    private val hash: SrpHashFunction,
    private val random: SecureRandom = SecureRandom(),
    private val saltGenerator: suspend () -> UByteArray = { random.nextUBytes(16) },
    private val keyPairGenerator: KeyPairGenerator<BigInteger> = object : KeyPairGenerator<BigInteger> {

        override suspend fun generateKeyPair(): KeyPair<BigInteger> {
            val privateKey = random.nextBigInteger()
            val publicKey = calculateA(group = group, a = privateKey)

            return KeyPair(privateKey = privateKey, publicKey = publicKey)
        }
    }
) : KeyPairGenerator<BigInteger> by keyPairGenerator {

    /**
     * Creates a salt and verifier to be used in the registration part of the SRP protocol. The returned
     * [VerifierResult] contains the provided [identifier] value, along with the generated salt and verifier values.
     * These values should then be provided to a host to register with a service. The process to provide these values
     * to a host is outside the responsibility of this library.
     *
     * **Note:** The [secret] is not provided in the [VerifierResult] because it is no longer needed for the
     * registration process after a verifier value was generated. Also, the [secret] should never be shared with the
     * host. Proper security mechanisms should be employed to protect the [secret] value from accidental leakage. For
     * instance, calling [SecureString.clear] after the [secret] is finished being used. However, this is outside the
     * responsibility of this function.
     */
    suspend fun calculateVerifier(
        identifier: SecureString,
        secret: SecureString
    ): VerifierResult {
        val salt = saltGenerator.invoke()
        val x = calculateX(hash = hash, salt = salt, identifier = identifier.toInsecureString(), secret = secret.toInsecureString())
        val v = calculateV(group = group, x = x)

        return VerifierResult(
            identifier = identifier,
            salt = salt,
            verifier = v
        )
    }

    /**
     * Generates a [SessionKey] from the provided values to be used in the authentication part of the SRP protocol.
     * Before invoking this function, the client must obtain the [salt] and [hostPublicKey] from the host, which is
     * outside the responsibility of this class. Also, a unique [KeyPair] value should be generated that is going to be
     * used in this authentication, and the following verification, steps of the SRP protocol.
     *
     * This function returns a [SessionKey] which must be verified before being used. In order to do so, the
     * [SessionKey.clientProof] should be sent to the host to obtain their proof of the session key. Then the
     * [verifySession] function should be invoked with the [SessionKey] returned from this function and the obtained
     * host session key proof value.
     *
     * **Note:** The [secret] should never be shared with the host and proper security mechanisms should be employed to
     * protect the [secret] value from accidental leakage. For instance, calling [SecureString.clear] after the
     * [secret] is finished being used. However, this is outside the responsibility of this function.
     */
    suspend fun processChallenge(
        keyPair: KeyPair<BigInteger>,
        identifier: SecureString,
        secret: SecureString,
        salt: UByteArray,
        hostPublicKey: BigInteger
    ): SessionKey {
        require(hostPublicKey % group.N != BigInteger.ZERO) { "The host public key modulo group.N must not be zero." }

        val u = calculateU(hash = hash, group = group, A = keyPair.publicKey.value, B = hostPublicKey)

        require(u != BigInteger.ZERO) { "The 'u' value must not be zero." }

        val k = calculateK(hash = hash, group = group)
        val x = calculateX(hash = hash, salt = salt, identifier = identifier.toInsecureString(), secret = secret.toInsecureString())
        val v = calculateV(group = group, x = x)
        val s = calculateS1(group = group, k = k, v = v, x = x, u = u, a = keyPair.privateKey.value, B = hostPublicKey)
        val sharedKey = calculateSharedSessionKey(hash = hash, S = s)

        val clientProof = calculateM1(
            hash = hash,
            group = group,
            identifier = identifier,
            salt = salt,
            A = keyPair.publicKey.value,
            B = hostPublicKey,
            K = sharedKey.toBigInteger()
        )

        val hostProof =
            calculateM2(hash = hash, A = keyPair.publicKey.value, M1 = clientProof, K = sharedKey.toBigInteger())

        return SessionKey(
            key = sharedKey,
            clientProof = clientProof,
            hostProof = hostProof
        )
    }

    /**
     * Verifies the provided [sharedSessionKey] and [hostKeyProof] values.
     *
     * @return True if the provided [hostKeyProof] is a match with the provided [sharedSessionKey], otherwise false. If
     * this function returns false, the provided [sharedSessionKey] should not be used and considered insecure;
     * authentication has failed. In the case that false is returned, it is up to the user of this library to determine
     * how to proceed.
     */
    fun verifySession(sharedSessionKey: SessionKey, hostKeyProof: UByteArray): Boolean =
        hostKeyProof == sharedSessionKey.hostProof
}
