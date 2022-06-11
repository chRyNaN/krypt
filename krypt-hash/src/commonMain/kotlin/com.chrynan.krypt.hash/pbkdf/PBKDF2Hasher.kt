@file:Suppress("SpellCheckingInspection")

package com.chrynan.krypt.hash.pbkdf

import com.chrynan.krypt.core.HashFunction
import com.chrynan.krypt.hash.ByteHasher
import com.chrynan.krypt.hash.Hasher

/**
 * A [ByteHasher] that uses the PBKDF2 (password-based key derivation function 2) algorithm. To create an instance of
 * this use the [Hasher.Companion.pbkdf2] function.
 *
 * @see [RFC Specification](https://datatracker.ietf.org/doc/html/rfc2898)
 * @see [Wikipedia Explanation](https://en.wikipedia.org/wiki/PBKDF2)
 */
interface PBKDF2Hasher : ByteHasher<PBKDF2Algorithm, PBKDF2HashResult> {

    companion object
}

/**
 * Implementation of the [PBKDF2Hasher] interface.
 */
internal class PBKDF2HasherImpl(
    hashFunction: HashFunction<ByteArray, ByteArray>,
    override val algorithm: PBKDF2Algorithm,
) : PBKDF2Hasher {

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
    hashFunction: HashFunction<ByteArray, ByteArray>
): PBKDF2Hasher = PBKDF2HasherImpl(
    hashFunction = hashFunction,
    algorithm = PBKDF2Algorithm(
        salt = salt,
        iterationCount = iterationCount,
        hLength = hLength,
        dkLength = dkLength
    )
)
