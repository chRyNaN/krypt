package com.chrynan.auth.hash.sha

import com.chrynan.auth.core.SecureString
import com.chrynan.auth.hash.HashResult

data class SHAHashResult internal constructor(
    override val algorithm: SHAHashAlgorithm,
    override val hash: SecureString
) : HashResult<SHAHashAlgorithm>
