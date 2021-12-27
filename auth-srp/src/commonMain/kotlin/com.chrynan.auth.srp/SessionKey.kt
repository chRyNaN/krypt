package com.chrynan.auth.srp

import com.chrynan.auth.core.RedactedProperty

/**
 * Represents a generated shared session key and its associated proof data used in the SRP protocol.
 *
 * **Note:** This class does not enforce any security, and, when initialized, should be treated securely.
 */
@ExperimentalUnsignedTypes
class SessionKey(
    private val key: UByteArray,
    val clientProof: UByteArray,
    val hostProof: UByteArray
) : RedactedProperty<UByteArray>() {

    override val value: UByteArray = key

    override fun equals(other: Any?): Boolean {
        if (other !is SessionKey) return false

        return key == other.key && clientProof == other.clientProof && hostProof == other.hostProof
    }

    override fun hashCode(): Int {
        var result = key.hashCode()

        result = 31 * result + clientProof.hashCode()
        result = 31 * result + hostProof.hashCode()

        return result
    }
}
