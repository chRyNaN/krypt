@file:Suppress("unused")

package com.chrynan.auth.csprng

import android.os.Build
import com.benasher44.uuid.Uuid

actual class SecureRandom internal constructor(private val javaSecureRandom: java.security.SecureRandom) {

    actual fun nextBoolean(): Boolean = javaSecureRandom.nextBoolean()

    actual fun nextInt(): Int = javaSecureRandom.nextInt()

    actual fun nextInt(bound: Int): Int = javaSecureRandom.nextInt()

    actual fun nextLong(): Long = javaSecureRandom.nextLong()

    actual fun nextBytes(bytes: ByteArray) {
        javaSecureRandom.nextBytes(bytes)
    }

    actual fun nextFloat(): Float = javaSecureRandom.nextFloat()

    actual fun nextDouble(): Double = javaSecureRandom.nextDouble()

    actual fun nextGaussian(): Double = javaSecureRandom.nextGaussian()

    actual fun generateSeed(numBytes: Int): ByteArray = javaSecureRandom.generateSeed(numBytes)

    actual companion object
}

actual fun SecureRandom(): SecureRandom {
    val javaSecureRandom = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        java.security.SecureRandom.getInstanceStrong()
    } else {
        java.security.SecureRandom()
    }

    return SecureRandom(javaSecureRandom = javaSecureRandom)
}

fun SecureRandom(algorithmName: String?): SecureRandom {
    val javaSecureRandom = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        algorithmName?.let { java.security.SecureRandom.getInstance(it) }
            ?: java.security.SecureRandom.getInstanceStrong()
    } else {
        algorithmName?.let { java.security.SecureRandom.getInstance(it) }
            ?: java.security.SecureRandom()
    }

    return SecureRandom(javaSecureRandom = javaSecureRandom)
}

actual fun SecureRandom.nextUuid(): Uuid = Uuid.randomUUID()
