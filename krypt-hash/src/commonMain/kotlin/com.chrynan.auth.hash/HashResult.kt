package com.chrynan.auth.hash

import com.chrynan.auth.core.DerivedKeyResult
import com.chrynan.auth.core.SecureString

interface HashResult<Algorithm : HashAlgorithm> : DerivedKeyResult {

    val algorithm: Algorithm
    val hash: SecureString
}
