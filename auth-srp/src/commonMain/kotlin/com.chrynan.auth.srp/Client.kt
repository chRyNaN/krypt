@file:Suppress("unused")

package com.chrynan.auth.srp

import com.chrynan.auth.core.SecureString
import com.chrynan.auth.csprng.SecureRandom
import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlin.random.nextUBytes

@OptIn(ExperimentalUnsignedTypes::class)
class Client(
    private val group: Group = Group.N2048,
    private val hash: HashFunction,
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

    suspend fun calculateVerifier(
        identifier: SecureString,
        secret: SecureString
    ): VerifierResult {
        val salt = saltGenerator.invoke()
        val x = calculateX(hash = hash, salt = salt, identifier = identifier, secret = secret)
        val v = calculateV(group = group, x = x)

        return VerifierResult(
            identifier = identifier,
            salt = salt,
            verifier = v
        )
    }

    /**
     *
     * @return M1
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
        val x = calculateX(hash = hash, salt = salt, identifier = identifier, secret = secret)
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

    fun verifySession(sharedSessionKey: SessionKey, hostKeyProof: UByteArray): Boolean =
        hostKeyProof == sharedSessionKey.hostProof
}
