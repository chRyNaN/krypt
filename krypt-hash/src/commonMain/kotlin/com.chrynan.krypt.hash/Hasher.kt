@file:Suppress("unused")

package com.chrynan.krypt.hash

import com.chrynan.krypt.core.HashFunction

/**
 * A utility that provides a function to convert a [ByteArray] to a [Result] object containing the result of an
 * associated [HashFunction] operation and related data, such as data about the algorithm. Different hash algorithm
 * implementations extend this interface and provide a means of obtaining that [Hasher] implementation, typically via
 * extension functions on the companion object.
 */
@Suppress("SpellCheckingInspection")
interface Hasher<Algorithm : HashAlgorithm, Result : HashResult<Algorithm>> {

    val algorithm: Algorithm

    suspend operator fun invoke(source: ByteArray): Result

    companion object
}
