package com.chrynan.auth.hash

import com.chrynan.auth.core.SecureString

interface HashResult<Algorithm : HashAlgorithm> {

    val algorithm: Algorithm
    val hash: SecureString
    val salt: SecureString?
}
