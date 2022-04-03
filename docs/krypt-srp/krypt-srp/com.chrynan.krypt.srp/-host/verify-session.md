//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[Host](index.md)/[verifySession](verify-session.md)

# verifySession

[common]\
suspend fun [verifySession](verify-session.md)(keyPair: [KeyPair](../-key-pair/index.md)&lt;BigInteger&gt;, identifier: [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), salt: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html), verifier: BigInteger, clientPublicKey: BigInteger, clientKeyProof: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)): [SessionKey](../-session-key/index.md)

Verifies the provided [clientKeyProof](verify-session.md) from the [Client](../-client/index.md) using the provided values. If the verification was successful, then a [SessionKey](../-session-key/index.md) will be returned containing the shared session key and its proof values. The [SessionKey.hostProof](../-session-key/host-proof.md) should then be sent to the [Client](../-client/index.md) so that it can verify the [Host](index.md). If all verification is successful, then the [Client](../-client/index.md) can be considered authenticated.

This function will throw an exception if verification fails.
