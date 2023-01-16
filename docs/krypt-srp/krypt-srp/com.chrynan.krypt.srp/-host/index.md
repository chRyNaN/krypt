//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[Host](index.md)

# Host

[common]\
@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)

class [Host](index.md)(group: [Group](../-group/index.md) = Group.N2048, hash: [SrpHashFunction](../-srp-hash-function/index.md), random: [SecureRandom](../../../../krypt-csprng/krypt-csprng/com.chrynan.krypt.csprng/-secure-random/index.md) = SecureRandom(), keyPairGenerator: [SrpKeyPairGenerator](../-srp-key-pair-generator/index.md)&lt;BigInteger&gt; = object : SrpKeyPairGenerator&lt;BigInteger&gt; {

        override suspend fun invoke(): SrpKeyPair&lt;BigInteger&gt; {
            val privateKey = random.nextBigInteger()
            val publicKey = calculateA(group = group, a = privateKey)

            return SrpKeyPair(privateKey = privateKey, publicKey = publicKey)
        }
    })

Represents the host in the SRP protocol. The host is the party that verifies a session proof from a client and handles authenticating a client.

A [Client](../-client/index.md) will generate a salt and a verifier derived from a password and register that with the [Host](index.md). Then the salt and a newly generated public key from the host will be available to the client upon future request. The registering of the client and storing and providing the salt and key values is outside the responsibility of this class.

When a [Client](../-client/index.md) obtains the salt and public key from the [Host](index.md), it will begin generating a shared session key based off those values and the password. It will then provide a proof of the generated session to the host. The host will then verify the proof of the session key and send its proof back to the client if successful. The client will then verify the hosts proof of the session key. If the proofs were verified, then authentication was successful, and they can use the generated session keys to further encrypt communication.

Example usage:

```kotlin
val keyPair = host.generateKeyPair()

val sessionKey = host.verifySession(
                     keyPair = keyPair,
                     identifier = email,
                     salt = salt,
                     verifier = verifier,
                     clientPublicKey = clientPublicKey,
                     clientKeyProof = clientKeyProof)

sendProofToClient(proof = sessionKey.hostProof)
```

**Note:** This class is stateless, so it is fine to use it for multiple sessions.

**Note:** The communication between a [Client](../-client/index.md) and [Host](index.md) is outside the responsibility of this library. Typically, this is done via HTTPS. However, this library is agnostic of the communication protocol used. In the above examples, an 'api' property is used to indicate the communication between the [Client](../-client/index.md) and [Host](index.md).

#### See also

common

| |
|---|
| [Client](../-client/index.md) |

## Constructors

| | |
|---|---|
| [Host](-host.md) | [common]<br>fun [Host](-host.md)(group: [Group](../-group/index.md) = Group.N2048, hash: [SrpHashFunction](../-srp-hash-function/index.md), random: [SecureRandom](../../../../krypt-csprng/krypt-csprng/com.chrynan.krypt.csprng/-secure-random/index.md) = SecureRandom(), keyPairGenerator: [SrpKeyPairGenerator](../-srp-key-pair-generator/index.md)&lt;BigInteger&gt; = object : SrpKeyPairGenerator&lt;BigInteger&gt; {<br>        override suspend fun invoke(): SrpKeyPair&lt;BigInteger&gt; {             val privateKey = random.nextBigInteger()             val publicKey = calculateA(group = group, a = privateKey)<br>            return SrpKeyPair(privateKey = privateKey, publicKey = publicKey)         }     }) |

## Functions

| Name | Summary |
|---|---|
| [generateKeyPair](generate-key-pair.md) | [common]<br>suspend fun [generateKeyPair](generate-key-pair.md)(): [SrpKeyPair](../-srp-key-pair/index.md)&lt;BigInteger&gt;<br>Generates a [SrpKeyPair](../-srp-key-pair/index.md) using the provided [keyPairGenerator](../../../../krypt-srp/com.chrynan.krypt.srp/-host/key-pair-generator.md) when this [Host](index.md) was created. |
| [verifySession](verify-session.md) | [common]<br>suspend fun [verifySession](verify-session.md)(keyPair: [SrpKeyPair](../-srp-key-pair/index.md)&lt;BigInteger&gt;, identifier: [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), salt: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html), verifier: BigInteger, clientPublicKey: BigInteger, clientKeyProof: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)): [SessionKey](../-session-key/index.md)<br>Verifies the provided [clientKeyProof](verify-session.md) from the [Client](../-client/index.md) using the provided values. If the verification was successful, then a [SessionKey](../-session-key/index.md) will be returned containing the shared session key and its proof values. The [SessionKey.hostProof](../-session-key/host-proof.md) should then be sent to the [Client](../-client/index.md) so that it can verify the [Host](index.md). If all verification is successful, then the [Client](../-client/index.md) can be considered authenticated. |
