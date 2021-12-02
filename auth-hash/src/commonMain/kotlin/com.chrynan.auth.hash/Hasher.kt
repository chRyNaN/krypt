@file:Suppress("unused")

package com.chrynan.auth.hash

@Suppress("SpellCheckingInspection")
interface Hasher<Algorithm : HashAlgorithm, Input : Any, Result : HashResult<Algorithm>> :
    HashEncoder<Algorithm, Input, Result>,
    HashMatcher<Algorithm, Input> {

    override val algorithm: Algorithm

    companion object
}
