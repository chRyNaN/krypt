package com.chrynan.krypt.hash.pbkdf

import com.chrynan.krypt.core.Endian
import com.chrynan.krypt.core.HashFunction
import com.chrynan.krypt.core.toByteArray
import com.chrynan.krypt.core.toInt

/**
 * An implementation of the PBKDF2 (password-based key derivation function 2) key derivation function. A key derivation
 * function is a hash function that derives an output key from an input key. In the case of password-based key
 * derivation functions, the input key would be the password. The PBKDF2 key derivation function can be used as a
 * password hash function or a means to derive a new key value.
 *
 * The PBKDF2 takes in a password, a salt, and an iteration count as parameters. It performs a psuedorandom function to
 * the input password and salt value and repeats the process for the iteration count amount of times. This produces the
 * output derived key value. The added computational work of performing the operations an iteration count amount of
 * times, makes password cracking computationally expensive and difficult. This process is known as "key stretching".
 *
 * The PBKDF2 function is defined as the following algorithm:
 *
 * ```
 * DK = PBKDF2(PRF, Password, Salt, c, dkLen)
 * ```
 *
 * @see [RFC Specification](https://datatracker.ietf.org/doc/html/rfc2898)
 * @see [Wikipedia Explanation](https://en.wikipedia.org/wiki/PBKDF2)
 */
internal class PBKDF2HashFunction(
    private val hashFunction: HashFunction<ByteArray, ByteArray>,
    private val algorithm: PBKDF2Algorithm
) : HashFunction<ByteArray, ByteArray> {

    override val algorithmName: String
        get() = algorithm.name

    override suspend fun invoke(source: ByteArray): ByteArray {
        var result = byteArrayOf()

        for (i in 1..algorithm.dkLength / algorithm.hLength) {
            result += f(password = source, salt = algorithm.salt, c = algorithm.iterationCount, i = i)
        }

        return result
    }

    /**
     * Performs the F function defined in the specification.
     *
     * ```
     * Ti = F(Password, Salt, c, i)
     * F(Password, Salt, c, i) = U1 ^ U2 ^ ⋯ ^ Uc
     *
     * where:
     * U1 = PRF(Password, Salt + INT_32_BE(i))
     * U2 = PRF(Password, U1)
     * ⋮
     * Uc = PRF(Password, Uc−1)
     * ```
     *
     * @see [RFC Specification](https://datatracker.ietf.org/doc/html/rfc2898#section-5.2)
     * @see [Wikipedia Definition](https://en.wikipedia.org/wiki/PBKDF2#Key_derivation_process)
     */
    private suspend fun f(password: ByteArray, salt: ByteArray, c: Int, i: Int): ByteArray {
        // `i` (the block index value), is converted to a ByteArray in big-endian format. This is used for the first
        // iteration of this function's computation. Note that `i` should be a one-based index.
        val bigEndianI = i.toByteArray(order = Endian.Big)

        // Compute the first iteration to derive `U1`
        // `U1 = PRF(Password, Salt + INT_32_BE(i))`
        var previousU = hashFunction(source = password + salt + bigEndianI)
        var result = previousU.toInt()

        (0 until c).forEach { _ ->
            previousU = hashFunction(source = password + previousU)

            result = result xor previousU.toInt()
        }

        return result.toByteArray()
    }
}
