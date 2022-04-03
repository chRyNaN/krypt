package com.chrynan.krypt.srp

/**
 * An interface representing a component that can generate a [KeyPair] value.
 */
interface KeyPairGenerator<T : Any> {

    /**
     * Generates a new [KeyPair].
     */
    suspend fun generateKeyPair(): KeyPair<T>
}
