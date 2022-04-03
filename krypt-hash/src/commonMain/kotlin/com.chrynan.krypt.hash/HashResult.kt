package com.chrynan.krypt.hash

import com.chrynan.krypt.core.SecureString

/**
 * Represents the result of a [HashEncoder]. This result interface contains the [hash] and the [algorithm] information.
 */
interface HashResult<Algorithm : HashAlgorithm> {

    val algorithm: Algorithm
    val hash: SecureString
}
