package com.chrynan.auth.hash

interface HashResult<Algorithm : HashAlgorithm> {

    val algorithm: Algorithm
    val hash: SecureString
    val salt: SecureString?
}
