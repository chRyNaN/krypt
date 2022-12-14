package com.chrynan.krypt.jwt

import com.chrynan.krypt.core.Key
import com.chrynan.krypt.core.KeyPair

object Keys

expect fun Keys.generateHmacKeyFrom(bytes: ByteArray): Key

expect fun Keys.generateSecretKeyFor(algorithm: SignatureAlgorithm): Key

expect fun Keys.generateKeyPairFor(algorithm: SignatureAlgorithm): KeyPair<Key, Key>
