@file:Suppress("unused")

package com.chrynan.krypt.hash

/**
 * A utility to determine whether an [Input] matches a [Result]. This utility will perform the hash function with a
 * provided [Input] and compare that result with the provided [Result] to determine if the values match.
 */
interface HashMatcher<Algorithm : HashAlgorithm, Input : Any, Result : HashResult<Algorithm>> {

    /**
     * The algorithm this [HashMatcher] uses.
     */
    val algorithm: Algorithm

    /**
     * Performs the hash function on the provided [source] to obtain its result and compares it with the provided
     * [result] to determine if the values match.
     */
    suspend fun matches(source: Input, result: Result): Boolean
}
