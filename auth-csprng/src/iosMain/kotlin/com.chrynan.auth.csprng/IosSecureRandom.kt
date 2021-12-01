@file:Suppress("unused")

package com.chrynan.auth.csprng

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.memScoped
import platform.Security.SecRandomCopyBytes
import platform.Security.kSecRandomDefault
import kotlin.random.Random

actual class SecureRandom actual constructor() : Random() {

    actual override fun nextBits(bitCount: Int): Int {
        memScoped {
            val nativeByteArray = allocArray<ByteVar>(10)
            val result = SecRandomCopyBytes(kSecRandomDefault, 10, nativeByteArray.getPointer(this))
            TODO("Not yet implemented")
        }
        // arc4random_buf(3)
        TODO("Not yet implemented")
    }

    actual companion object
}
