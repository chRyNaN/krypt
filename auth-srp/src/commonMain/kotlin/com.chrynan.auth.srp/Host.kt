package com.chrynan.auth.srp

import com.chrynan.auth.csprng.SecureRandom
import com.ionspin.kotlin.bignum.integer.BigInteger

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
) : KeyPairGenerator<BigInteger> {

    override suspend fun generateKeyPair(): KeyPair<BigInteger> {
        TODO("Not yet implemented")
    }
}
