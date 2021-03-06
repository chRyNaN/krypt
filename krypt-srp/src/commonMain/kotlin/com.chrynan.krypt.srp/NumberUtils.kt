package com.chrynan.krypt.srp

import com.chrynan.krypt.csprng.SecureRandom
import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.bignum.integer.Sign
import kotlin.random.nextUBytes

/**
 * Converts this [String] value in UTF-8 encoding to a [UByteArray].
 *
 * @see [UByteArray]
 * @see [String.encodeToByteArray]
 * @see [ByteArray.toUByteArray]
 */
@ExperimentalUnsignedTypes
internal fun String.encodeToUByteArray(): UByteArray = encodeToByteArray().toUByteArray()

/**
 * Converts this [UByteArray] value into a [BigInteger].
 *
 * @see [UByteArray]
 * @see [BigInteger.fromUByteArray]
 */
@ExperimentalUnsignedTypes
internal fun UByteArray.toBigInteger(sign: Sign = Sign.POSITIVE): BigInteger = BigInteger.fromUByteArray(this, sign)

/**
 * Converts the [other] [BigInteger] value into a [UByteArray] and adds it to [this] [UByteArray], returning the result.
 *
 * @see [UByteArray.toBigInteger]
 */
@ExperimentalUnsignedTypes
internal operator fun UByteArray.plus(other: BigInteger): UByteArray = this + other.toUByteArray()

/**
 * Converts [this] [BigInteger] value into a [UByteArray] and adds it to the [other] [UByteArray], returning the result.
 *
 * @see [UByteArray.toBigInteger]
 */
@ExperimentalUnsignedTypes
internal operator fun BigInteger.plus(other: UByteArray): UByteArray = this + other.toUByteArray()

/**
 * Retrieves a random [BigInteger] value based off of a [UByteArray] with the provided [size].
 */
@ExperimentalUnsignedTypes
internal fun SecureRandom.nextBigInteger(size: Int = 16): BigInteger = nextUBytes(size).toBigInteger()

/**
 * Clears the content in this [UByteArray] by setting the value for each index to the provided [value] parameter.
 */
@ExperimentalUnsignedTypes
internal fun UByteArray.clear(value: UByte = 0U) {
    for (i in indices) {
        this[i] = value
    }
}
