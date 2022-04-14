@file:Suppress("unused")

package com.chrynan.krypt.core

/**
 * Converts this [java.security.Key] to a [Key] instance from this krypt library.
 */
fun java.security.Key.toMultiplatformKey(): Key = JvmKey(this)

internal class JvmKey(private val jvmKey: java.security.Key) : Key {

    override val algorithm: String
        get() = jvmKey.algorithm

    override val encoded: ByteArray?
        get() = jvmKey.encoded

    override val format: String?
        get() = jvmKey.format

    override fun hashCode(): Int = jvmKey.hashCode()

    override fun equals(other: Any?): Boolean = jvmKey == other

    override fun toString(): String = "JvmKey(key=$jvmKey)"
}
