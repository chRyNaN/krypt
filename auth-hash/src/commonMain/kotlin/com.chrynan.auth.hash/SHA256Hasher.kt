package com.chrynan.auth.hash

import com.chrynan.auth.core.SecureString
import com.chrynan.auth.core.toSecureString

object SHA256HashAlgorithm : HashAlgorithm {

    override val version: String = "256"

    override val name: String = "SHA-256"
}

data class SHA256HashResult internal constructor(
    override val hash: SecureString
) : HashResult<SHA256HashAlgorithm> {

    override val algorithm: SHA256HashAlgorithm = SHA256HashAlgorithm
}

interface SHA256Hasher : Hasher<SHA256HashAlgorithm, SecureString, SHA256HashResult> {

    companion object
}

suspend fun SHA256Hasher.hash(source: CharSequence): SHA256HashResult = hash(source = source.toSecureString())
