package com.chrynan.krypt.srp

import com.chrynan.krypt.core.KeyPair
import com.chrynan.krypt.core.PublicRedactedProperty
import com.ionspin.kotlin.bignum.integer.BigInteger

/**
 * Represents a simple holder for a pair of keys (public and private).
 *
 * **Note:** This class does not enforce any security, and, when initialized, should be treated securely.
 */
class SrpKeyPair<T : Any>(
    override val privateKey: PublicRedactedProperty<T>,
    override val publicKey: PublicRedactedProperty<T>
): KeyPair<PublicRedactedProperty<T>, PublicRedactedProperty<T>> {

    override fun equals(other: Any?): Boolean {
        if (other !is SrpKeyPair<*>) return false

        return privateKey == other.privateKey && publicKey == other.publicKey
    }

    override fun hashCode(): Int {
        var result = privateKey.hashCode()

        result = 31 * result + publicKey.hashCode()

        return result
    }

    override fun toString(): String = "KeyPair(publicKey=$publicKey,privateKey=$privateKey)"
}

/**
 * Generates a new instance of a [SrpKeyPair] using the provided [BigInteger] values.
 */
@Suppress("FunctionName")
internal fun SrpKeyPair(
    privateKey: BigInteger,
    publicKey: BigInteger
): SrpKeyPair<BigInteger> =
    SrpKeyPair(
        privateKey = PublicRedactedProperty(privateKey),
        publicKey = PublicRedactedProperty(publicKey)
    )
