package com.chrynan.auth.srp

/**
 * Converts this [String] value in UTF-8 encoding to a [UByteArray].
 *
 * @see [UByteArray]
 * @see [String.encodeToByteArray]
 * @see [ByteArray.toUByteArray]
 */
@ExperimentalUnsignedTypes
fun String.encodeToUByteArray(): UByteArray = encodeToByteArray().toUByteArray()
