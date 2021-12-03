@file:Suppress("unused")

package com.chrynan.auth.hash

interface HashMatcher<Algorithm : HashAlgorithm, Input : Any, Result : HashResult<Algorithm>> {

    val algorithm: Algorithm

    suspend fun matches(source: Input, result: Result): Boolean
}
