package com.chrynan.krypt.hash.sha

import com.chrynan.krypt.core.SecureString
import com.chrynan.krypt.hash.HashResult

data class SHAHashResult internal constructor(
    override val algorithm: SHAHashAlgorithm,
    override val hash: SecureString
) : HashResult<SHAHashAlgorithm, SecureString>
