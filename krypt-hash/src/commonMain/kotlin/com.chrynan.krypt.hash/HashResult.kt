package com.chrynan.krypt.hash

import com.chrynan.krypt.core.SecureString

interface HashResult<Algorithm : HashAlgorithm> {

    val algorithm: Algorithm
    val hash: SecureString
}
