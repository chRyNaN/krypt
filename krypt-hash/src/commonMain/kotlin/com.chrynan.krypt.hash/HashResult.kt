package com.chrynan.krypt.hash

/**
 * Represents the result of a [HashEncoder]. This result interface contains the [hash] and the [algorithm] information.
 */
interface HashResult<Algorithm : HashAlgorithm, Hash> {

    val algorithm: Algorithm
    val hash: Hash
}
