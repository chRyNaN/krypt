@file:Suppress("unused")

package com.chrynan.krypt.core

/**
 * Represents a cryptographic hash function, or a secure one-way hash function that takes arbitrarily sized input data
 * of type [ByteArray] and outputs a value of type [ByteArray], which contains or is a fixed size hash value
 * ("message-digest") as a result of this function. The result of performing a hash function cannot be reversed,
 * meaning that the input value cannot be obtained by reversing the hash, as a hash function is a one-way function.
 * Different implementations of this interface may represent different hashing algorithms, such as "SHA256" or
 * "Argon2ID". It is common to use a hash function with a password in an authentication flow for a system.
 *
 * @see [Hash Function](https://en.wikipedia.org/wiki/Cryptographic_hash_function)
 * @see [Key Derivation Function](https://en.wikipedia.org/wiki/Key_derivation_function)
 */
@Suppress("FUN_INTERFACE_WITH_SUSPEND_FUNCTION")
fun interface HashFunction {

    /**
     * Performs the hash function with the provided [source] value and returns the hashed result.
     */
    suspend operator fun invoke(source: ByteArray): ByteArray

    companion object
}

/**
 * A convenience function that delegates to the [invoke] function of the [HashFunction] interface. This is provided for
 * preference, as it may be preferable to use "hash" instead of "invoke" at the call-site.
 */
suspend fun HashFunction.hash(source: ByteArray): ByteArray = invoke(source = source)
