@file:Suppress("unused")

package com.chrynan.auth.hash

import com.chrynan.redacted.core.RedactedProperty

interface HashAlgorithm {

    val name: String
    val version: String

    fun isCompatible(other: HashAlgorithm): Boolean =
        name == other.name && version == other.version
}

interface HashResult<Algorithm : HashAlgorithm> {

    val algorithm: Algorithm
    val hash: RedactedProperty<String>
    val salt: RedactedProperty<String>?
}

interface HashEncoder<Algorithm : HashAlgorithm, Input : Any, Result : HashResult<Algorithm>> {

    val algorithm: Algorithm

    suspend fun hash(source: Input): Result
}

interface HashMatcher<Algorithm : HashAlgorithm, Input : Any> {

    val algorithm: Algorithm

    suspend fun matches(source: Input, hash: String): Boolean
}

@Suppress("SpellCheckingInspection")
interface Hasher<Algorithm : HashAlgorithm, Input : Any, Result : HashResult<Algorithm>> :
    HashEncoder<Algorithm, Input, Result>, HashMatcher<Algorithm, Input> {

    override val algorithm: Algorithm
}
