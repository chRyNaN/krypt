@file:Suppress("unused")

package com.chrynan.krypt.core

/**
 * Converts this [java.security.Key] to a [Key] instance from this krypt library.
 */
fun java.security.Key.toMultiplatformKey(): Key = JvmKey(this)

/**
 * Converts this [java.security.KeyPair] to a [KeyPair] instance from this krypt library.
 */
fun java.security.KeyPair.toMultiplatformKeyPair(): KeyPair<Key, Key> = JvmKeyPair(jvmKeyPair = this)

internal class JvmKey(private val jvmKey: java.security.Key) : Key {

    override val algorithm: String
        get() = jvmKey.algorithm

    override val encoded: ByteArray?
        get() = jvmKey.encoded

    override val format: String?
        get() = jvmKey.format

    override fun hashCode(): Int = jvmKey.hashCode()

    override fun equals(other: Any?): Boolean {
        if (other !is JvmKey) return false

        return jvmKey == other
    }

    override fun toString(): String = "JvmKey(key=$jvmKey)"
}

internal class JvmKeyPair(private val jvmKeyPair: java.security.KeyPair) : KeyPair<Key, Key> {

    override val privateKey: Key = jvmKeyPair.private.toMultiplatformKey()

    override val publicKey: Key = jvmKeyPair.public.toMultiplatformKey()

    override fun hashCode(): Int = jvmKeyPair.hashCode()

    override fun equals(other: Any?): Boolean {
        if (other !is JvmKeyPair) return false

        return jvmKeyPair == other.jvmKeyPair
    }

    override fun toString(): String = "JvmKeyPair(pair=$jvmKeyPair)"
}
