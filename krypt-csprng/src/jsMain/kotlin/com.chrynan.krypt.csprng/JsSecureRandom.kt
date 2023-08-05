@file:Suppress("unused")

package com.chrynan.krypt.csprng

import com.chrynan.krypt.core.isNodeJs
import kotlin.js.*

actual class SecureRandom actual constructor() : AbstractSecureRandom() {

    private val cryptoJs by lazy { cryptoJs() }

    actual override fun nextBytes(array: ByteArray, fromIndex: Int, toIndex: Int): ByteArray {
        cryptoJs.getRandomValues(array)

        return array
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SecureRandom) return false

        return cryptoJs == other.cryptoJs
    }

    override fun hashCode(): Int =
        cryptoJs.hashCode()

    override fun toString(): String =
        "SecureRandom()"

    actual companion object
}

private external class Crypto {

    fun getRandomValues(array: ByteArray)

    fun randomFillSync(array: ByteArray)
}

// Variable is renamed to `_crypto` so it wouldn't clash with existing `crypto` variable.
// JS IR backend doesn't reserve names accessed inside js("") calls
private fun cryptoJs(): Crypto = // lazy because otherwise it's untestable due to evaluation order
    if (isNodeJs()) {
        js("eval('require')('crypto')") as Crypto
    } else {
        js("(window ? (window.crypto ? window.crypto : window.msCrypto) : self.crypto)") as Crypto
    }
