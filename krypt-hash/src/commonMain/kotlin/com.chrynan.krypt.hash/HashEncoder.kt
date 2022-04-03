package com.chrynan.krypt.hash

import com.chrynan.krypt.core.HashFunction

interface HashEncoder<Algorithm : HashAlgorithm, Input : Any, Result : HashResult<Algorithm>> :
    HashFunction<Input, Result> {

    val algorithm: Algorithm
}
