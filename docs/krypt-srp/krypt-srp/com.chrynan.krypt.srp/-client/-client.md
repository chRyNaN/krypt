//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[Client](index.md)/[Client](-client.md)

# Client

[common]\
fun [Client](-client.md)(group: [Group](../-group/index.md) = Group.N2048, hash: [SrpHashFunction](../-srp-hash-function/index.md), random: [SecureRandom](../../../../krypt-csprng/krypt-csprng/com.chrynan.krypt.csprng/-secure-random/index.md) = SecureRandom(), saltGenerator: suspend () -&gt; [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html) = { random.nextUBytes(16) }, keyPairGenerator: [SrpKeyPairGenerator](../-srp-key-pair-generator/index.md)&lt;BigInteger&gt; = object : SrpKeyPairGenerator&lt;BigInteger&gt; {

        override suspend fun invoke(): SrpKeyPair&lt;BigInteger&gt; {
            val privateKey = random.nextBigInteger()
            val publicKey = calculateA(group = group, a = privateKey)

            return SrpKeyPair(privateKey = privateKey, publicKey = publicKey)
        }
    })
