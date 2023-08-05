@file:Suppress("unused")

package com.chrynan.krypt.csprng

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.get
import kotlinx.cinterop.memScoped
import platform.Security.SecRandomCopyBytes
import platform.Security.errSecSuccess
import platform.Security.kSecRandomDefault
import kotlin.random.Random

actual class SecureRandom actual constructor() : AbstractSecureRandom() {

    actual override fun nextBytes(array: ByteArray, fromIndex: Int, toIndex: Int): ByteArray {
        memScoped {
            val length = array.size
            val nativeByteArray = allocArray<ByteVar>(length)
            val result = SecRandomCopyBytes(kSecRandomDefault, length.toULong(), nativeByteArray.getPointer(this))

            if (result == errSecSuccess) {
                val bytes = array

                for (i in 0 until length) {
                    bytes[i] = nativeByteArray[i]
                }

                return bytes.copyOfRange(fromIndex = fromIndex, toIndex = toIndex)
            } else {
                error("Error occurred attempting to retrieve 'nextBytes'.")
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        return other is SecureRandom
    }

    override fun hashCode(): Int =
        this::class.hashCode()

    override fun toString(): String =
        "SecureRandom()"

    actual companion object
}
