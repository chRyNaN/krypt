@file:Suppress("unused")

package com.chrynan.auth.csprng

import com.chrynan.auth.core.isNodeJs
import kotlin.js.*
import kotlin.random.Random

actual class SecureRandom actual constructor() : Random() {

    private val cryptoJs by lazy { cryptoJs() }

    actual override fun nextBits(bitCount: Int): Int {
        require((bitCount < 0) or (bitCount > 32)) { "bitCount property must be in the range 0 to 32." }

        if (bitCount == 0) return 0

        val bytes = ByteArray(bitCount.bytesPerBitCount())

        cryptoJs.getRandomValues(bytes)

        return bytes.toInt()
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
