package com.chrynan.krypt.hash

import com.chrynan.krypt.core.HashFunction

/**
 * Represents the result of invoking a [Hasher.invoke] function, which in turn invokes its associated
 * [HashFunction.invoke] function. This result interface contains the [hash] and the [algorithm] information, different
 * hash algorithm implementations may provide additional details relevant to that algorithm.
 */
interface HashResult<Algorithm : HashAlgorithm> {

    val algorithm: Algorithm
    val hash: ByteArray
}
