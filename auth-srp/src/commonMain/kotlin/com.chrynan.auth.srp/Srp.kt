@file:Suppress("RedundantSuspendModifier", "unused")

package com.chrynan.auth.srp

import com.ionspin.kotlin.bignum.integer.BigInteger

/**
 * Computes the x value used to compute the verifier in the SRP protocol. The algorithm to retrieve the x value is as
 * follows:
 *
 * ```
 * x = H(s | H(I | ":" | P))
 * ```
 *
 * @see [RFC-2945](https://datatracker.ietf.org/doc/html/rfc2945)
 */
@ExperimentalUnsignedTypes
internal suspend fun calculateX(
    hash: HashFunction,
    salt: UByteArray,
    identifier: CharSequence,
    secret: CharSequence
): BigInteger {
    val result = hash(salt + hash("$identifier:$secret"))

    return result.toBigInteger()
}

/**
 * Computes the verifier (v) for SRP using the provided [group] and an already computed [x] value. The algorithm to
 * retrieve the verifier is as follows:
 *
 * ```
 * v = g^x % N
 * ```
 *
 * @see [RFC-2945](https://datatracker.ietf.org/doc/html/rfc2945)
 */
internal suspend fun calculateV(group: Group, x: BigInteger): BigInteger = group.g.pow(x).mod(group.N)

/**
 * Computes the k value used in the SRP protocol. It is used to prevent a 2-for-1 guess when an active attacker
 * impersonates the server. The algorithm to retrieve the k value is as follows:
 *
 * ```
 * k = H(N | PAD(g))
 * ```
 *
 * @see [RFC-2945](https://datatracker.ietf.org/doc/html/rfc2945)
 * @see [Wikipedia SRP Article](https://en.wikipedia.org/wiki/Secure_Remote_Password_protocol)
 */
@ExperimentalUnsignedTypes
internal suspend fun calculateK(hash: HashFunction, group: Group): BigInteger {
    val nBytes = group.N.toUByteArray()

    val result = hash(nBytes + pad(group.g.toUByteArray(), nBytes.size))

    return result.toBigInteger()
}

/**
 * Computes the A value used in the SRP protocol. The 'A' value is a public key for the client derived from a private
 * key value of [a]. While [a] must never be shared with the server, the resulting 'A' value from this function should
 * be shared with the server as part of the SRP protocol. The algorithm to retrieve the 'A' value is as follows:
 *
 * ```
 * A = g^a % N
 * ```
 *
 * @see [RFC-2945](https://datatracker.ietf.org/doc/html/rfc2945)
 * @see [Wikipedia SRP Article](https://en.wikipedia.org/wiki/Secure_Remote_Password_protocol)
 */
internal suspend fun calculateA(group: Group, a: BigInteger): BigInteger = group.g.pow(a).mod(group.N)

/**
 * Computes the B value used in the SRP protocol. The 'B' value is a public key for the server derived from a private
 * key value of [b]. While [b] must never be shared with the client, the resulting 'B' value from this function should
 * be shared with the client as part of the SRP protocol. The algorithm to retrieve the 'B' value is as follows:
 *
 * ```
 * B = (k * v + g^b) % N
 * ```
 *
 * @see [RFC-2945](https://datatracker.ietf.org/doc/html/rfc2945)
 * @see [Wikipedia SRP Article](https://en.wikipedia.org/wiki/Secure_Remote_Password_protocol)
 * @see [Swift Implementation (Referenced on Dec 22, 2021)](https://github.com/Bouke/SRP/blob/master/Sources/Server.swift)
 */
internal suspend fun calculateB(group: Group, k: BigInteger, v: BigInteger, b: BigInteger): BigInteger =
    ((k * v) + (group.g.pow(b))) % group.N

/**
 * Computes the u value used in the SRP protocol. The algorithm to retrieve the 'u' value is as follows:
 *
 * ```
 * u = H(PAD(A) | PAD(B))
 * ```
 *
 * @see [RFC-2945](https://datatracker.ietf.org/doc/html/rfc2945)
 * @see [Wikipedia SRP Article](https://en.wikipedia.org/wiki/Secure_Remote_Password_protocol)
 * @see [Swift Implementation (Referenced on Dec 22, 2021)](https://github.com/Bouke/SRP/blob/master/Sources/SRP.swift)
 */
@ExperimentalUnsignedTypes
internal suspend fun calculateU(
    hash: HashFunction,
    group: Group,
    A: BigInteger,
    B: BigInteger
): BigInteger {
    val size = group.N.toUByteArray().size

    val paddedA = pad(array = A.toUByteArray(), size = size)
    val paddedB = pad(array = B.toUByteArray(), size = size)

    return hash(paddedA + paddedB).toBigInteger()
}

/**
 * Computes the M1 value used in the SRP protocol. The `M1` value is used to prove that the already computed shared key
 * value matches the server's computed shared key value. The [K1] (a.k.a. 'K', not to be confused with little 'k') is
 * the client's computed session key. The algorithm to retrieve the 'M1' value is as follows:
 *
 * ```
 * M1 = H(H(N) XOR H(g) | H(I) | s | A | B | K)
 * ```
 *
 * @see [RFC-2945](https://datatracker.ietf.org/doc/html/rfc2945)
 * @see [Wikipedia SRP Article](https://en.wikipedia.org/wiki/Secure_Remote_Password_protocol)
 * @see [Swift Implementation (Referenced on Dec 22, 2021)](https://github.com/Bouke/SRP/blob/master/Sources/SRP.swift)
 */
