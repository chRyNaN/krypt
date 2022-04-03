# SRP

The secure remote password protocol (SRP) is an approach to authenticating a client to a host service without
exchanging, or even the host knowing, the password of a user. For more information about SRP, refer to
the [Wikipedia SRP Article](https://en.wikipedia.org/wiki/Secure_Remote_Password_protocol).

This library implements the SRP protocol allowing for easy integration of the SRP protocol into an application. The two
main components are the `Client` and the `Host`. There are three main parts of the SRP protocol: Registration,
Authentication, Verification.

**Note:** The communication channels between the `Client` and the `Host` are outside the responsibility of this library.

## Registration

```kotlin
val result = srpClient.calculateVerifier(identifier = email, secret = password)

// Provide the verifier to the Host (outside the scope of this library)
api.register(identifier = result.identifier, salt = result.sal, verifier = result.verifier)
```

## Authentication

```kotlin
val keyPair = srpClient.generateKeyPair()

// Obtain the salt and Host public key for the identifier (outside the scope of this library)
val (salt, hostPublicKey) = api.obtainSaltAndHostPublicKeyFor(identifier = email)

val sessionKey = srpClient.processChallenge(
    keyPair = keyPair,
    identifier = email,
    secret = password,
    salt = salt,
    hostPublicKey = hostPublicKey
)

// Send the session key proof to the Host (outside the scope of this library)
api.sendProofToHost(proof = sessionKey.clientProof)
```

## Verification

```kotlin
// Host:
val keyPair = host.generateKeyPair()
val sessionKey = host.verifySession(
    keyPair = keyPair,
    identifier = email,
    salt = salt,
    verifier = verifier,
    clientPublicKey = clientPublicKey,
    clientKeyProof = clientKeyProof
)
// After the proof is verified by the Host, send the Host proof to the Client (outside the scope of this library)
sendProofToClient(proof = sessionKey.hostProof)

// Client:
val isAuthenticated = srpClient.verifySession(sharedSessionKey = sessionKey, hostKeyProof = hostProof)
```
