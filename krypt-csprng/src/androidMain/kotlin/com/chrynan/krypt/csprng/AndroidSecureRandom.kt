@file:Suppress("unused")

package com.chrynan.krypt.csprng

import android.os.Build

actual class SecureRandom : AbstractSecureRandom {

    private val androidSecureRandom: java.security.SecureRandom

    actual constructor() : super() {
        androidSecureRandom = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                java.security.SecureRandom.getInstanceStrong()
            } catch (e: Exception) {
                java.security.SecureRandom()
            }
        } else {
            java.security.SecureRandom()
        }
    }

    constructor(javaSecureRandom: java.security.SecureRandom) : super() {
        this.androidSecureRandom = javaSecureRandom
    }

    constructor(algorithmName: String?) : super() {
        androidSecureRandom = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            algorithmName?.let { java.security.SecureRandom.getInstance(it) }
                ?: try {
                    java.security.SecureRandom.getInstanceStrong()
                } catch (e: Exception) {
                    java.security.SecureRandom()
                }
        } else {
            algorithmName?.let { java.security.SecureRandom.getInstance(it) }
                ?: java.security.SecureRandom()
        }
    }

    actual override fun nextBytes(array: ByteArray, fromIndex: Int, toIndex: Int): ByteArray {
        androidSecureRandom.nextBytes(array)

        return array.copyOfRange(fromIndex = fromIndex, toIndex = toIndex)
    }

    override fun nextBoolean(): Boolean = androidSecureRandom.nextBoolean()

    override fun nextInt(): Int = androidSecureRandom.nextInt()

    override fun nextInt(until: Int): Int = androidSecureRandom.nextInt()

    override fun nextLong(): Long = androidSecureRandom.nextLong()

    override fun nextBytes(array: ByteArray): ByteArray {
        androidSecureRandom.nextBytes(array)
        return array
    }

    override fun nextFloat(): Float = androidSecureRandom.nextFloat()

    override fun nextDouble(): Double = androidSecureRandom.nextDouble()

    fun nextGaussian(): Double = androidSecureRandom.nextGaussian()

    fun generateSeed(numBytes: Int): ByteArray = androidSecureRandom.generateSeed(numBytes)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SecureRandom) return false

        return androidSecureRandom == other.androidSecureRandom
    }

    override fun hashCode(): Int =
        androidSecureRandom.hashCode()

    override fun toString(): String =
        "SecureRandom(androidSecureRandom=$androidSecureRandom)"

    actual companion object
}
