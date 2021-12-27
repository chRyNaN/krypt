package com.chrynan.auth.srp

import com.ionspin.kotlin.bignum.integer.BigInteger

class Host : KeyPairGenerator<BigInteger> {

    override suspend fun generateKeyPair(): KeyPair<BigInteger> {
        TODO("Not yet implemented")
    }
}
