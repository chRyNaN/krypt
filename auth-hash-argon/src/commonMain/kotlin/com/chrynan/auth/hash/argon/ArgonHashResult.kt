package com.chrynan.auth.hash.argon

import com.chrynan.auth.hash.HashResult
import com.chrynan.redacted.core.RedactedProperty

data class ArgonHashResult internal constructor(
    override val algorithm: Argon2IDHashAlgorithm,
    override val hash: RedactedProperty<String>,
    override val salt: RedactedProperty<String>?
) : HashResult<Argon2IDHashAlgorithm>
