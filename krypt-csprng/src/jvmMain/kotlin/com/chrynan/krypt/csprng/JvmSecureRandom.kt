@file:Suppress("unused")

package com.chrynan.krypt.csprng

actual class SecureRandom : AbstractSecureRandom {

    private val javaSecureRandom: java.security.SecureRandom

    actual constructor() : super() {
        javaSecureRandom = try {
            java.security.SecureRandom.getInstanceStrong()
        } catch (e: Exception) {
            java.security.SecureRandom()
        }
    }

    constructor(javaSecureRandom: java.security.SecureRandom) : super() {
        this.javaSecureRandom = javaSecureRandom
    }

    constructor(algorithmName: String?) : super() {
        javaSecureRandom = algorithmName?.let { java.security.SecureRandom.getInstance(it) }
            ?: try {
                java.security.SecureRandom.getInstanceStrong()
            } catch (e: Exception) {
                java.security.SecureRandom()
            }
    }

    actual override fun nextBytes(array: ByteArray, fromIndex: Int, toIndex: Int): ByteArray {
        javaSecureRandom.nextBytes(array)

        return array.copyOfRange(fromIndex = fromIndex, toIndex = toIndex)
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SecureRandom) return false

        return javaSecureRandom == other.javaSecureRandom
    }

    override fun hashCode(): Int =
        javaSecureRandom.hashCode()

    override fun toString(): String =
        "SecureRandom(javaSecureRandom=$javaSecureRandom)"

    actual companion object
}
