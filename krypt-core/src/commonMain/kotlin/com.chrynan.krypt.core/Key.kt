@file:Suppress("unused")

package com.chrynan.krypt.core

/**
 * Represents a cryptographic key used in cryptographic algorithms, such as hashing and encrypting. For instance, this
 * could represent either a symmetric or asymmetric key for encryption algorithms. Sub-implementations should provide
 * any extra required properties specific to the algorithm they support. Keys should be treated securely. Whenever
 * possible, [Key] implementations should be delegated to their platform specific implementations. This will ensure
 * correct algorithm implementation and safe usage.
 *
 * Note that this interface was inspired by the
 * [java.security.Key interface](https://docs.oracle.com/javase/8/docs/api/java/security/Key.html).
 *
 * @see [java.security.Key interface](https://docs.oracle.com/javase/8/docs/api/java/security/Key.html)
 */
interface Key {

    /**
     * The standard algorithm name for this key.
     */
    val algorithm: String

    /**
     * The key value in its primary encoding format, or `null` if this key does not support encoding.
     */
    val encoded: ByteArray?

    /**
     * The name of the primary encoding format for this key, or `null` if this key does not support encoding.
     */
    val format: String?

    companion object
}

/**
 * Represents a secret key for a symmetric encryption algorithm.
 *
 * Note that this interface was inspired by the
 * [javax.crypto.SecretKey interface](https://docs.oracle.com/javase/8/docs/api/javax/crypto/SecretKey.html).
 *
 * @see [javax.crypto.SecretKey](https://docs.oracle.com/javase/8/docs/api/javax/crypto/SecretKey.html)
 */
interface SecretKey : Key {

    /**
     * The raw key bytes for this key.
     */
    val raw: ByteArray?

    /**
     * Secret keys should return the raw key bytes for the [encoded] property. This property delegates to the [raw]
     * property by default.
     */
    override val encoded: ByteArray?
        get() = raw

    /**
     * Secret keys should return "RAW" for their [format] and the raw key bytes for the [encoded] property.
     */
    override val format: String
        get() = "RAW"

    companion object
}

/**
 * A component that generates a [Key] of type [K] for a particular [algorithm].
 */
interface KeyGenerator<K : Key> {

    /**
     * The name of the cryptographic algorithm this [KeyGenerator] generates keys for.
     */
    val algorithm: String?

    /**
     * Generates a new [Key] of type [K] for use with the cryptographic [algorithm].
     */
    suspend operator fun invoke(): K

    companion object
}

/**
 * A convenience function that calls the [KeyGenerator.invoke] function. Which function is used is up to preference.
 */
suspend fun <K : Key> KeyGenerator<K>.generate(): K = invoke()

/**
 * Represents a grouping of a [publicKey] and [privateKey] key. Typically, this is used for asymmetric encryption
 * algorithms. Key pairs should be treated securely.
 *
 * Note that this interface was inspired by the
 * [java.security.KeyPair interface](https://docs.oracle.com/javase/8/docs/api/java/security/KeyPair.html).
 *
 * @see [java.security.KeyPair interface](https://docs.oracle.com/javase/8/docs/api/java/security/KeyPair.html)
 */
interface KeyPair<PublicKey, PrivateKey> {

    val publicKey: PublicKey

    val privateKey: PrivateKey

    companion object
}

/**
 * A component that generates a [KeyPair] for a particular algorithm.
 */
interface KeyPairGenerator<PublicKey, PrivateKey> {

    /**
     * The name of the cryptographic algorithm this [KeyPairGenerator] generates [KeyPair]s for.
     */
    val algorithm: String?

    /**
     * Generates a new [KeyPair] for use with the cryptographic [algorithm].
     */
    suspend operator fun invoke(): KeyPair<PublicKey, PrivateKey>

    companion object
}

/**
 * A convenience function that calls the [invoke] function. Which function is used is up to preference.
 */
suspend fun <PublicKey, PrivateKey> KeyPairGenerator<PublicKey, PrivateKey>.generate(): KeyPair<PublicKey, PrivateKey> =
    invoke()
