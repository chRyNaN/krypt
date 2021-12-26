@file:Suppress("RedundantSuspendModifier", "unused")

package com.chrynan.auth.srp

import com.chrynan.auth.core.SecureString
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
    identifier: SecureString,
    secret: SecureString
): BigInteger {
    val result = hash(salt + hash("$identifier:$secret".encodeToUByteArray()))

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
    clientPublicKey: BigInteger,
    serverPublicKey: BigInteger
): BigInteger {
    val size = group.N.toUByteArray().size

    val paddedA = pad(array = clientPublicKey.toUByteArray(), size = size)
    val paddedB = pad(array = serverPublicKey.toUByteArray(), size = size)

    return hash(paddedA + paddedB).toBigInteger()
}

/**
 * Computes the M1 value used in the SRP protocol. The `M1` value is used to prove that the already computed shared key
 * value matches the server's computed shared key value. The algorithm to retrieve the 'M1' value is as follows:
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
    identifier: String,
    salt: UByteArray,
    clientPublicKey: BigInteger,
    serverPublicKey: BigInteger,
    sharedSessionKey: BigInteger
): UByteArray {
    val xorResult = (hash(group.N).toBigInteger() xor hash(group.g).toBigInteger()).toUByteArray()
    val hI = hash(identifier)

    return hash(xorResult + hI + salt + clientPublicKey + serverPublicKey + sharedSessionKey)
}

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
