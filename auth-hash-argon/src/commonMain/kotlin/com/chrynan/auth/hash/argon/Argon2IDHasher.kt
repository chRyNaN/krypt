package com.chrynan.auth.hash.argon

import com.chrynan.auth.hash.Hasher

interface Argon2IDHasher : Hasher<Argon2IDHashAlgorithm, CharSequence, Argon2IDHashResult>

expect fun argon2IDHasher(
    saltLength: Int = 16,
    hashLength: Int = 32,
    parallelism: Int = 1,
    memory: Int = 1 shl 12,
    iterations: Int = 3
): Argon2IDHasher
