package com.chrynan.krypt.hash

import com.chrynan.krypt.core.KeyDerivationFunction

interface HashEncoder<Algorithm : HashAlgorithm, Input : Any, Result : HashResult<Algorithm>> :
    KeyDerivationFunction<Input, Result> {

    val algorithm: Algorithm

    suspend fun hash(source: Input): Result

    override suspend fun deriveKey(source: Input): Result = hash(source = source)
}
