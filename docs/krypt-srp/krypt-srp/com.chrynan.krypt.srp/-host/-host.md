//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[Host](index.md)/[Host](-host.md)

# Host

[common]\
fun [Host](-host.md)(group: [Group](../-group/index.md) = Group.N2048, hash: [SrpHashFunction](../-srp-hash-function/index.md), random: [SecureRandom](../../../../krypt-csprng/krypt-csprng/com.chrynan.krypt.csprng/-secure-random/index.md) = SecureRandom(), keyPairGenerator: [KeyPairGenerator](../-key-pair-generator/index.md)&lt;BigInteger&gt; = object : KeyPairGenerator&lt;BigInteger&gt; {

        override suspend fun generateKeyPair(): KeyPair&lt;BigInteger&gt; {
            val privateKey = random.nextBigInteger()
            val publicKey = calculateA(group = group, a = privateKey)

            return KeyPair(privateKey = privateKey, publicKey = publicKey)
        }
    })
