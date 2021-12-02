package com.chrynan.auth.hash

interface HashMatcher<Algorithm : HashAlgorithm, Input : Any> {

    val algorithm: Algorithm

    suspend fun matches(source: Input, hash: String): Boolean
}
