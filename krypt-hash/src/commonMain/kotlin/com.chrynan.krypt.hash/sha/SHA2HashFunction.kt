package com.chrynan.krypt.hash.sha

import com.chrynan.krypt.core.*
import com.chrynan.krypt.hash.HashAlgorithm

/**
 * An SHA-2 [HashFunction] implementation. The supported variants of the SHA-2 algorithm are defined in the
 * [SupportedAlgorithm] enum class. To utilize this hashing algorithm, use the [SHA2Hasher] interface and one of its
 * factory functions, such as [sha256].
 *
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
 * @see [FIPS 180-4](https://nvlpubs.nist.gov/nistpubs/FIPS/NIST.FIPS.180-4.pdf)
 * @see [SHA2Hasher]
 * @see [sha256]
 */
sealed interface SHA2HashFunction : HashFunction<ByteArray, ByteArray> {

    val algorithm: SupportedAlgorithm

    override val algorithmName: String
        get() = algorithm.name

    /**
     * The supported variants of the SHA-2 algorithm that the [SHA2HashFunction] implements.
     */
    enum class SupportedAlgorithm(val algorithmName: String) : HashAlgorithm {

        SHA_224(algorithmName = "SHA-224"),
        SHA_256(algorithmName = "SHA-256"),
        SHA_384(algorithmName = "SHA-384"),
        SHA_512(algorithmName = "SHA-512");

        override val version: String
            get() = "2"
    }
}

/**
 * Creates an instance of a [SHA2HashFunction] for the provided supported [algorithm].
 */
internal fun SHA2HashFunction(
    algorithm: SHA2HashFunction.SupportedAlgorithm
): SHA2HashFunction =
    when (algorithm) {
        SHA2HashFunction.SupportedAlgorithm.SHA_224,
        SHA2HashFunction.SupportedAlgorithm.SHA_256 -> SHA224And256HashFunction(algorithm = algorithm)
        SHA2HashFunction.SupportedAlgorithm.SHA_384,
        SHA2HashFunction.SupportedAlgorithm.SHA_512 -> SHA384And512HashFunction(algorithm = algorithm)
    }
