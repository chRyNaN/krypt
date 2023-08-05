package com.chrynan.krypt.jwt

import com.chrynan.krypt.core.Key
import com.chrynan.krypt.core.KeyPair

actual fun Keys.generateHmacKeyFrom(bytes: ByteArray): Key = TODO()

actual fun Keys.generateSecretKeyFor(algorithm: SignatureAlgorithm): Key = TODO()

actual fun Keys.generateKeyPairFor(algorithm: SignatureAlgorithm): KeyPair<Key, Key> = TODO()
