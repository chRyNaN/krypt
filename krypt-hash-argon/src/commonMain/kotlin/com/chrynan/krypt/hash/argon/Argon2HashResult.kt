package com.chrynan.krypt.hash.argon

import com.chrynan.krypt.core.SecureString
import com.chrynan.krypt.hash.HashResult

data class Argon2HashResult internal constructor(
    override val algorithm: Argon2HashAlgorithm,
    override val hash: SecureString,
    val salt: SecureString
) : HashResult<Argon2HashAlgorithm, SecureString>
