package com.chrynan.auth.hash.argon

import com.chrynan.auth.core.SecureString
import com.chrynan.auth.hash.HashResult

data class Argon2HashResult internal constructor(
    override val algorithm: Argon2HashAlgorithm,
    override val hash: SecureString,
    override val salt: SecureString
) : HashResult<Argon2HashAlgorithm>