@ExperimentalUnsignedTypes
internal suspend fun calculateM1(
    hash: HashFunction,
    group: Group,
    identifier: CharSequence,
    salt: UByteArray,
    A: BigInteger,
    B: BigInteger,
    K1: BigInteger
): UByteArray {
    val xorResult = (hash(group.N).toBigInteger() xor hash(group.g).toBigInteger()).toUByteArray()
    val hI = hash(identifier)

    return hash(xorResult + hI + salt + A + B + K1)
}

/**
 * Computes the M2 value used in the SRP protocol. The `M2` value is used to prove that the already computed shared key
 * value matches the client's computed shared key value. This function takes in a [M1] value, which is the result of
 * the [calculateM1] function from the client. The [K2] (a.k.a. 'K', not to be confused with little 'k') is the
 * server's computed session key. The algorithm to retrieve the 'M2' value is as follows:
 *
 * ```
 * M2 = H(A | M | K)
 * ```
 *
 * @see [RFC-2945](https://datatracker.ietf.org/doc/html/rfc2945)
 * @see [Wikipedia SRP Article](https://en.wikipedia.org/wiki/Secure_Remote_Password_protocol)
 * @see [Swift Implementation (Referenced on Dec 22, 2021)](https://github.com/Bouke/SRP/blob/master/Sources/SRP.swift)
 */
@ExperimentalUnsignedTypes
internal suspend fun calculateM2(
    hash: HashFunction,
    A: BigInteger,
    M1: UByteArray,
    K2: BigInteger
): UByteArray = hash(A + M1 + K2)

/**
 * Computes the S1 value used in the SRP protocol. The 'S1' value is an intermediary value that is used to compute the
 * shared session key for the client. The algorithm to retrieve the 'S1' value is as follows:
 *
 * ```
 * S1 = (B - kg^x) ^ (a + ux)
 * ```
 *
 * Note that `v = g^x`, and that the result of `B - kg^x` might become negative, which should not be stored in a
 * [BigInteger] with a positive Sign. To avoid this, we'll add `N` to `B_` and make sure `kv` isn't greater than `N`.
 *
 * @see [RFC-2945](https://datatracker.ietf.org/doc/html/rfc2945)
 * @see [Wikipedia SRP Article](https://en.wikipedia.org/wiki/Secure_Remote_Password_protocol)
 * @see [Swift Implementation (Referenced on Dec 26, 2021)](https://github.com/Bouke/SRP/blob/master/Sources/Client.swift)
 */
internal suspend fun calculateS1(
    group: Group,
    k: BigInteger,
    v: BigInteger,
    x: BigInteger,
    u: BigInteger,
    a: BigInteger,
    B: BigInteger
): BigInteger = (B + group.N - k * v % group.N).pow(a + u * x).mod(group.N)

/**
 * Computes the S2 value used in the SRP protocol. The 'S2' value is an intermediary value that is used to compute the
 * shared session key for the server. The algorithm to retrieve the 'S2' value is as follows:
 *
 * ```
 * S2 = ((A * v ^ u) mod N) ^ b mod N
 * ```
 *
 * @see [RFC-2945](https://datatracker.ietf.org/doc/html/rfc2945)
 * @see [Wikipedia SRP Article](https://en.wikipedia.org/wiki/Secure_Remote_Password_protocol)
 * @see [Swift Implementation (Referenced on Dec 26, 2021)](https://github.com/Bouke/SRP/blob/master/Sources/Server.swift)
 */
internal suspend fun calculateS2(
    group: Group,
    A: BigInteger,
    v: BigInteger,
    u: BigInteger,
    b: BigInteger
): BigInteger = (A * v.pow(u).mod(group.N)).pow(b).mod(group.N)

/**
 * Computes the shared session key value used in the SRP protocol. The shared session key value, also called 'K' (not
 * to be confused with 'k'), is computed by hashing the provided [S] value which is either the result of the
 * [calculateS1] or the [calculateS2] function. The value returned from this function should be equal for both 'S1'
 * and 'S2' provided as [S]. The algorithm to retrieve the 'K' value is as follows:
 *
 * ```
 * K = H(S1)
 * ```
 *
 * @see [RFC-2945](https://datatracker.ietf.org/doc/html/rfc2945)
 * @see [Wikipedia SRP Article](https://en.wikipedia.org/wiki/Secure_Remote_Password_protocol)
 * @see [Swift Implementation (Referenced on Dec 26, 2021)](https://github.com/Bouke/SRP/blob/master/Sources/Client.swift)
 */
@ExperimentalUnsignedTypes
internal suspend fun calculateSharedSessionKey(
    hash: HashFunction,
    S: BigInteger
): UByteArray = hash(S)

/**
 * Retrieves a padded [ByteArray] that has a size of the provided [size] value. This will add [Byte]s of zero to the
 * first indexes that are added to the returned [ByteArray], then concatenate the provided [array] items to the end of
 * the returned [ByteArray]. This function is needed for the SRP implementation.
 *
 * **Note:** This function will throw an exception if the provided [size] is greater than or equal to [array]'s size.
 */
@ExperimentalUnsignedTypes
internal fun pad(array: UByteArray, size: Int): UByteArray {
    require(size >= array.size) { "size parameter must be larger than the provided array.size value for padding." }

    return UByteArray(size - array.size) + array
}
