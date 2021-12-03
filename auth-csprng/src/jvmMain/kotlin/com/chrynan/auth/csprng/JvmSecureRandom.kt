@file:Suppress("unused")

package com.chrynan.auth.csprng

import kotlin.random.Random

actual class SecureRandom : Random {

    private val javaSecureRandom: java.security.SecureRandom

    actual constructor() : super() {
        javaSecureRandom = java.security.SecureRandom.getInstanceStrong()
    }

    constructor(javaSecureRandom: java.security.SecureRandom) : super() {
        this.javaSecureRandom = javaSecureRandom
    }

    actual override fun nextBits(bitCount: Int): Int {
        require((bitCount < 0) or (bitCount > 32)) { "bitCount property must be in the range 0 to 32." }

        if (bitCount == 0) return 0

        return javaSecureRandom.nextInt().takeUpperBits(bitCount = bitCount)
    }

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
    val javaSecureRandom = algorithmName?.let { java.security.SecureRandom.getInstance(it) }
        ?: java.security.SecureRandom.getInstanceStrong()

    return SecureRandom(javaSecureRandom = javaSecureRandom)
}
