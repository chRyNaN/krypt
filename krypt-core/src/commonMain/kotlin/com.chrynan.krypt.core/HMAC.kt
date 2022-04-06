package com.chrynan.krypt.core

import kotlin.experimental.xor

/**
 * A constant value used in the HMAC algorithm. "I" meaning "inner".
 */
private const val IPAD = 0x36.toByte()

/**
 * A constant value used in the HMAC algorithm. "O" meaning "outer".
 */
private const val OPAD = 0x5C.toByte()

/**
 * A function that can generate a HMAC (Hash-based message authentication code). A message authentication code (MAC) is
 * a value used to verify the data integrity and authenticity of a message (or data). A HMAC is a way of computing a
 * MAC for data using a cryptographic hash function. The returned value is a MAC that can be included with a message to
 * verify its authenticity and to ensure that the message data has not been tampered with.
 *
 * Any cryptographic hash function may be used in the calculation of a HMAC. This function, which represents the
 * calculation of a HMAC, takes a [hash] parameter which is a [HashFunction] with an input and output of [ByteArray].
 *
 * @param [key] The cryptographic key used in the HMAC calculation.
 * @param [message] The message, or data, value that a HMAC is to be generated for.
 * @param [hash] The [HashFunction] used in the HMAC calculation.
 * @param [blockSize] The block size of the [hash] function. This depends on the actual hash function algorithm being
 * used.
 *
 * @see [RFC-2104](https://datatracker.ietf.org/doc/html/rfc2104)
 * @see [Wikipedia Explanation](https://en.wikipedia.org/wiki/HMAC)
 */
@Suppress("unused")
suspend fun hmac(
    key: ByteArray,
    message: ByteArray,
    hash: HashFunction<ByteArray, ByteArray>,
    blockSize: Int
): ByteArray {
    val blockSizedKey = computeBlockSizedKey(key = key, hash = hash, blockSize = blockSize)

    val oKeyPad = xorPad(key = blockSizedKey, size = blockSize, n = OPAD)
    val iKeyPad = xorPad(key = blockSizedKey, size = blockSize, n = IPAD)

    return hash(oKeyPad + hash(iKeyPad + message))
}

/**
 * A convenience function for invoking the [hmac] function with the provided [key] [Key] value.
 *
 * @see [hmac]
 */
@Suppress("unused")
suspend fun hmac(
    key: Key,
    message: ByteArray,
    hash: HashFunction<ByteArray, ByteArray>,
    blockSize: Int
): ByteArray = hmac(
    key = key.encoded ?: ByteArray(blockSize),
    message = message,
    hash = hash,
    blockSize = blockSize
)

/**
 * Creates a [ByteArray] key value that is equal to the provided [blockSize], using the provided [key] and [hash],
 * according to the HMAC specification.
 *
 * @see [RFC-2104 - Section 2](https://datatracker.ietf.org/doc/html/rfc2104#section-2)
 */
private suspend fun computeBlockSizedKey(
    key: ByteArray,
    hash: HashFunction<ByteArray, ByteArray>,
    blockSize: Int
): ByteArray {
    var blockSizedKey = key

    if (blockSizedKey.size > blockSize) {
        blockSizedKey = hash(key)
    }

    if (blockSizedKey.size < blockSize) {
        pad(key = blockSizedKey, size = blockSize)
    }

    return blockSizedKey
}

/**
 * Pads the provided [key] [ByteArray] with zeros at the end until it reaches a length of [size] and returns the
 * result. If the provided [size] is equal to or less than the provided [key] [ByteArray.size], then the provided [key]
 * is simply returned.
 *
 * @see [RFC-2104 - Section 2 - Item 1](https://datatracker.ietf.org/doc/html/rfc2104#section-2)
 */
private fun pad(key: ByteArray, size: Int): ByteArray {
    if (key.size < size) {
        val paddedKey = ByteArray(size)

        for (i in 0 until size) {
            if (i <= key.lastIndex) {
                paddedKey[i] = key[i]
            } else {
                paddedKey[i] = 0
            }
        }

        return paddedKey
    }

    return key
}

/**
 * Iterates through the provided [key], until the provided [size], and performs a bitwise xor operation on the value at
 * the index in the [key] array with the provided value [n]. The operation result for each index of [key] is stored in
 * the same index of a new [ByteArray] and returned from this function as a result.
 *
 * @see [RFC-2104 - Section 2 - Items 2 and 5](https://datatracker.ietf.org/doc/html/rfc2104#section-2)
 */
private fun xorPad(key: ByteArray, size: Int, n: Byte): ByteArray {
    val paddedKey = ByteArray(size)

    for (i in 0 until size) {
        paddedKey[i] = key[i] xor n
    }

    return paddedKey
}
