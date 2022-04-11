package com.chrynan.krypt.hash

/**
 * A specialized and commonly used [Hasher] that operates on an input type of [ByteArray] and outputs a [ByteArray] in
 * the result.
 */
interface ByteHasher<Algorithm : HashAlgorithm, Result : HashResult<Algorithm, ByteArray>> :
    Hasher<Algorithm, ByteArray, ByteArray, Result> {

    companion object
}
