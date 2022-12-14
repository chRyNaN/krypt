@file:Suppress("unused")

package com.chrynan.krypt.core

/**
 * Converts this [java.security.Key] to a [Key] instance from this krypt library.
 */
fun java.security.Key.toMultiplatformKey(): Key = AndroidKey(jvmKey = this)

/**
 * Converts this [java.security.KeyPair] to a [KeyPair] instance from this krypt library.
 */
fun java.security.KeyPair.toMultiplatformKeyPair(): KeyPair<Key, Key> = AndroidKeyPair(jvmKeyPair = this)

internal class AndroidKey(private val jvmKey: java.security.Key) : Key {

    override val algorithm: String
        get() = jvmKey.algorithm

    override val encoded: ByteArray?
        get() = jvmKey.encoded

    override val format: String?
        get() = jvmKey.format

    override fun hashCode(): Int = jvmKey.hashCode()

    override fun equals(other: Any?): Boolean {
        if (other !is AndroidKey) return false

        return jvmKey == other
    }

    override fun toString(): String = "AndroidKey(key=$jvmKey)"
}

internal class AndroidKeyPair(private val jvmKeyPair: java.security.KeyPair) : KeyPair<Key, Key> {

    override val privateKey: Key = jvmKeyPair.private.toMultiplatformKey()

    override val publicKey: Key = jvmKeyPair.public.toMultiplatformKey()

    override fun hashCode(): Int = jvmKeyPair.hashCode()

    override fun equals(other: Any?): Boolean {
        if (other !is AndroidKeyPair) return false

        return jvmKeyPair == other.jvmKeyPair
    }

    override fun toString(): String = "AndroidKeyPair(pair=$jvmKeyPair)"
}
