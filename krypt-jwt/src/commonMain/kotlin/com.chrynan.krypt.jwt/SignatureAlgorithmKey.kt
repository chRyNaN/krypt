package com.chrynan.krypt.jwt

import com.chrynan.krypt.core.Key

/**
 * A class wrapping a [Key] and a [SignatureAlgorithm] that the key works with.
 */
data class SignatureAlgorithmKey internal constructor(
    val key: Key,
    val algorithm: SignatureAlgorithm
)
