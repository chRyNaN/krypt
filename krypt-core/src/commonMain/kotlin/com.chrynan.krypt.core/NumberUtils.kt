@file:Suppress("unused")

package com.chrynan.krypt.core

/**
 * Represents the order of a "word" or a numeric value that consists of multiple bytes. In [Little] Endian, the least
 * significant (or last) byte is stored first. In [Big] Endian, the most significant (or first) byte is stored first.
 *
 * Note that technically, the endianness is abstracted away from Kotlin, and each target platform may represent the
 * values using their desired endian order. However, sometimes when working with [ByteArray]s, it is required to
 * convert them to numeric values, such as [Int] or [Long], so, in those scenarios, it is required to specify the order
 * of how the [Byte]s are converted to the numerical value. Though this conversion is different from how the value is
 * internally stored or represented, it will result in different numeric values depending on the order.
 *
 * @see [Wikipedia Explanation](https://en.wikipedia.org/wiki/Endianness)
 */
enum class Endian {

    Big,
    Little
}

/**
 * Converts the specified indices of this [ByteArray] into an [Int] value in the provider [order].
 *
 * Note that [Int]s are 32-bit (4 byte) values. An exception will be thrown if the index range is greater than four
 * or [startInclusive] is greater than or equal to [endExclusive].
 *
 * @param [startInclusive] The first index to use in the conversion process of this [ByteArray] to an [Int]. This
 * defaults to zero.
 * @param [endExclusive] The last, not included, index used in the conversion process of this [ByteArray] to an [Int].
 * This defaults to [ByteArray.size].
 * @param [order] The [Endian] order to use for the conversion process. This defaults to [Endian.Big]. Note that the
 * resulting [Int] value will be different for [Endian.Big] and [Endian.Little] order for the same [ByteArray].
 */
fun ByteArray.toInt(
    startInclusive: Int = 0,
    endExclusive: Int = size,
    order: Endian = Endian.Big
): Int {
    require(endExclusive > startInclusive) { "startInclusive value must be less than endExclusive value." }
    require((endExclusive - startInclusive) < 5) { "Cannot convert more than 4 bytes to an Int, as an Int value is 32-bits (4 bytes)." }
    require(startInclusive in indices) { "startInclusive value must be within the ByteArray indices range." }
    require(endExclusive in 0..size) { "endExclusive value must not be greater than the size of the ByteArray and must not be less than zero." }

    var result = 0

    if (order == Endian.Little) {
        var shift = 0

        for (i in startInclusive until endExclusive) {
            result = result or ((this[i].toInt() and 0xFF) shl shift)
            shift += 8
        }
    } else {
        var shift = 24

        for (i in startInclusive until endExclusive) {
            result = result or ((this[i].toInt() and 0xFF) shl shift)
            shift -= 8
        }
    }

    return result
}

/**
 * Converts the specified indices of this [ByteArray] into a [Long] value in the provider [order].
 *
 * Note that [Long]s are 64-bit (8 byte) values. An exception will be thrown if the index range is greater than eight
 * or [startInclusive] is greater than or equal to [endExclusive].
 *
 * @param [startInclusive] The first index to use in the conversion process of this [ByteArray] to an [Long]. This
 * defaults to zero.
 * @param [endExclusive] The last, not included, index used in the conversion process of this [ByteArray] to an [Long].
 * This defaults to [ByteArray.size].
 * @param [order] The [Endian] order to use for the conversion process. This defaults to [Endian.Big]. Note that the
 * resulting [Long] value will be different for [Endian.Big] and [Endian.Little] order for the same [ByteArray].
 */
fun ByteArray.toLong(
    startInclusive: Int = 0,
    endExclusive: Int = size,
    order: Endian = Endian.Big
): Long {
    require(endExclusive > startInclusive) { "startInclusive value must be less than endExclusive value." }
    require((endExclusive - startInclusive) < 9) { "Cannot convert more than 8 bytes to an Long, as a Long value is 64-bits (8 bytes)." }
    require(startInclusive in indices) { "startInclusive value must be within the ByteArray indices range." }
    require(endExclusive in 0..size) { "endExclusive value must not be greater than the size of the ByteArray and must not be less than zero." }

    var result = 0L

    if (order == Endian.Little) {
        var shift = 0

        for (i in startInclusive until endExclusive) {
            result = result or ((this[i].toLong() and 0xFF) shl shift)
            shift += 8
        }
    } else {
        var shift = 56

        for (i in startInclusive until endExclusive) {
            result = result or ((this[i].toLong() and 0xFF) shl shift)
            shift -= 8
        }
    }

    return result
}

/**
 * Converts this [Int] value into a [ByteArray] representation in the provided [order].
 *
 * Note that [Int]s are 32-bit (4 byte) values. The resulting [ByteArray] will have a [ByteArray.size] of 4.
 *
 * @param [order] The [Endian] order to use for the conversion process. This defaults to [Endian.Big].
 */
fun Int.toByteArray(order: Endian = Endian.Big): ByteArray {
    val length = Int.SIZE_BYTES
    val result = ByteArray(length)
    var value = this

    if (order == Endian.Big) {
        for (i in 0 until length) {
            result[length - i - 1] = (value and 0xFF).toByte()
            value = value shr 8
        }
    } else {
        for (i in 0 until length) {
            result[i] = (value and 0xFF).toByte()
            value = value shr 8
        }
    }

    return result
}

/**
 * Converts this [Long] value into a [ByteArray] representation in the provided [order].
 *
 * Note that [Long]s are 64-bit (8 byte) values. The resulting [ByteArray] will have a [ByteArray.size] of 8.
 *
 * @param [order] The [Endian] order to use for the conversion process. This defaults to [Endian.Big].
 */
fun Long.toByteArray(order: Endian = Endian.Big): ByteArray {
    val length = Long.SIZE_BYTES
    val result = ByteArray(length)
    var value = this

    if (order == Endian.Big) {
        for (i in 0 until length) {
            result[length - i - 1] = (value and 0xFF).toByte()
            value = value ushr 8
        }
    } else {
        for (i in 0 until length) {
            result[i] = (value and 0xFF).toByte()
            value = value ushr 8
        }
    }

    return result
}

/**
 * Converts this [IntArray] into a [ByteArray] by converting each [Int] in this array into a [ByteArray] with the
 * provided [order] and appending the results.
 *
 * @see [Int.toByteArray]
 */
fun IntArray.toByteArray(order: Endian = Endian.Big): ByteArray {
    val bytes = mutableListOf<Byte>()

    for (value in this) {
        value.toByteArray(order = order).forEach {
            bytes.add(it)
        }
    }

    return bytes.toByteArray()
}

/**
 * Converts this [LongArray] into a [ByteArray] by converting each [Long] in this array into a [ByteArray] with the
 * provided [order] and appending the results.
 *
 * @see [Long.toByteArray]
 */
fun LongArray.toByteArray(order: Endian = Endian.Big): ByteArray {
    val bytes = mutableListOf<Byte>()

    for (value in this) {
        value.toByteArray(order = order).forEach {
            bytes.add(it)
        }
    }

    return bytes.toByteArray()
}
