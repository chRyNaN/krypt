@file:Suppress("unused")

package com.chrynan.auth.hash

import com.chrynan.auth.core.SecureString

interface HashMatcher<Algorithm : HashAlgorithm, Input : Any> {

    val algorithm: Algorithm

    suspend fun matches(source: Input, salt: SecureString?, hash: SecureString): Boolean
}
