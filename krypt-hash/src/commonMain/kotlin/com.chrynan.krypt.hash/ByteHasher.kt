package com.chrynan.krypt.hash

import com.chrynan.krypt.core.hash

/**
 * A specialized and commonly used [Hasher] that operates on an input type of [ByteArray] and outputs a [ByteArray] in
 * the result.
 */
interface ByteHasher<Algorithm : HashAlgorithm, Result : HashResult<Algorithm, ByteArray>> :
    Hasher<Algorithm, ByteArray, ByteArray, Result> {

    companion object
}

/**
 * A convenience function that calls the [ByteHasher.invoke] function with the provided [source] [String] value encoded
 * to a [ByteArray] using the [encodeToByteArray] function. This encodes the provided [source] [String] as a UTF-8
 * [ByteArray].
 */
suspend fun <Algorithm : HashAlgorithm, Result : HashResult<Algorithm, ByteArray>> ByteHasher<Algorithm, Result>.invoke(
    source: String
): Result = invoke(source = source.encodeToByteArray())

/**
 * A convenience function that calls the [ByteHasher.hash] function with the provided [source] [String] value encoded
 * to a [ByteArray] using the [encodeToByteArray] function. This encodes the provided [source] [String] as a UTF-8
 * [ByteArray].
 */
suspend fun <Algorithm : HashAlgorithm, Result : HashResult<Algorithm, ByteArray>> ByteHasher<Algorithm, Result>.hash(
    source: String
): Result = hash(source = source.encodeToByteArray())
