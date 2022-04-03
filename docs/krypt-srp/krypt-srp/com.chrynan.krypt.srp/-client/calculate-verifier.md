//[krypt-srp](../../../index.md)/[com.chrynan.krypt.srp](../index.md)/[Client](index.md)/[calculateVerifier](calculate-verifier.md)

# calculateVerifier

[common]\
suspend fun [calculateVerifier](calculate-verifier.md)(identifier: [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md), secret: [SecureString](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/index.md)): [VerifierResult](../-verifier-result/index.md)

Creates a salt and verifier to be used in the registration part of the SRP protocol. The returned [VerifierResult](../-verifier-result/index.md) contains the provided [identifier](calculate-verifier.md) value, along with the generated salt and verifier values. These values should then be provided to a host to register with a service. The process to provide these values to a host is outside the responsibility of this library.

**Note:** The [secret](calculate-verifier.md) is not provided in the [VerifierResult](../-verifier-result/index.md) because it is no longer needed for the registration process after a verifier value was generated. Also, the [secret](calculate-verifier.md) should never be shared with the host. Proper security mechanisms should be employed to protect the [secret](calculate-verifier.md) value from accidental leakage. For instance, calling [SecureString.clear](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-secure-string/clear.md) after the [secret](calculate-verifier.md) is finished being used. However, this is outside the responsibility of this function.
