@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.chrynan.auth.srp

import com.chrynan.auth.core.SecureString
import com.chrynan.auth.csprng.SecureRandom
import com.ionspin.kotlin.bignum.integer.BigInteger

/**
 * Represents the host in the SRP protocol. The host is the party that verifies a session proof from a client and
 * handles authenticating a client.
 *
 * A [Client] will generate a salt and a verifier derived from a password and register that with the [Host]. Then the
 * salt and a newly generated public key from the host will be available to the client upon future request. The
 * registering of the client and storing and providing the salt and key values is outside the responsibility of this
 * class.
 *
 * When a [Client] obtains the salt and public key from the [Host], it will begin generating a shared session key based
 * off those values and the password. It will then provide a proof of the generated session to the host. The host will
 * then verify the proof of the session key and send its proof back to the client if successful. The client will then
 * verify the hosts proof of the session key. If the proofs were verified, then authentication was successful, and they
 * can use the generated session keys to further encrypt communication.
 *
 * Example usage:
 *
 * ```kotlin
 * val keyPair = host.generateKeyPair()
 *
 * val sessionKey = host.verifySession(
 *                      keyPair = keyPair,
 *                      identifier = email,
 *                      salt = salt,
 *                      verifier = verifier,
 *                      clientPublicKey = clientPublicKey,
 *                      clientKeyProof = clientKeyProof)
 *
 * sendProofToClient(proof = sessionKey.hostProof)
 * ```
 *
 * **Note:** This class is stateless, so it is fine to use it for multiple sessions.
 *
 * **Note:** The communication between a [Client] and [Host] is outside the responsibility of this library. Typically,
 * this is done via HTTPS. However, this library is agnostic of the communication protocol used. In the above examples,
 * an 'api' property is used to indicate the communication between the [Client] and [Host].
 *
 * @see [Client]
 */
@ExperimentalUnsignedTypes
class Host(
    private val group: Group = Group.N2048,
    private val hash: HashFunction,
    private val random: SecureRandom = SecureRandom(),
    private val keyPairGenerator: KeyPairGenerator<BigInteger> = object : KeyPairGenerator<BigInteger> {

        override suspend fun generateKeyPair(): KeyPair<BigInteger> {
            val privateKey = random.nextBigInteger()
            val publicKey = calculateA(group = group, a = privateKey)

            return KeyPair(privateKey = privateKey, publicKey = publicKey)
        }
    }
) : KeyPairGenerator<BigInteger> by keyPairGenerator {

    /**
     * Verifies the provided [clientKeyProof] from the [Client] using the provided values. If the verification was
     * successful, then a [SessionKey] will be returned containing the shared session key and its proof values. The
     * [SessionKey.hostProof] should then be sent to the [Client] so that it can verify the [Host]. If all verification
     * is successful, then the [Client] can be considered authenticated.
     *
     * This function will throw an exception if verification fails.
     */
    suspend fun verifySession(
        keyPair: KeyPair<BigInteger>,
        identifier: SecureString,
        salt: UByteArray,
        verifier: BigInteger,
        clientPublicKey: BigInteger,
        clientKeyProof: UByteArray
    ): SessionKey {
        require(clientPublicKey % group.N != BigInteger.ZERO) { "The client public key modulo group.N must not be zero." }

        val u = calculateU(hash = hash, group = group, A = keyPair.publicKey.value, B = clientPublicKey)
        val s = calculateS2(group = group, A = clientPublicKey, v = verifier, u = u, b = keyPair.privateKey.value)
        val sharedKey = calculateSharedSessionKey(hash = hash, S = s)

        val clientProof = calculateM1(
            hash = hash,
            group = group,
            identifier = identifier,
            salt = salt,
            A = clientPublicKey,
            B = keyPair.publicKey.value,
            K = sharedKey.toBigInteger()
        )

        require(clientProof == clientKeyProof) { "The client session key proof generated on the host does not match the one provided by the client. They must match to proceed." }

        val hostProof =
            calculateM2(hash = hash, A = clientPublicKey, M1 = clientProof, K = sharedKey.toBigInteger())

        return SessionKey(
            key = sharedKey,
            clientProof = clientProof,
            hostProof = hostProof
        )
    }
}
