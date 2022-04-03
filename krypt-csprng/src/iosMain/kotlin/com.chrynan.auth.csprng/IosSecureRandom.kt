@file:Suppress("unused")

package com.chrynan.auth.csprng

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.get
import kotlinx.cinterop.memScoped
import platform.Security.SecRandomCopyBytes
import platform.Security.errSecSuccess
import platform.Security.kSecRandomDefault
import kotlin.random.Random

actual class SecureRandom actual constructor() : Random() {

    actual override fun nextBits(bitCount: Int): Int {
        require((bitCount < 0) or (bitCount > 32)) { "bitCount property must be in the range 0 to 32." }

        if (bitCount == 0) return 0

        memScoped {
            val length = bitCount.bytesPerBitCount()
            val nativeByteArray = allocArray<ByteVar>(length)
            val result = SecRandomCopyBytes(kSecRandomDefault, length.toULong(), nativeByteArray.getPointer(this))

            if (result == errSecSuccess) {
                val bytes = ByteArray(length)

                for (i in 0..length) {
                    bytes[i] = nativeByteArray[i]
                }

                return bytes.toInt()
            } else {
                throw error("Error occurred attempting to retrieve nextBits(): bitCount = $bitCount")
            }
        }
    }

    actual companion object
}
