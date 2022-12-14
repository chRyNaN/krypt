@file:Suppress("unused")

package com.chrynan.krypt.jwt

actual val defaultJwtSigner: JwtSigner =
    throw UnsupportedOperationException("JWT Signing is not currently supported for iOS.")
