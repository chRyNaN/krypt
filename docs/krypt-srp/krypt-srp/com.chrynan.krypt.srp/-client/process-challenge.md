//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[Client](index.md)/[processChallenge](process-challenge.md)

# processChallenge

[common]\
suspend fun [processChallenge](process-challenge.md)(keyPair: [SrpKeyPair](../-srp-key-pair/index.md)&lt;BigInteger&gt;, identifier: [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), secret: [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), salt: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html), hostPublicKey: BigInteger): [SessionKey](../-session-key/index.md)

Generates a [SessionKey](../-session-key/index.md) from the provided values to be used in the authentication part of the SRP protocol. Before invoking this function, the client must obtain the [salt](process-challenge.md) and [hostPublicKey](process-challenge.md) from the host, which is outside the responsibility of this class. Also, a unique [SrpKeyPair](../-srp-key-pair/index.md) value should be generated that is going to be used in this authentication, and the following verification, steps of the SRP protocol.

This function returns a [SessionKey](../-session-key/index.md) which must be verified before being used. In order to do so, the [SessionKey.clientProof](../-session-key/client-proof.md) should be sent to the host to obtain their proof of the session key. Then the [verifySession](verify-session.md) function should be invoked with the [SessionKey](../-session-key/index.md) returned from this function and the obtained host session key proof value.

**Note:** The [secret](process-challenge.md) should never be shared with the host and proper security mechanisms should be employed to protect the [secret](process-challenge.md) value from accidental leakage. For instance, calling [SecureString.clear](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/clear.md) after the [secret](process-challenge.md) is finished being used. However, this is outside the responsibility of this function.
