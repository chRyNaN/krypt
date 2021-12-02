package com.chrynan.auth.hash.argon

import com.chrynan.auth.core.SecureString
import com.chrynan.auth.hash.Hasher

interface Argon2Hasher : Hasher<Argon2HashAlgorithm, SecureString, Argon2HashResult>

expect fun argon2Hasher(
    type: Argon2Type = Argon2Type.ID,
    saltLength: Int = 16,
    hashLength: Int = 32,
    parallelism: Int = 1,
    memory: Int = 1 shl 12,
    iterations: Int = 3
): Argon2Hasher
