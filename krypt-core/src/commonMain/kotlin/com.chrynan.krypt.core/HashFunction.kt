@file:Suppress("unused")

package com.chrynan.krypt.core

/**
 * Represents a cryptographic hash function, or a secure one-way hash function that takes arbitrarily sized input data
 * of type [Input] and outputs a value of type [Output], which contains or is a fixed size hash value
 * ("message-digest") as a result of this function. The result of performing a hash function cannot be reversed,
 * meaning that the input value cannot be obtained by reversing the hash, as a hash function is a one-way function.
 * Different implementations of this interface may represent different hashing algorithms, such as "SHA256" or
 * "Argon2ID". It is common to use a hash function with a password in an authentication flow for a system.
 *
 * @see [Hash Function](https://en.wikipedia.org/wiki/Cryptographic_hash_function)
 * @see [Key Derivation Function](https://en.wikipedia.org/wiki/Key_derivation_function)
 */
interface HashFunction<Input, Output> {

    /**
     * The name of the algorithm this [HashFunction] implements.
     */
    val algorithmName: String?

    /**
     * Performs the hash with the provided [source] value and returns a [Output].
     */
    suspend operator fun invoke(source: Input): Output

    companion object
}

/**
 * A convenience function that delegates to the [invoke] function of the [HashFunction] interface. This is provided for
 * preference, as it may be preferable to use "hash" instead of "invoke" at the call-site.
 */
suspend fun <Input, Output> HashFunction<Input, Output>.hash(source: Input): Output = invoke(source = source)

/**
 * Creates a [HashFunction] implementation using the provided [algorithmName] and [hash] function block.
 */
@Suppress("FunctionName")
fun <Input, Output> HashFunction(
    algorithmName: String? = null,
    hash: suspend (source: Input) -> Output
): HashFunction<Input, Output> =
    object : HashFunction<Input, Output> {

        override val algorithmName: String? = algorithmName

        override suspend fun invoke(source: Input): Output = hash(source)
    }
