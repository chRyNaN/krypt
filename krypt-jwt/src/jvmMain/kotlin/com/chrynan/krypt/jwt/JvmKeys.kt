@file:Suppress("unused")

package com.chrynan.krypt.jwt

import com.chrynan.krypt.core.Key
import com.chrynan.krypt.core.KeyPair
import com.chrynan.krypt.core.toMultiplatformKey
import com.chrynan.krypt.core.toMultiplatformKeyPair

actual fun Keys.generateHmacKeyFrom(bytes: ByteArray): Key =
    io.jsonwebtoken.security.Keys.hmacShaKeyFor(bytes).toMultiplatformKey()

actual fun Keys.generateSecretKeyFor(algorithm: SignatureAlgorithm): Key =
    io.jsonwebtoken.security.Keys.secretKeyFor(algorithm.toJvmSignatureAlgorithm()).toMultiplatformKey()

actual fun Keys.generateKeyPairFor(algorithm: SignatureAlgorithm): KeyPair<Key, Key> =
    io.jsonwebtoken.security.Keys.keyPairFor(algorithm.toJvmSignatureAlgorithm()).toMultiplatformKeyPair()
