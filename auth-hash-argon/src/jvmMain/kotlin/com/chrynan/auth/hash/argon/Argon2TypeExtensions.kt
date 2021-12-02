package com.chrynan.auth.hash.argon

import com.password4j.types.Argon2

fun Argon2Type.toArgon2(): Argon2 =
    when (this) {
        Argon2Type.I -> Argon2.I
        Argon2Type.D -> Argon2.D
        Argon2Type.ID -> Argon2.ID
    }
