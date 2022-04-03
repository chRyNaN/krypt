@file:Suppress("unused")

package com.chrynan.krypt.srp

import com.chrynan.krypt.core.SecureString
import com.ionspin.kotlin.bignum.integer.BigInteger

/**
 * An interface for a generic hash function used within the SRP protocol. The SRP protocol is agnostic of the hash
 * function implementation as long as the inputs and outputs are of the expected values. The input is expected to be of
 * type [UByteArray] and the output is also expected to be of type [UByteArray].
 */
interface HashFunction {

    /**
     * Performs the hash function on the provided [value] to generate a [UByteArray] value.
     */
    @ExperimentalUnsignedTypes
    suspend operator fun invoke(value: UByteArray): UByteArray
}

/**
 * Converts the provided [value] to a [UByteArray] using UTF-8 encoding and calls the [invoke] function on the result.
 *
 * @see [HashFunction.invoke]
 */
@ExperimentalUnsignedTypes
suspend operator fun HashFunction.invoke(value: CharSequence): UByteArray =
    invoke(value = (if (value is SecureString) value.toInsecureString() else value.toString()).encodeToUByteArray())

/**
 * Converts the provided [value] to a [UByteArray] using UTF-8 encoding and calls the [invoke] function on the result.
 *
 * @see [HashFunction.invoke]
 */
@ExperimentalUnsignedTypes
suspend operator fun HashFunction.invoke(value: BigInteger): UByteArray =
    invoke(value = value.toUByteArray())
