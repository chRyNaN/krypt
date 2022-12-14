@file:Suppress("unused")

package com.chrynan.krypt.jwt

import com.chrynan.krypt.core.Key
import com.chrynan.krypt.core.KeyPair

actual fun Keys.generateHmacKeyFrom(bytes: ByteArray): Key =
    throw UnsupportedOperationException("Generating Keys for iOS is not currently supported.")

actual fun Keys.generateSecretKeyFor(algorithm: SignatureAlgorithm): Key =
    throw UnsupportedOperationException("Generating Keys for iOS is not currently supported.")

actual fun Keys.generateKeyPairFor(algorithm: SignatureAlgorithm): KeyPair<Key, Key> =
    throw UnsupportedOperationException("Generating Keys for iOS is not currently supported.")
