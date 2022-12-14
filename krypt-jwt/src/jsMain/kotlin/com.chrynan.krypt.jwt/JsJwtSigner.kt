@file:Suppress("unused")

package com.chrynan.krypt.jwt

internal actual val defaultJwtSigner: JwtSigner =
    throw UnsupportedOperationException("JWT Signing is not currently supported for Javascript.")
