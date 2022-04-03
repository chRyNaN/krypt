package com.chrynan.krypt.hash

import com.chrynan.krypt.core.DerivedKeyResult
import com.chrynan.krypt.core.SecureString

interface HashResult<Algorithm : HashAlgorithm> : DerivedKeyResult {

    val algorithm: Algorithm
    val hash: SecureString
}
