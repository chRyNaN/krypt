//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[Client](index.md)/[verifySession](verify-session.md)

# verifySession

[common]\
fun [verifySession](verify-session.md)(sharedSessionKey: [SessionKey](../-session-key/index.md), hostKeyProof: [UByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-u-byte-array/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Verifies the provided [sharedSessionKey](verify-session.md) and [hostKeyProof](verify-session.md) values.

#### Return

True if the provided [hostKeyProof](verify-session.md) is a match with the provided [sharedSessionKey](verify-session.md), otherwise false. If this function returns false, the provided [sharedSessionKey](verify-session.md) should not be used and considered insecure; authentication has failed. In the case that false is returned, it is up to the user of this library to determine how to proceed.
