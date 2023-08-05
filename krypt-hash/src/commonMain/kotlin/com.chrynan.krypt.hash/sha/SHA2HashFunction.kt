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
sealed interface SHA2HashFunction : HashFunction {

    val algorithm: SupportedAlgorithm

    /**
     * The supported variants of the SHA-2 algorithm that the [SHA2HashFunction] implements.
     */
    sealed class SupportedAlgorithm : HashAlgorithm {

        data object Sha224 : SupportedAlgorithm() {

            override val name = "SHA-224"
        }

        data object Sha256 : SupportedAlgorithm() {

            override val name: String = "SHA-256"
        }

        data object Sha384 : SupportedAlgorithm() {

            override val name: String = "SHA-384"
        }

        data object Sha512 : SupportedAlgorithm() {

            override val name: String = "SHA-512"
        }

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
        SHA2HashFunction.SupportedAlgorithm.Sha224,
        SHA2HashFunction.SupportedAlgorithm.Sha256 -> SHA224And256HashFunction(algorithm = algorithm)

        SHA2HashFunction.SupportedAlgorithm.Sha384,
        SHA2HashFunction.SupportedAlgorithm.Sha512 -> SHA384And512HashFunction(algorithm = algorithm)
    }
