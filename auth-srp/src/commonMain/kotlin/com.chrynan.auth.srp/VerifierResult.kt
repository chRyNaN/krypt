package com.chrynan.auth.srp

import com.chrynan.auth.core.SecureString
import com.ionspin.kotlin.bignum.integer.BigInteger

/**
 * Represents a generated verifier and its associated data used in the SRP protocol.
 *
 * **Note:** This class does not enforce any security, and, when initialized, should be treated securely.
 */
@ExperimentalUnsignedTypes
class VerifierResult(
    val identifier: SecureString,
    val salt: UByteArray,
    val verifier: BigInteger
) {

    override fun equals(other: Any?): Boolean {
        if (other !is VerifierResult) return false

        return identifier == other.identifier && salt == other.salt && verifier == other.verifier
    }

    override fun hashCode(): Int {
        var result = identifier.hashCode()

        result = 31 * result + salt.hashCode()
        result = 31 * result + verifier.hashCode()

        return result
    }

    override fun toString(): String = "VerifierResult(identifier=$identifier,salt=$salt,verifier=$verifier)"
}
