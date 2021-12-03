@file:Suppress("unused")

package com.chrynan.auth.csprng

import com.chrynan.auth.core.isNodeJs
import kotlin.experimental.and
import kotlin.js.*
import kotlin.random.Random

actual class SecureRandom actual constructor() : Random() {

    private val cryptoJs by lazy { cryptoJs() }

    actual override fun nextBits(bitCount: Int): Int {
        val bytes = nextBytes(ByteArray((bitCount / 8) + 1))

        return (bytes[0] and 0xFF.toByte()).toInt() shl 24 or
                ((bytes[1] and 0xFF.toByte()).toInt() shl 16) or
                ((bytes[2] and 0xFF.toByte()).toInt() shl 8) or
                ((bytes[3] and 0xFF.toByte()).toInt() shl 0)
    }

    override fun nextBytes(array: ByteArray): ByteArray {
        cryptoJs.getRandomValues(array)
        return array
    }

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
