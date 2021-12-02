package com.chrynan.auth.hash

interface HashEncoder<Algorithm : HashAlgorithm, Input : Any, Result : HashResult<Algorithm>> {

    val algorithm: Algorithm

    suspend fun hash(source: Input): Result
}
