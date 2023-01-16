//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[Client](index.md)

# Client

[common]\
@[ExperimentalUnsignedTypes](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-unsigned-types/index.html)

class [Client](index.md)(group: [Group](../-group/index.md) = Group.N2048, hash: [SrpHashFunction](../-srp-hash-function/index.md), random: [SecureRandom](../../../../krypt-csprng/krypt-csprng/com.chrynan.krypt.csprng/-secure-random/index.md) = SecureRandom(), saltGenerator: suspend () -&gt; [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html) = { random.nextUBytes(16) }, keyPairGenerator: [SrpKeyPairGenerator](../-srp-key-pair-generator/index.md)&lt;BigInteger&gt; = object : SrpKeyPairGenerator&lt;BigInteger&gt; {

        override suspend fun invoke(): SrpKeyPair&lt;BigInteger&gt; {
            val privateKey = random.nextBigInteger()
            val publicKey = calculateA(group = group, a = privateKey)

            return SrpKeyPair(privateKey = privateKey, publicKey = publicKey)
        }
    })

Represents the client in the SRP protocol. The client is the party that initiates authentication and must prove knowledge of the correct password.

There are three parts of the SRP protocol: Registration, Authentication, and Verification. However, the Authentication and Verification parts could be grouped together for simplicity. The client is responsible for initiating both all the parts.

- 
   **Registration** is where a client registers with a host service. The client gives the host service a generated verifier value, which is derived from the hashed password, along with salt and identifier values. The host chooses whether to register the client or not.
- 
   **Authentication** is where an already registered client proves to a host that it is aware of the identifier and password, without having to provide the host the password value. It does this by generating a shared session key derived from the identifier, salt, and password values.
- 
   **Verification** is where the client and host verify that their generated shared session keys are equivalent to the others.

With this process, the host never knows the actual password, but is still able to verify the client has knowledge of the password. This provides a layer of security by avoiding sending a password over a communication channel and preventing accidental leakage of the password value from the host.

Use the [calculateVerifier](calculate-verifier.md) function during the registration process. This generates the salt and verifier which can then be sent to the host. For example:

```kotlin
// Registration:

val result = srpClient.calculateVerifier(identifier = email, secret = password)

api.register(identifier = result.identifier, salt = result.sal, verifier = result.verifier)
```

Use the [generateKeyPair](generate-key-pair.md), [processChallenge](process-challenge.md), and [verifySession](verify-session.md) functions during the authentication and verification processes. For example:

```kotlin
// Authentication:

val keyPair = srpClient.generateKeyPair()

val (salt, hostPublicKey) = api.obtainSaltAndHostPublicKeyFor(identifier = email)

val sessionKey = srpClient.processChallenge(
                     keyPair = keyPair,
                     identifier = email,
                     secret = password,
                     salt = salt,
                     hostPublicKey = hostPublicKey)

// Verification:

val hostProof = api.obtainHostKeyProof(clientKeyProof = sessionKey.clientProof)

val isAuthenticated = srpClient.verifySession(sharedSessionKey = sessionKey, hostKeyProof = hostProof)
```

**Note:** This class is stateless, so it is fine to use it for multiple sessions.

**Note:** The communication between a [Client](index.md) and [Host](../-host/index.md) is outside the responsibility of this library. Typically, this is done via HTTPS. However, this library is agnostic of the communication protocol used. In the above examples, an 'api' property is used to indicate the communication between the [Client](index.md) and [Host](../-host/index.md).

#### See also

common

| |
|---|
| [Host](../-host/index.md) |

## Constructors

| | |
|---|---|
| [Client](-client.md) | [common]<br>fun [Client](-client.md)(group: [Group](../-group/index.md) = Group.N2048, hash: [SrpHashFunction](../-srp-hash-function/index.md), random: [SecureRandom](../../../../krypt-csprng/krypt-csprng/com.chrynan.krypt.csprng/-secure-random/index.md) = SecureRandom(), saltGenerator: suspend () -&gt; [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html) = { random.nextUBytes(16) }, keyPairGenerator: [SrpKeyPairGenerator](../-srp-key-pair-generator/index.md)&lt;BigInteger&gt; = object : SrpKeyPairGenerator&lt;BigInteger&gt; {<br>        override suspend fun invoke(): SrpKeyPair&lt;BigInteger&gt; {             val privateKey = random.nextBigInteger()             val publicKey = calculateA(group = group, a = privateKey)<br>            return SrpKeyPair(privateKey = privateKey, publicKey = publicKey)         }     }) |

## Functions

| Name | Summary |
|---|---|
| [calculateVerifier](calculate-verifier.md) | [common]<br>suspend fun [calculateVerifier](calculate-verifier.md)(identifier: [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), secret: [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md)): [VerifierResult](../-verifier-result/index.md)<br>Creates a salt and verifier to be used in the registration part of the SRP protocol. The returned [VerifierResult](../-verifier-result/index.md) contains the provided [identifier](calculate-verifier.md) value, along with the generated salt and verifier values. These values should then be provided to a host to register with a service. The process to provide these values to a host is outside the responsibility of this library. |
| [generateKeyPair](generate-key-pair.md) | [common]<br>suspend fun [generateKeyPair](generate-key-pair.md)(): [SrpKeyPair](../-srp-key-pair/index.md)&lt;BigInteger&gt;<br>Generates a [SrpKeyPair](../-srp-key-pair/index.md) using the provided [keyPairGenerator](../../../../krypt-srp/com.chrynan.krypt.srp/-client/key-pair-generator.md) when this [Client](index.md) was created. |
| [processChallenge](process-challenge.md) | [common]<br>suspend fun [processChallenge](process-challenge.md)(keyPair: [SrpKeyPair](../-srp-key-pair/index.md)&lt;BigInteger&gt;, identifier: [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), secret: [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), salt: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html), hostPublicKey: BigInteger): [SessionKey](../-session-key/index.md)<br>Generates a [SessionKey](../-session-key/index.md) from the provided values to be used in the authentication part of the SRP protocol. Before invoking this function, the client must obtain the [salt](process-challenge.md) and [hostPublicKey](process-challenge.md) from the host, which is outside the responsibility of this class. Also, a unique [SrpKeyPair](../-srp-key-pair/index.md) value should be generated that is going to be used in this authentication, and the following verification, steps of the SRP protocol. |
| [verifySession](verify-session.md) | [common]<br>fun [verifySession](verify-session.md)(sharedSessionKey: [SessionKey](../-session-key/index.md), hostKeyProof: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Verifies the provided [sharedSessionKey](verify-session.md) and [hostKeyProof](verify-session.md) values. |
