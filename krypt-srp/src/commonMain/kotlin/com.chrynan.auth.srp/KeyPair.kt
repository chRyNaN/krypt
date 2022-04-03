package com.chrynan.auth.srp

import com.chrynan.auth.core.PublicRedactedProperty
import com.chrynan.auth.core.SimpleRedactedProperty
import com.ionspin.kotlin.bignum.integer.BigInteger

/**
 * Represents a simple holder for a pair of keys (public and private).
 *
 * **Note:** This class does not enforce any security, and, when initialized, should be treated securely.
 */
class KeyPair<T : Any>(
    val privateKey: PublicRedactedProperty<T>,
    val publicKey: PublicRedactedProperty<T>
) {

    override fun equals(other: Any?): Boolean {
        if (other !is KeyPair<*>) return false

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
 * Generates a new instance of a [KeyPair] using the provided [BigInteger] values.
 */
@Suppress("FunctionName")
internal fun KeyPair(
    privateKey: BigInteger,
    publicKey: BigInteger
): KeyPair<BigInteger> =
    KeyPair(
        privateKey = SimpleRedactedProperty(privateKey),
        publicKey = SimpleRedactedProperty(publicKey)
    )
