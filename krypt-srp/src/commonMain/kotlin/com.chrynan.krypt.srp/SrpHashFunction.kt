@file:Suppress("unused")

package com.chrynan.krypt.srp

import com.chrynan.krypt.core.HashFunction
import com.chrynan.krypt.core.SecureString
import com.ionspin.kotlin.bignum.integer.BigInteger

/**
 * An interface for a generic hash function used within the SRP protocol. The SRP protocol is agnostic of the hash
 * function implementation as long as the inputs and outputs are of the expected values. The input and output is
 * expected to be of type [UByteArray].
 */
@ExperimentalUnsignedTypes
interface SrpHashFunction : HashFunction<UByteArray, UByteArray> {

    /**
     * Performs the hash function on the provided [source] to generate a [UByteArray] value.
     */
    override suspend operator fun invoke(source: UByteArray): UByteArray
}

/**
 * Converts the provided [source] to a [UByteArray] using UTF-8 encoding and calls the [invoke] function on the result.
 *
 * @see [SrpHashFunction.invoke]
 */
@ExperimentalUnsignedTypes
suspend operator fun SrpHashFunction.invoke(source: CharSequence): UByteArray =
    invoke(source = (if (source is SecureString) source.toInsecureString() else source.toString()).encodeToUByteArray())

/**
 * Converts the provided [source] to a [UByteArray] using the [BigInteger.toUByteArray] function and calls the [invoke]
 * function on the result.
 *
 * @see [SrpHashFunction.invoke]
 */
@ExperimentalUnsignedTypes
suspend operator fun SrpHashFunction.invoke(source: BigInteger): UByteArray =
    invoke(source = source.toUByteArray())
