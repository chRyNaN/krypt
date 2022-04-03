package com.chrynan.krypt.hash

import com.chrynan.krypt.core.HashFunction

/**
 * A [HashFunction] that works for the defined [Algorithm], takes in an input of type [Input], and returns a [Result]
 * containing the resulting hash value and its related [Algorithm] information for ease of use.
 */
interface HashEncoder<Algorithm : HashAlgorithm, Input, Hash, Result : HashResult<Algorithm, Hash>> :
    HashFunction<Input, Result> {

    /**
     * The algorithm this [HashEncoder] uses.
     */
    val algorithm: Algorithm
}
