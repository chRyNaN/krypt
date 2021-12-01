@file:Suppress("unused")

package com.chrynan.auth.csprng

import android.os.Build
import kotlin.random.Random

actual class SecureRandom : Random {

    private val javaSecureRandom: java.security.SecureRandom

    actual constructor() : super() {
        javaSecureRandom = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            java.security.SecureRandom.getInstanceStrong()
        } else {
            java.security.SecureRandom()
        }
    }

    constructor(javaSecureRandom: java.security.SecureRandom) : super() {
        this.javaSecureRandom = javaSecureRandom
    }

    actual override fun nextBits(bitCount: Int): Int = javaSecureRandom.nextInt().takeUpperBits(bitCount = bitCount)

    override fun nextBoolean(): Boolean = javaSecureRandom.nextBoolean()

    override fun nextInt(): Int = javaSecureRandom.nextInt()

    override fun nextInt(until: Int): Int = javaSecureRandom.nextInt()

    override fun nextLong(): Long = javaSecureRandom.nextLong()

    override fun nextBytes(array: ByteArray): ByteArray {
        javaSecureRandom.nextBytes(array)
        return array
    }

    override fun nextFloat(): Float = javaSecureRandom.nextFloat()

    override fun nextDouble(): Double = javaSecureRandom.nextDouble()

    fun nextGaussian(): Double = javaSecureRandom.nextGaussian()

    fun generateSeed(numBytes: Int): ByteArray = javaSecureRandom.generateSeed(numBytes)

    actual companion object
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
