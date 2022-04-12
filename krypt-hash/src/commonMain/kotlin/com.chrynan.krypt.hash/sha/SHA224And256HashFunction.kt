package com.chrynan.krypt.hash.sha

import com.chrynan.krypt.core.Endian
import com.chrynan.krypt.core.toByteArray
import com.chrynan.krypt.core.toInt

/**
 * An implementation of the SHA-2 224 and 256 hashing algorithms.
 *
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
 * @see [FIPS 180-4](https://nvlpubs.nist.gov/nistpubs/FIPS/NIST.FIPS.180-4.pdf)
 */
// FIXME: This implementation is broken and I have no idea why.
internal class SHA224And256HashFunction(
    override val algorithm: SHA2HashFunction.SupportedAlgorithm
) : SHA2HashFunction {

    init {
        require(algorithm == SHA2HashFunction.SupportedAlgorithm.SHA_224 || algorithm == SHA2HashFunction.SupportedAlgorithm.SHA_256) {
            "This SHA-2 hash function implementation only supports 224 or 256 bit modes."
        }
    }

    override suspend fun invoke(source: ByteArray): ByteArray {
        // Pad the message to be a multiple of 512 bits.
        val paddedMessage = pad(message = source)

        // Break the message up into 512 bit (64 byte) blocks.
        // Then process each block, using the result of the previously processed block as the input to the
        // next process call. For the first process call, use the initialization vector for the algorithm.
        var h = if (algorithm == SHA2HashFunction.SupportedAlgorithm.SHA_224) ivH224 else ivH256
        for (i in paddedMessage.indices step 64) {
            val m = IntArray(16)

            for ((mIndex, j) in (i until i + 64 step 4).withIndex()) {
                // The specification states to use Big Endian.
                m[mIndex] = paddedMessage.toInt(startInclusive = j, endExclusive = j + 4, order = Endian.Big)
            }

            h = processBlock(M = m, H = h)
        }

        // Produce the final output by concatenating the h value according to the specification:
        // https://datatracker.ietf.org/doc/html/rfc4634#section-6.2
        // For SHA-256 this is all the values, for SHA-224 this is all except for the last value.
        // Then convert it back to a ByteArray and return the result.
        return if (algorithm == SHA2HashFunction.SupportedAlgorithm.SHA_224) {
            h.sliceArray(0..6).toByteArray(order = Endian.Big)
        } else {
            h.toByteArray(order = Endian.Big)
        }
    }

    /**
     * Pads the provided [message] according to the SHA-2 Specification Section 4 and 4.1, and returns the result.
     *
     * Note that this function is deliberately designed to be a stateless function at the possible slight cost in
     * performance. This was done in an effort to promote legibility and understanding of the algorithm and to
     * hopefully reduce any unexpected errors. Therefore, any array parameter passed in to this function, will not be
     * altered by this function.
     *
     * @see [RFC-4634, Section 4](https://datatracker.ietf.org/doc/html/rfc4634#section-4)
     * @see [RFC-4634, Section 4.1](https://datatracker.ietf.org/doc/html/rfc4634#section-4.1)
     */
    private fun pad(message: ByteArray): ByteArray {
        //
        // RFC-4634, Section 4.1, Part b.
        // K "0"s are appended where K is the smallest, non-negative solution to the equation. This is the amount of
        // zero bits to add, it should be a multiple of 8 since we are using ByteArrays.
        //
        // L + 1 + K = 448 (mod 512) - Declared in the specification
        // L + 1 = 448 - K
        // L + 1 - 448 = -1 * K
        // (L + 1 - 448) / -1 = K
        // (((L + 1) % 512) - 448) / -1 = K - When considering the modulo 512
        //

        val paddedMessage = message.toMutableList()

        // Add 80 since that is equivalent to adding a 1 and seven 0s to make up a byte.
        paddedMessage.add(80)

        // 8 bits in a byte.
        val bitCount = paddedMessage.size * 8
        val bitsToAdd = (((bitCount % 512) - 448) / -1)
        val bytesToAdd = if (bitsToAdd % 8 == 0) bitsToAdd / 8 else (bitsToAdd / 8) + 1

        // Add the padding to the end of the list until it is a 512 multiple (minus 64 bits for the original size).
        for (i in 0 until bytesToAdd) {
            paddedMessage.add(0)
        }

        // Add the original size of the message as a 64-bit binary block
        // TODO: Could this be more performant? Perhaps inlined instead of creating a ByteArray instance.
        (message.size * 8).toLong().toByteArray(order = Endian.Big).forEach {
            paddedMessage.add(it)
        }

        return paddedMessage.toByteArray()
    }

    /**
     * Computes a single block of "words" in the SHA-2 algorithm. A message to be hashed using the SHA-2 algorithm, is
     * first padded and then broken into 512-bit "blocks", which are considered to be composed of 16 32-bit "words".
     * Each block is processed subsequently, with the results of the previous block being used in the computation of
     * the next block. The result of the final call to this function should then be used to compute the final hash
     * value of the SHA-2 algorithm.
     *
     * Note that this function is deliberately designed to be a stateless function at the possible slight cost in
     * performance. This was done in an effort to promote legibility and understanding of the algorithm and to
     * hopefully reduce any unexpected errors. Therefore, any array parameter passed in to this function, will not be
     * altered by this function.
     *
     * Note that the parameter and variable names used within this function do not typically conform to the Kotlin
     * naming conventions. This is because they attempt to match the names defined in the SHA-2 Specification.
     *
     * @param [M] The words belonging to this block. A "word" is a 32-bit [Int] value. There are 16 "words" per block,
     * therefore the size of [M] should be 16, otherwise an exception will be thrown.
     * @param [H] The words of the hash values. These values have a default implementation depending on the algorithm
     * being performed (SHA-224 or SHA-256). Then they will equal the result of this function from the previous block.
     * So the result of this function call, can be used in the invocation of this function for the next block. The size
     * of [H] should be 8, otherwise an exception will be thrown.
     *
     * @return An [IntArray] representing the intermediate hash values as a result of processing this block. These
     * values should be provided to this function when processing the next block. If this is the last block of the
     * message, then the return value represents the final hash values of this algorithm, which can then be used to
     * obtain the final hash result of the SHA-2 algorithm.
     *
     * @see [RFC-4634, Section 6.2](https://datatracker.ietf.org/doc/html/rfc4634#section-6.2)
     */
    @Suppress("LocalVariableName")
    private fun processBlock(
        M: IntArray,
        H: IntArray
    ): IntArray {
        require(M.size == 16) { "M must have a size of 16." }
        require(H.size == 8) { "H must have a size of 8." }

        //
        // The "message schedule". Each of the values at each index in this array are considered the "words" of the
        // "message schedule". Taken from RFC-4634, Section 6.2:
        // https://datatracker.ietf.org/doc/html/rfc4634#section-6.2
        //
        val W = IntArray(size = 64)

        //
        // Prepare the message schedule W. Taken from RFC-4634, Section 6.2, Step 1:
        // https://datatracker.ietf.org/doc/html/rfc4634#section-6.2
        //
        // This expands the 16 word block into a 64 word block.
        //
        for (t in 0 until 64) {
            if (t < 16) {
                W[t] = M[t]
            } else {
                W[t] = SSIG1(x = W[t - 2]) + W[t - 7] + SSIG0(x = W[t - 15]) + W[t - 16]
            }
        }

        //
        // Initialize the working variables. Taken from RFC-4634, Section 6.2, Step 2:
        // https://datatracker.ietf.org/doc/html/rfc4634#section-6.2
        //
        var a = H[0]
        var b = H[1]
        var c = H[2]
        var d = H[3]
        var e = H[4]
        var f = H[5]
        var g = H[6]
        var h = H[7]

        //
        // Perform the main hash computation. Taken from RFC-4634, Section 6.2, Step 3:
        // https://datatracker.ietf.org/doc/html/rfc4634#section-6.2
        //
        for (t in 0 until 64) {
            val T1 = h + BSIG1(x = e) + CH(x = e, y = f, z = g) + K[t] + W[t]
            val T2 = BSIG0(x = a) + MAJ(x = a, y = b, z = c)

            h = g
            g = f
            f = e
            e = d + T1
            d = c
            c = b
            b = a
            a = T1 + T2
        }

        //
        // Compute the intermediate hash values. Taken from RFC-4634, Section 6.2, Step 4:
        // https://datatracker.ietf.org/doc/html/rfc4634#section-6.2
        //
        return intArrayOf(
            H[0] + a,
            H[1] + b,
            H[2] + c,
            H[3] + d,
            H[4] + e,
            H[5] + f,
            H[6] + g,
            H[7] + h
        )
    }

    /**
     * The "CH" SHA function.
     *
     * ```
     * CH( x, y, z) = (x AND y) XOR ( (NOT x) AND z)
     * ```
     *
     * This is one of the six logical functions defined in the
     * [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.1) for SHA-224 and SHA-256.
     * Each of these functions operate on 32-bit (4-byte) "words" named [x], [y], and [z]. These "words" are
     * represented as the [Int] type since an [Int] is 32 bits. The result of each of these functions is a new
     * 32-bit "word", or [Int] value. The names of these functions mimic the names defined in the SHA-2
     * Specification, and as such, do not conform to the proper Kotlin function naming conventions.
     *
     * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.1)
     */
    @Suppress("FunctionName")
    private fun CH(x: Int, y: Int, z: Int): Int =
        (x and y) xor (x.inv() and z)

    /**
     * The "MAJ" SHA function.
     *
     * ```
     * MAJ( x, y, z) = (x AND y) XOR (x AND z) XOR (y AND z)
     * ```
     *
     * This is one of the six logical functions defined in the
     * [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.1) for SHA-224 and SHA-256.
     * Each of these functions operate on 32-bit (4-byte) "words" named [x], [y], and [z]. These "words" are
     * represented as the [Int] type since an [Int] is 32 bits. The result of each of these functions is a new
     * 32-bit "word", or [Int] value. The names of these functions mimic the names defined in the SHA-2
     * Specification, and as such, do not conform to the proper Kotlin function naming conventions.
     *
     * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.1)
     */
    @Suppress("FunctionName")
    private fun MAJ(x: Int, y: Int, z: Int): Int =
        (x and y) xor (x and z) xor (y and z)

    /**
     * The "BSIG0" SHA function.
     *
     * ```
     * BSIG0(x) = ROTR^2(x) XOR ROTR^13(x) XOR ROTR^22(x)
     * ```
     *
     * This is one of the six logical functions defined in the
     * [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.1) for SHA-224 and SHA-256.
     * Each of these functions operate on 32-bit (4-byte) "words" named [x], "y", and "z". These "words" are
     * represented as the [Int] type since an [Int] is 32 bits. The result of each of these functions is a new
     * 32-bit "word", or [Int] value. The names of these functions mimic the names defined in the SHA-2
     * Specification, and as such, do not conform to the proper Kotlin function naming conventions.
     *
     * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.1)
     */
    @Suppress("FunctionName", "SpellCheckingInspection")
    private fun BSIG0(x: Int): Int =
        ROTR(n = 2, x = x) xor ROTR(n = 13, x = x) xor ROTR(n = 22, x = x)

    /**
     * The "BSIG1" SHA function.
     *
     * ```
     * BSIG1(x) = ROTR^6(x) XOR ROTR^11(x) XOR ROTR^25(x)
     * ```
     *
     * This is one of the six logical functions defined in the
     * [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.1) for SHA-224 and SHA-256.
     * Each of these functions operate on 32-bit (4-byte) "words" named [x], "y", and "z". These "words" are
     * represented as the [Int] type since an [Int] is 32 bits. The result of each of these functions is a new
     * 32-bit "word", or [Int] value. The names of these functions mimic the names defined in the SHA-2
     * Specification, and as such, do not conform to the proper Kotlin function naming conventions.
     *
     * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.1)
     */
    @Suppress("FunctionName", "SpellCheckingInspection")
    private fun BSIG1(x: Int): Int =
        ROTR(n = 6, x = x) xor ROTR(n = 11, x = x) xor ROTR(n = 25, x = x)

    /**
     * The "SSIG0" SHA function.
     *
     * ```
     * SSIG0(x) = ROTR^7(x) XOR ROTR^18(x) XOR SHR^3(x)
     * ```
     *
     * This is one of the six logical functions defined in the
     * [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.1) for SHA-224 and SHA-256.
     * Each of these functions operate on 32-bit (4-byte) "words" named [x], "y", and "z". These "words" are
     * represented as the [Int] type since an [Int] is 32 bits. The result of each of these functions is a new
     * 32-bit "word", or [Int] value. The names of these functions mimic the names defined in the SHA-2
     * Specification, and as such, do not conform to the proper Kotlin function naming conventions.
     *
     * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.1)
     */
    @Suppress("FunctionName", "SpellCheckingInspection")
    private fun SSIG0(x: Int): Int =
        ROTR(n = 7, x = x) xor ROTR(n = 18, x = x) xor (x ushr 3)

    /**
     * The "SSIG1" SHA function.
     *
     * ```
     * SSIG1(x) = ROTR^17(x) XOR ROTR^19(x) XOR SHR^10(x)
     * ```
     *
     * This is one of the six logical functions defined in the
     * [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.1) for SHA-224 and SHA-256.
     * Each of these functions operate on 32-bit (4-byte) "words" named [x], "y", and "z". These "words" are
     * represented as the [Int] type since an [Int] is 32 bits. The result of each of these functions is a new
     * 32-bit "word", or [Int] value. The names of these functions mimic the names defined in the SHA-2
     * Specification, and as such, do not conform to the proper Kotlin function naming conventions.
     *
     * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.1)
     */
    @Suppress("FunctionName", "SpellCheckingInspection")
    private fun SSIG1(x: Int): Int =
        ROTR(n = 17, x = x) xor ROTR(n = 19, x = x) xor (x ushr 10)

    /**
     * Represents the "ROTR^n(x)" "word" operation defined in the
     * [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-3) section 3, letter d. This
     * operation is referred to as "circular right shift".
     *
     * ```
     * ROTR^n(x) = (x>>n) OR (x<<(w-n))
     * ```
     *
     * @param [x] A [w] bit sized "word".
     * @param [n] An [Int] where 0 <= [n] < [w].
     * @param [w] The bit size of the [x] value. Defaults to 32-bit which is used for SHA-224 and SHA-256.
     */
    @Suppress("FunctionName", "SpellCheckingInspection")
    private fun ROTR(x: Int, n: Int, w: Int = 32): Int =
        (x ushr n) or (x shl (w - n))

    companion object {

        /**
         * SHA-2 constant K (K0...K63) for SHA-224 and SHA-256 algorithms. Each value in the array [K], is a 32-bit
         * "word" value. These "word" values represent the first 32 bits of the fractional parts of the
         * cube roots of the first sixty-four prime numbers.
         *
         * Note that this is internally a [LongArray] instead of an [IntArray]. This is because that only the first 32
         * bits of each value should be used, but some values fully defined exceed 32 bits. This would require us to
         * convert them to an [Int], but the definition would not look uniform (trailing [Long.toInt] calls on some but
         * not all values). To avoid this, a [LongArray] is used instead, then the call site is responsible for
         * converting the values into [Int] values.
         *
         * @see [RFC-4634, Section 5.1](https://datatracker.ietf.org/doc/html/rfc4634#section-5.1)
         */
        val K = longArrayOf(
            0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
            0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
            0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
            0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
            0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
            0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
            0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
            0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2
        ).map { it.toInt() }

        /**
         * The initial hash values, or initialization vectors for SHA-224. The values are defined in
         * [RFC-4634](https://datatracker.ietf.org/doc/html/rfc4634#section-6.1). These are fixed constant values.
         * These are the values to provide the [processBlock] function for the first invocation.
         */
        val ivH224 = intArrayOf(
            0xc1059ed8.toInt(),
            0x367cd507,
            0x3070dd17,
            0xf70e5939.toInt(),
            0xffc00b31.toInt(),
            0x68581511,
            0x64f98fa7,
            0xbefa4fa4.toInt()
        )

        /**
         * The initial hash values, or initialization vectors for SHA-256. The values are defined in
         * [RFC-4634](https://datatracker.ietf.org/doc/html/rfc4634#section-6.1). These are fixed constant values.
         * These are the values to provide the [processBlock] function for the first invocation.
         */
        val ivH256 = intArrayOf(
            0x6a09e667,
            0xbb67ae85.toInt(),
            0x3c6ef372,
            0xa54ff53a.toInt(),
            0x510e527f,
            0x9b05688c.toInt(),
            0x1f83d9ab,
            0x5be0cd19
        )
    }
}
