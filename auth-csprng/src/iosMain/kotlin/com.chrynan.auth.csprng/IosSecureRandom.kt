@file:Suppress("unused")

package com.chrynan.auth.csprng

import com.benasher44.uuid.Uuid
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.memScoped
import platform.Security.SecRandomCopyBytes
import platform.Security.kSecRandomDefault

actual class SecureRandom internal constructor(name: String) {

    actual fun nextBoolean(): Boolean {
        TODO("Not yet implemented")
    }

    actual fun nextInt(): Int {
        TODO("Not yet implemented")
    }

    actual fun nextInt(bound: Int): Int {
        TODO("Not yet implemented")
    }

    actual fun nextLong(): Long {
        TODO("Not yet implemented")
    }

    actual fun nextBytes(bytes: ByteArray) {
        TODO("Not yet implemented")
    }

    actual fun nextFloat(): Float {
        TODO("Not yet implemented")
    }

    actual fun nextDouble(): Double {
        TODO("Not yet implemented")
    }

    actual fun nextGaussian(): Double {
        TODO("Not yet implemented")
    }

    actual fun generateSeed(numBytes: Int): ByteArray {
        memScoped {
            val nativeByteArray = allocArray<ByteVar>(10)
            val result = SecRandomCopyBytes(kSecRandomDefault, 10, nativeByteArray.getPointer(this))
            TODO("Not yet implemented")
        }
    }

    actual companion object
}

actual fun SecureRandom(): SecureRandom = TODO("Not yet implemented")

actual fun SecureRandom.nextUuid(): Uuid = TODO("Not yet implemented")
