@file:Suppress("unused")

package com.chrynan.krypt.hash

/**
 * A utility that is both a [HashEncoder] and a [HashMatcher]. Different hash algorithm implementations extend this
 * interface and provide a means of obtaining that [Hasher] implementation, typically via extension functions on the
 * companion object.
 */
@Suppress("SpellCheckingInspection")
interface Hasher<Algorithm : HashAlgorithm, Input : Any, Result : HashResult<Algorithm>> :
    HashEncoder<Algorithm, Input, Result>,
    HashMatcher<Algorithm, Input, Result> {

    override val algorithm: Algorithm

    companion object
}
