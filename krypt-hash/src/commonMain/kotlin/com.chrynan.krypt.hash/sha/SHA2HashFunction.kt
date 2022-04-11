package com.chrynan.krypt.hash.sha

import com.chrynan.krypt.core.*
import com.chrynan.krypt.hash.HashAlgorithm

/**
 * An SHA-2 [HashFunction] implementation. The supported variants of the SHA-2 algorithm are defined in the
 * [SupportedAlgorithm] enum class. To utilize this hashing algorithm, use the [SHA2Hasher] interface and one of its
 * factory functions, such as [sha256].
 *
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
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
        SHA2HashFunction.SupportedAlgorithm.SHA_256 -> SHA224Or256HashFunction(algorithm = algorithm)
        SHA2HashFunction.SupportedAlgorithm.SHA_384,
        SHA2HashFunction.SupportedAlgorithm.SHA_512 -> SHA384Or512HashFunction(algorithm = algorithm)
    }

/**
 * An implementation of the SHA-2 224 and 256 hashing algorithms.
 *
 * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634)
 */
private class SHA224Or256HashFunction(
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
            val block = IntArray(16)

            for ((blockIndex, j) in (i until i + 64 step 4).withIndex()) {
                // The specification states to use Big Endian.
                block[blockIndex] = paddedMessage.toInt(startInclusive = j, endExclusive = j + 4, order = Endian.Big)
            }

            h = processBlock(M = block, H = h)
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
        val bytesToAdd = ((((bitCount + 1) % 512) - 448) / -1) / 8

        // Add the padding to the end of the list until it is a 512 multiple (minus 64 bits for the original size).
        for (i in 0 until bytesToAdd) {
            paddedMessage.add(0)
        }

        // Add the original size of the message as a 64-bit binary block
        // TODO: Could this be more performant? Perhaps inlined instead of creating a ByteArray instance.
        message.size.toLong().toByteArray(order = Endian.Big).forEach {
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
        for (t in 0..63) {
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
        for (t in 0..63) {
            val T1 = h + BSIG1(x = e) + CH(x = e, y = f, z = g) + K[t].toInt() + W[t]
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
        )

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

private class SHA384Or512HashFunction(
    override val algorithm: SHA2HashFunction.SupportedAlgorithm
) : SHA2HashFunction {

    init {
        require(algorithm == SHA2HashFunction.SupportedAlgorithm.SHA_384 || algorithm == SHA2HashFunction.SupportedAlgorithm.SHA_512) {
            "This SHA-2 hash function implementation only supports 384 or 512 bit modes."
        }
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    override suspend fun invoke(source: ByteArray): ByteArray {
        // Pad the message to be a multiple of 1024 bits.
        val paddedMessage = pad(message = source)

        // Break the message up into 1024 bit (128 byte) blocks.
        // Then process each block, using the result of the previously processed block as the input to the
        // next process call. For the first process call, use the initialization vector for the algorithm.
        var h =
            if (algorithm == SHA2HashFunction.SupportedAlgorithm.SHA_384) ivH384.toLongArray() else ivH512.toLongArray()
        for (i in paddedMessage.indices step 128) {
            val block = LongArray(16)

            for ((blockIndex, j) in (i until i + 128 step 8).withIndex()) {
                // The specification states to use Big Endian.
                block[blockIndex] = paddedMessage.toLong(startInclusive = j, endExclusive = j + 8, order = Endian.Big)
            }

            h = processBlock(M = block, H = h)
        }

        // Produce the final output by concatenating the h value according to the specification:
        // https://datatracker.ietf.org/doc/html/rfc4634#section-6.4
        // For SHA-512 this is all the values, for SHA-384 this is all except for the last two values.
        // Then convert it back to a ByteArray and return the result.
        return if (algorithm == SHA2HashFunction.SupportedAlgorithm.SHA_384) {
            h.sliceArray(0..5).toByteArray(order = Endian.Big)
        } else {
            h.toByteArray(order = Endian.Big)
        }
    }

    /**
     * Pads the provided [message] according to the SHA-2 Specification Section 4 and 4.2, and returns the result.
     *
     * Note that this function is deliberately designed to be a stateless function at the possible slight cost in
     * performance. This was done in an effort to promote legibility and understanding of the algorithm and to
     * hopefully reduce any unexpected errors. Therefore, any array parameter passed in to this function, will not be
     * altered by this function.
     *
     * @see [RFC-4634, Section 4](https://datatracker.ietf.org/doc/html/rfc4634#section-4)
     * @see [RFC-4634, Section 4.2](https://datatracker.ietf.org/doc/html/rfc4634#section-4.2)
     */
    private fun pad(message: ByteArray): ByteArray {
        val paddedMessage = message.toMutableList()

        // Add 80 since that is equivalent to adding a 1 and seven 0s to make up a byte.
        paddedMessage.add(80)

        // 8 bits in a byte.
        val bitCount = paddedMessage.size * 8
        val bytesToAdd = ((((bitCount + 1) % 1024) - 896) / -1) / 8

        // Add the padding to the end of the list until it is a 512 multiple (minus 64 bits for the original size).
        for (i in 0 until bytesToAdd) {
            paddedMessage.add(0)
        }

        // Add the original size of the message as a 64-bit binary block
        // TODO: Could this be more performant? Perhaps inlined instead of creating a ByteArray instance.
        message.size.toLong().toByteArray(order = Endian.Big).forEach {
            paddedMessage.add(it)
        }

        return paddedMessage.toByteArray()
    }

    /**
     * Computes a single block of "words" in the SHA-2 384/512 algorithm. A message to be hashed using the SHA-2
     * 384/512 algorithm, is first padded and then broken into 1024-bit "blocks", which are considered to be composed
     * of 80 64-bit "words". Each block is processed subsequently, with the results of the previous block being used in
     * the computation of the next block. The result of the final call to this function should then be used to compute
     * the final hash value of the SHA-2 384/512 algorithm.
     *
     * Note that this function is deliberately designed to be a stateless function at the possible slight cost in
     * performance. This was done in an effort to promote legibility and understanding of the algorithm and to
     * hopefully reduce any unexpected errors. Therefore, any array parameter passed in to this function, will not be
     * altered by this function.
     *
     * Note that the parameter and variable names used within this function do not typically conform to the Kotlin
     * naming conventions. This is because they attempt to match the names defined in the SHA-2 Specification.
     *
     * @param [M] The words belonging to this block. A "word" is a 64-bit [Long] value. There are 80 "words" per block,
     * therefore the size of [M] should be 80, otherwise an exception will be thrown.
     * @param [H] The words of the hash values. These values have a default implementation depending on the algorithm
     * being performed (SHA-384 or SHA-512). Then they will equal the result of this function from the previous block.
     * So the result of this function call, can be used in the invocation of this function for the next block. The size
     * of [H] should be 8, otherwise an exception will be thrown.
     *
     * @return A [LongArray] representing the intermediate hash values as a result of processing this block. These
     * values should be provided to this function when processing the next block. If this is the last block of the
     * message, then the return value represents the final hash values of this algorithm, which can then be used to
     * obtain the final hash result of the SHA-2 algorithm.
     *
     * @see [RFC-4634, Section 6.4](https://datatracker.ietf.org/doc/html/rfc4634#section-6.4)
     */
    @ExperimentalUnsignedTypes
    @Suppress("LocalVariableName")
    private fun processBlock(
        M: LongArray,
        H: LongArray
    ): LongArray {
        require(M.size == 16) { "M must have a size of 16." }
        require(H.size == 8) { "H must have a size of 8." }

        //
        // The "message schedule". Each of the values at each index in this array are considered the "words" of the
        // "message schedule". Taken from RFC-4634, Section 6.4:
        // https://datatracker.ietf.org/doc/html/rfc4634#section-6.4
        //
        val W = LongArray(size = 80)

        //
        // Prepare the message schedule W. Taken from RFC-4634, Section 6.4, Step 1:
        // https://datatracker.ietf.org/doc/html/rfc4634#section-6.4
        //
        // This expands the 16 word block into 80 word block.
        //
        for (t in 0..80) {
            if (t < 16) {
                W[t] = M[t]
            } else {
                W[t] = SSIG1(x = W[t - 2]) + W[t - 7] + SSIG0(x = W[t - 15]) + W[t - 16]
            }
        }

        //
        // Initialize the working variables. Taken from RFC-4634, Section 6.4, Step 2:
        // https://datatracker.ietf.org/doc/html/rfc4634#section-6.4
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
        // Perform the main hash computation. Taken from RFC-4634, Section 6.4, Step 3:
        // https://datatracker.ietf.org/doc/html/rfc4634#section-6.4
        //
        for (t in 0..79) {
            val T1 = h + BSIG1(x = e) + CH(x = e, y = f, z = g) + K[t].toLong() + W[t]
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
        // Compute the intermediate hash values. Taken from RFC-4634, Section 6.4, Step 4:
        // https://datatracker.ietf.org/doc/html/rfc4634#section-6.4
        //
        return longArrayOf(
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
     * [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.2) for SHA-384 and SHA-512.
     * Each of these functions operate on 64-bit (8-byte) "words" named [x], [y], and [z]. These "words" are
     * represented as the [Long] type since an [Long] is 64 bits. The result of each of these functions is a new
     * 64-bit "word", or [Long] value. The names of these functions mimic the names defined in the SHA-2
     * Specification, and as such, do not conform to the proper Kotlin function naming conventions.
     *
     * Note that the implementation of this function is the same as the SHA-224 and SHA-256 algorithm but uses [Long]
     * values instead of [Int] values.
     *
     * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.2)
     */
    @Suppress("FunctionName")
    private fun CH(x: Long, y: Long, z: Long): Long =
        (x and y) xor (x.inv() and z)

    /**
     * The "MAJ" SHA function.
     *
     * ```
     * MAJ( x, y, z) = (x AND y) XOR (x AND z) XOR (y AND z)
     * ```
     *
     * This is one of the six logical functions defined in the
     * [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.2) for SHA-384 and SHA-512.
     * Each of these functions operate on 64-bit (8-byte) "words" named [x], [y], and [z]. These "words" are
     * represented as the [Long] type since an [Long] is 64 bits. The result of each of these functions is a new
     * 64-bit "word", or [Long] value. The names of these functions mimic the names defined in the SHA-2
     * Specification, and as such, do not conform to the proper Kotlin function naming conventions.
     *
     * Note that the implementation of this function is the same as the SHA-224 and SHA-256 algorithm but uses [Long]
     * values instead of [Int] values.
     *
     * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.2)
     */
    @Suppress("FunctionName")
    private fun MAJ(x: Long, y: Long, z: Long): Long =
        (x and y) xor (x and z) xor (y and z)

    /**
     * The "BSIG0" SHA function.
     *
     * ```
     * BSIG0(x) = ROTR^28(x) XOR ROTR^34(x) XOR ROTR^39(x)
     * ```
     *
     * This is one of the six logical functions defined in the
     * [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.2) for SHA-384 and SHA-512.
     * Each of these functions operate on 64-bit (8-byte) "words" named [x], "y", and "z". These "words" are
     * represented as the [Long] type since an [Long] is 64 bits. The result of each of these functions is a new
     * 64-bit "word", or [Long] value. The names of these functions mimic the names defined in the SHA-2
     * Specification, and as such, do not conform to the proper Kotlin function naming conventions.
     *
     * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.2)
     */
    @Suppress("FunctionName", "SpellCheckingInspection")
    private fun BSIG0(x: Long): Long =
        ROTR(n = 28, x = x) xor ROTR(n = 34, x = x) xor ROTR(n = 39, x = x)

    /**
     * The "BSIG1" SHA function.
     *
     * ```
     * BSIG1(x) = ROTR^14(x) XOR ROTR^18(x) XOR ROTR^41(x)
     * ```
     *
     * This is one of the six logical functions defined in the
     * [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.2) for SHA-384 and SHA-512.
     * Each of these functions operate on 64-bit (8-byte) "words" named [x], "y", and "z". These "words" are
     * represented as the [Long] type since an [Long] is 64 bits. The result of each of these functions is a new
     * 64-bit "word", or [Long] value. The names of these functions mimic the names defined in the SHA-2
     * Specification, and as such, do not conform to the proper Kotlin function naming conventions.
     *
     * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.2)
     */
    @Suppress("FunctionName", "SpellCheckingInspection")
    private fun BSIG1(x: Long): Long =
        ROTR(n = 14, x = x) xor ROTR(n = 18, x = x) xor ROTR(n = 41, x = x)

    /**
     * The "SSIG0" SHA function.
     *
     * ```
     * SSIG0(x) = ROTR^1(x) XOR ROTR^8(x) XOR SHR^7(x)
     * ```
     *
     * This is one of the six logical functions defined in the
     * [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.2) for SHA-384 and SHA-512.
     * Each of these functions operate on 64-bit (8-byte) "words" named [x], "y", and "z". These "words" are
     * represented as the [Long] type since an [Long] is 64 bits. The result of each of these functions is a new
     * 64-bit "word", or [Long] value. The names of these functions mimic the names defined in the SHA-2
     * Specification, and as such, do not conform to the proper Kotlin function naming conventions.
     *
     * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.2)
     */
    @Suppress("FunctionName", "SpellCheckingInspection")
    private fun SSIG0(x: Long): Long =
        ROTR(n = 1, x = x) xor ROTR(n = 8, x = x) xor (x ushr 7)

    /**
     * The "SSIG1" SHA function.
     *
     * ```
     * SSIG1(x) = ROTR^19(x) XOR ROTR^61(x) XOR SHR^6(x)
     * ```
     *
     * This is one of the six logical functions defined in the
     * [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.2) for SHA-384 and SHA-512.
     * Each of these functions operate on 64-bit (8-byte) "words" named [x], "y", and "z". These "words" are
     * represented as the [Long] type since an [Long] is 64 bits. The result of each of these functions is a new
     * 64-bit "word", or [Long] value. The names of these functions mimic the names defined in the SHA-2
     * Specification, and as such, do not conform to the proper Kotlin function naming conventions.
     *
     * @see [SHA-2 Specification](https://datatracker.ietf.org/doc/html/rfc4634#section-5.2)
     */
    @Suppress("FunctionName", "SpellCheckingInspection")
    private fun SSIG1(x: Long): Long =
        ROTR(n = 19, x = x) xor ROTR(n = 61, x = x) xor (x ushr 6)

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
     * @param [w] The bit size of the [x] value. Defaults to 64-bit which is used for SHA-384 and SHA-512.
     */
    @Suppress("FunctionName", "SpellCheckingInspection")
    private fun ROTR(x: Long, n: Int, w: Int = 64): Long =
        (x ushr n) or (x shl (w - n))

    companion object {

        /**
         * SHA-2 constant K (K0...K79) for SHA-384 and SHA-512 algorithms. Each value in the array [K], is a 64-bit
         * "word" value. These "word" values represent the first 64 bits of the fractional parts of the
         * cube roots of the first eighty prime numbers.
         *
         * Note that this is a [ULongArray] instead of a [LongArray] to match the unsigned values specified in the
         * protocol. The implementation will have to convert to a [Long] value in the algorithm.
         *
         * @see [RFC-4634, Section 5.2](https://datatracker.ietf.org/doc/html/rfc4634#section-5.2)
         */
        @ExperimentalUnsignedTypes
        val K = ulongArrayOf(
            0x428a2f98d728ae22UL, 0x7137449123ef65cdUL, 0xb5c0fbcfec4d3b2fUL, 0xe9b5dba58189dbbcUL,
            0x3956c25bf348b538UL, 0x59f111f1b605d019UL, 0x923f82a4af194f9bUL, 0xab1c5ed5da6d8118UL,
            0xd807aa98a3030242UL, 0x12835b0145706fbeUL, 0x243185be4ee4b28cUL, 0x550c7dc3d5ffb4e2UL,
            0x72be5d74f27b896fUL, 0x80deb1fe3b1696b1UL, 0x9bdc06a725c71235UL, 0xc19bf174cf692694UL,
            0xe49b69c19ef14ad2UL, 0xefbe4786384f25e3UL, 0x0fc19dc68b8cd5b5UL, 0x240ca1cc77ac9c65UL,
            0x2de92c6f592b0275UL, 0x4a7484aa6ea6e483UL, 0x5cb0a9dcbd41fbd4UL, 0x76f988da831153b5UL,
            0x983e5152ee66dfabUL, 0xa831c66d2db43210UL, 0xb00327c898fb213fUL, 0xbf597fc7beef0ee4UL,
            0xc6e00bf33da88fc2UL, 0xd5a79147930aa725UL, 0x06ca6351e003826fUL, 0x142929670a0e6e70UL,
            0x27b70a8546d22ffcUL, 0x2e1b21385c26c926UL, 0x4d2c6dfc5ac42aedUL, 0x53380d139d95b3dfUL,
            0x650a73548baf63deUL, 0x766a0abb3c77b2a8UL, 0x81c2c92e47edaee6UL, 0x92722c851482353bUL,
            0xa2bfe8a14cf10364UL, 0xa81a664bbc423001UL, 0xc24b8b70d0f89791UL, 0xc76c51a30654be30UL,
            0xd192e819d6ef5218UL, 0xd69906245565a910UL, 0xf40e35855771202aUL, 0x106aa07032bbd1b8UL,
            0x19a4c116b8d2d0c8UL, 0x1e376c085141ab53UL, 0x2748774cdf8eeb99UL, 0x34b0bcb5e19b48a8UL,
            0x391c0cb3c5c95a63UL, 0x4ed8aa4ae3418acbUL, 0x5b9cca4f7763e373UL, 0x682e6ff3d6b2b8a3UL,
            0x748f82ee5defb2fcUL, 0x78a5636f43172f60UL, 0x84c87814a1f0ab72UL, 0x8cc702081a6439ecUL,
            0x90befffa23631e28UL, 0xa4506cebde82bde9UL, 0xbef9a3f7b2c67915UL, 0xc67178f2e372532bUL,
            0xca273eceea26619cUL, 0xd186b8c721c0c207UL, 0xeada7dd6cde0eb1eUL, 0xf57d4f7fee6ed178UL,
            0x06f067aa72176fbaUL, 0x0a637dc5a2c898a6UL, 0x113f9804bef90daeUL, 0x1b710b35131c471bUL,
            0x28db77f523047d84UL, 0x32caab7b40c72493UL, 0x3c9ebe0a15c9bebcUL, 0x431d67c49c100d4cUL,
            0x4cc5d4becb3e42b6UL, 0x597f299cfc657e2aUL, 0x5fcb6fab3ad6faecUL, 0x6c44198c4a475817UL
        )

        /**
         * The initial hash values, or initialization vectors for SHA-384. The values are defined in
         * [RFC-4634](https://datatracker.ietf.org/doc/html/rfc4634#section-6.3). These are fixed constant values.
         * These are the values to provide the [processBlock] function for the first invocation.
         */
        @ExperimentalUnsignedTypes
        val ivH384 = ulongArrayOf(
            0xcbbb9d5dc1059ed8UL,
            0x629a292a367cd507UL,
            0x9159015a3070dd17UL,
            0x152fecd8f70e5939UL,
            0x67332667ffc00b31UL,
            0x8eb44a8768581511UL,
            0xdb0c2e0d64f98fa7UL,
            0x47b5481dbefa4fa4UL
        )

        /**
         * The initial hash values, or initialization vectors for SHA-512. The values are defined in
         * [RFC-4634](https://datatracker.ietf.org/doc/html/rfc4634#section-6.3). These are fixed constant values.
         * These are the values to provide the [processBlock] function for the first invocation.
         */
        @ExperimentalUnsignedTypes
        val ivH512 = ulongArrayOf(
            0x6a09e667f3bcc908UL,
            0xbb67ae8584caa73bUL,
            0x3c6ef372fe94f82bUL,
            0xa54ff53a5f1d36f1UL,
            0x510e527fade682d1UL,
            0x9b05688c2b3e6c1fUL,
            0x1f83d9abfb41bd6bUL,
            0x5be0cd19137e2179UL
        )
    }
}
