package com.chrynan.auth.srp

import com.chrynan.auth.core.SecureString
import com.chrynan.auth.csprng.SecureRandom
import com.ionspin.kotlin.bignum.integer.BigInteger

@OptIn(ExperimentalUnsignedTypes::class)
class Client(
    private val group: Group = Group.N2048,
    private val hash: HashFunction,
    private val random: SecureRandom = SecureRandom()
) {

    private lateinit var privateKey: BigInteger
    private lateinit var publicKey: BigInteger

    private var m2: UByteArray? = null

    suspend fun start(): BigInteger {
        privateKey = random.nextBigInteger()
        publicKey = calculateA(group = group, a = privateKey)

        return publicKey
    }

    /**
     *
     * @return M1
     */
    suspend fun process(
        identifier: SecureString,
        secret: SecureString,
        salt: UByteArray,
        hostPublicKey: BigInteger
    ): UByteArray {
        require(hostPublicKey % group.N != BigInteger.ZERO) { "" } // TODO update message and possibly throw custom error

        val u = calculateU(hash = hash, group = group, A = publicKey, B = hostPublicKey)

        require(u != BigInteger.ZERO) { "" } // TODO update message

        val k = calculateK(hash = hash, group = group)
        val x = calculateX(hash = hash, salt = salt, identifier = identifier, secret = secret)
        val v = calculateV(group = group, x = x)
        val s = calculateS1(group = group, k = k, v = v, x = x, u = u, a = privateKey, B = hostPublicKey)
        val sharedKey = calculateSharedSessionKey(hash = hash, S = s)

        val m1 = calculateM1(
            hash = hash,
            group = group,
            identifier = identifier,
            salt = salt,
            A = publicKey,
            B = hostPublicKey,
            K = sharedKey.toBigInteger()
        )

        m2 = calculateM2(hash = hash, A = publicKey, M1 = m1, K = sharedKey.toBigInteger())

        return m1
    }

    suspend fun verify(keyProof: UByteArray): Boolean {
        require(m2 != null) { "" } // TODO update message

        return keyProof == m2
    }
}
