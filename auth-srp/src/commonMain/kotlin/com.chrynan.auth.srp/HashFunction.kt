@file:Suppress("unused")

package com.chrynan.auth.srp

/**
 * An interface for a generic hash function used within the SRP protocol. The SRP protocol is agnostic of the hash
 * function implementation as long as the inputs and outputs are of the expected values. The input is expected to be of
 * type [ByteArray] and the output is also expected to be of type [ByteArray].
 */
interface HashFunction {

    /**
     * Performs the hash function on the provided [value] to generate a [ByteArray] value.
     */
    @ExperimentalUnsignedTypes
    suspend operator fun invoke(value: UByteArray): UByteArray
}

/**
 * Converts the provided [value] to a [ByteArray] using UTF-8 encoding and calls the [invoke] function on the result.
 *
 * @see [HashFunction.invoke]
 */
@ExperimentalUnsignedTypes
suspend operator fun HashFunction.invoke(value: String): UByteArray =
    invoke(value = value.encodeToUByteArray())
