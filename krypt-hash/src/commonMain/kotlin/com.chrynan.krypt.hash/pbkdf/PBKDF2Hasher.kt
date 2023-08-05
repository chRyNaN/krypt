@file:Suppress("SpellCheckingInspection")

package com.chrynan.krypt.hash.pbkdf

import com.chrynan.krypt.core.HashFunction
import com.chrynan.krypt.hash.Hasher

/**
 * A [Hasher] that uses the PBKDF2 (password-based key derivation function 2) algorithm. To create an instance of this
 * use the [Hasher.Companion.pbkdf2] function.
 *
 * @see [RFC Specification](https://datatracker.ietf.org/doc/html/rfc2898)
 * @see [Wikipedia Explanation](https://en.wikipedia.org/wiki/PBKDF2)
 */
class PBKDF2Hasher internal constructor(
    hashFunction: HashFunction,
    override val algorithm: PBKDF2Algorithm,
) : Hasher<PBKDF2Algorithm, PBKDF2HashResult> {

    private val pbkdf2HashFunction = PBKDF2HashFunction(
        algorithm = algorithm,
        hashFunction = hashFunction
    )

    override suspend fun invoke(source: ByteArray): PBKDF2HashResult {
        val hash = pbkdf2HashFunction.invoke(source = source)

        return PBKDF2HashResult(
            algorithm = algorithm,
            hash = hash
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PBKDF2Hasher) return false

        if (algorithm != other.algorithm) return false

        return pbkdf2HashFunction == other.pbkdf2HashFunction
    }

    override fun hashCode(): Int {
        var result = algorithm.hashCode()
        result = 31 * result + pbkdf2HashFunction.hashCode()
        return result
    }

    override fun toString(): String =
        "PBKDF2Hasher(algorithm=$algorithm, pbkdf2HashFunction=$pbkdf2HashFunction)"

    companion object
}

/**
 * Creates a [PBKDF2Hasher] for the PBKDF2 function with the provided parameters.
 *
 * Note that this function creates a [Hasher] with the provided [salt] value, so subsequent invocations of this
 * [Hasher]'s [Hasher.invoke] function will utilize the same [salt]. However, each password should be combined with a
 * unique salt value. So, one would have to create a different [PBKDF2Hasher] for each password value being hashed.
 *
 * @param [salt] The cryptographic salt value that is utilized in the PBKDF2 algorithm to hash the provided value in
 * the [PBKDF2Hasher.invoke] function.
 * @param [iterationCount] The amount of iterations this PBKDF2 algorithm performs.
 * @param [hLength] The byte length of the output of the provided [hashFunction].
 * @param [dkLength] The desired bit length of the derived key.
 *
 * @see [RFC Specification](https://datatracker.ietf.org/doc/html/rfc2898)
 * @see [Wikipedia Explanation](https://en.wikipedia.org/wiki/PBKDF2)
 */
@Suppress("unused")
fun Hasher.Companion.pbkdf2(
    salt: ByteArray,
    iterationCount: Int,
    hLength: Int,
    dkLength: Int,
    hashFunction: HashFunction
): PBKDF2Hasher = PBKDF2Hasher(
    hashFunction = hashFunction,
    algorithm = PBKDF2Algorithm(
        salt = salt,
        iterationCount = iterationCount,
        hLength = hLength,
        dkLength = dkLength
    )
)

/**
 * Creates a [PBKDF2Hasher] for the PBKDF2 function with the provided parameters.
 *
 * @param [algorithm] The [PBKDF2Algorithm] used to create an instance of the [PBKDF2Hasher].
 *
 * @see [Hasher.Companion.pbkdf2]
 * @see [RFC Specification](https://datatracker.ietf.org/doc/html/rfc2898)
 * @see [Wikipedia Explanation](https://en.wikipedia.org/wiki/PBKDF2)
 */
@Suppress("unused")
fun Hasher.Companion.pbkdf2(
    algorithm: PBKDF2Algorithm,
    hashFunction: HashFunction
): PBKDF2Hasher = PBKDF2Hasher(
    hashFunction = hashFunction,
    algorithm = PBKDF2Algorithm(
        salt = algorithm.salt,
        iterationCount = algorithm.iterationCount,
        hLength = algorithm.hLength,
        dkLength = algorithm.dkLength
    )
)
