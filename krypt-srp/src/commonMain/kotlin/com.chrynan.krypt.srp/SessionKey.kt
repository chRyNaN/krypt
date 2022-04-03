package com.chrynan.krypt.srp

import com.chrynan.krypt.core.RedactedProperty

/**
 * Represents a generated shared session key and its associated proof data used in the SRP protocol.
 *
 * A [SessionKey.value] can be used to further encrypt the communication between a client and host after they have
 * verified each other. However, this functionality is outside the responsibility of this class.
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
