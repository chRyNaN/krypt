@file:Suppress("unused")

package com.chrynan.krypt.csprng

import android.os.Build
import com.chrynan.krypt.core.SecureString
import com.chrynan.krypt.core.toSecureString
import java.nio.charset.Charset
import kotlin.random.Random

actual class SecureRandom : Random {

    private val javaSecureRandom: java.security.SecureRandom

    actual constructor() : super() {
        javaSecureRandom = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
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
    val javaSecureRandom = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
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

    return SecureRandom(javaSecureRandom = javaSecureRandom)
}

/**
 * Retrieves a [ByteArray] from this [SecureRandom] to be used as a salt, which is typically used when hashing
 * passwords. This is a convenience function which delegates to the [SecureRandom.nextBytes] function.
 *
 * @param [byteCount] The size of the returned [ByteArray].
 * @param [charset] The [Charset] used for the returned salt. Defaults to [Charsets.UTF_8].
 */
fun SecureRandom.nextSaltString(byteCount: Int = 16, charset: Charset = Charsets.UTF_8): SecureString {
    val bytes = nextSalt(byteCount = byteCount)

    return bytes.toString(charset).toSecureString()
}
