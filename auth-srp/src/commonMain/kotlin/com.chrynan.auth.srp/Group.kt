@file:Suppress("unused")

package com.chrynan.auth.srp

import com.ionspin.kotlin.bignum.integer.BigInteger

/**
 * Represents the "Group" parameters ("N" [a.k.a. "prime"], and "g" [a.k.a. "generator"]) in the Secure Remote Password
 * Protocol (SRP) algorithm.
 *
 * These group parameter values, used in the SRP algorithm, must be agreed upon by the client and server. They can be
 * hardcoded in advance, or the server can supply them to the client by sending them along with the salt.
 *
 * The [prime] and [generator] properties should satisfy the following requirements defined in the SRP protocol
 * specification:
 *
 * - The [prime] (N) value should be a **safe prime**, which is a prime number of the form `N = 2q + 1`, where `q` is
 * also a prime.
 * - The [generator] (g) value should be a generator of the multiplicative group modulo N, which means that for any X
 * where 0 < X < N, there exists a value x for which g^x % N == X.
 *
 * **Note:** That while there are requirements for the values [prime] and [generator] defined by the SRP protocol, no
 * validation or verification is performed by this interface, instead is left up to the implementor to perform.
 *
 * @see [RFC-2945](https://datatracker.ietf.org/doc/html/rfc2945)
 * @see [RFC-5054](https://datatracker.ietf.org/doc/html/rfc5054)
 * @see [Wikipedia SRP Article](https://en.wikipedia.org/wiki/Secure_Remote_Password_protocol)
 * @see [Swift Implementation (Referenced on Dec 21, 2021)](https://github.com/Bouke/SRP/blob/master/Sources/Group.swift)
 */
interface Group {

    /**
     * The "prime" ("N") group parameter defined in the SRP specification. This value should be a **safe prime**, which
     * is a prime number of the form `N = 2q + 1`, where `q` is also a prime.
     *
     * This is a [BigInteger] value whose size should be a rather large amount of bits. Typical bit counts could be
     * 1024, 2048, 4096, etc.
     *
     * @see [BigInteger]
     */
    val prime: BigInteger

    /**
     * The "generator" ("g") group parameter defined in the SRP specification. This value should be a generator of the
     * multiplicative group modulo N, which means that for any X where 0 < X < N, there exists a value x for which
     * g^x % N == X.
     *
     * This is a [BigInteger] value, however it typically is a small value, such as '2', but depends on the
     * above-mentioned requirements.
     *
     * @see [BigInteger]
     */
    val generator: BigInteger

    /**
     * A companion object on the [Group] interface which can be useful to provide implementations of the [Group]
     * interface as extension properties.
     */
    companion object
}

/**
 * An alias property for [Group.prime].
 *
 * @see [Group.prime]
 */
val Group.N: BigInteger
    get() = prime

/**
 * An alias property for [Group.generator].
 *
 * @see [Group.generator]
 */
val Group.g: BigInteger
    get() = generator

private class GroupImpl(
    override val prime: BigInteger,
    override val generator: BigInteger
) : Group {

    override fun equals(other: Any?): Boolean {
        if (other == null) return false

        if (other !is Group) return false

        return this.prime == other.prime && this.generator == other.generator
    }

    override fun hashCode(): Int = 31 * prime.hashCode() + generator.hashCode()

    override fun toString(): String = "SrpGroup(prime(N)=$prime, generator(g)=$generator)"
}

/**
 * Creates an instance of a [Group] for use in the Secure Remote Password (SRP) protocol with the provided values.
 *
 * @param [prime] (a.k.a. "N") Is a group parameter defined in the SRP specification. This value should be a
 * **safe prime**, which is a prime number of the form `N = 2q + 1`, where `q` is also a prime.
 *
 * @param [generator] (a.k.a. "g") group parameter defined in the SRP specification. This value should be a generator
 * of the multiplicative group modulo N, which means that for any X where 0 < X < N, there exists a value x for which
 * g^x % N == X.
 *
 * **Note:** That while there are requirements for the values [prime] and [generator] defined by the SRP protocol, no
 * validation or verification is performed by this function, instead it is left up to the implementor to perform.
 *
 * @see [Group]
 */
fun Group(
    prime: BigInteger,
    generator: BigInteger
): Group = GroupImpl(
    prime = prime,
    generator = generator
)

/**
 * Creates an instance of a [Group] for use in the Secure Remote Password (SRP) protocol with the provided values.
 *
 * @param [primeString] Is converted into the [Group.prime] using the [primeBase] value.
 *
 * @param [primeBase] Is used to convert the [primeString] into the [Group.prime] value.
 *
 * [Group.prime] (a.k.a. "N") Is a group parameter defined in the SRP specification. This value should be a
 * **safe prime**, which is a prime number of the form `N = 2q + 1`, where `q` is also a prime.
 *
 * @param [generator] (a.k.a. "g") group parameter defined in the SRP specification. This value should be a generator
 * of the multiplicative group modulo N, which means that for any X where 0 < X < N, there exists a value x for which
 * g^x % N == X.
 *
 * **Note:** That while there are requirements for the values [Group.prime] and [generator] defined by the SRP
 * protocol, no validation or verification is performed by this function, instead it is left up to the implementor to
 * perform.
 *
 * @see [Group]
 * @see [Group]
 */
fun Group(
    primeString: String,
    primeBase: Int = 16,
    generator: Int
): Group = Group(
    prime = BigInteger.parseString(string = primeString, base = primeBase),
    generator = BigInteger(generator)
)

/**
 * Represents a [Group] whose [Group.prime] value has 2048 bits. This property is initialized as a private property and
 * then exposed as a public extension property to reduce having to create it numerous times.
 */
private val N2048GroupSingleton: Group = Group(
    prime = BigInteger.parseString(
        string = "AC6BDB41324A9A9BF166DE5E1389582FAF72B6651987EE07FC319294" +
                "3DB56050A37329CBB4A099ED8193E0757767A13DD52312AB4B03310D" +
                "CD7F48A9DA04FD50E8083969EDB767B0CF6095179A163AB3661A05FB" +
                "D5FAAAE82918A9962F0B93B855F97993EC975EEAA80D740ADBF4FF74" +
                "7359D041D5C33EA71D281E446B14773BCA97B43A23FB801676BD207A" +
                "436C6481F1D2B9078717461A5B9D32E688F87748544523B524B0D57D" +
                "5EA77A2775D2ECFA032CFBDBF52FB3786160279004E57AE6AF874E73" +
                "03CE53299CCC041C7BC308D82A5698F3A8D0C38271AE35F8E9DBFBB6" +
                "94B5C803D89F7AE435DE236D525F54759B65E372FCD68EF20FA7111F" +
                "9E4AFF73",
        base = 16
    ),
    generator = BigInteger.TWO
)

/**
 * Represents a [Group] whose [Group.prime] value has 4096 bits. This property is initialized as a private property and
 * then exposed as a public extension property to reduce having to create it numerous times.
 */
private val N4096GroupSingleton: Group = Group(
    prime = BigInteger.parseString(
        string = "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E08" +
                "8A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B" +
                "302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9" +
                "A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE6" +
                "49286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8" +
                "FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D" +
                "670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C" +
                "180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF695581718" +
                "3995497CEA956AE515D2261898FA051015728E5A8AAAC42DAD33170D" +
                "04507A33A85521ABDF1CBA64ECFB850458DBEF0A8AEA71575D060C7D" +
                "B3970F85A6E1E4C7ABF5AE8CDB0933D71E8C94E04A25619DCEE3D226" +
                "1AD2EE6BF12FFA06D98A0864D87602733EC86A64521F2B18177B200C" +
                "BBE117577A615D6C770988C0BAD946E208E24FA074E5AB3143DB5BFC" +
                "E0FD108E4B82D120A92108011A723C12A787E6D788719A10BDBA5B26" +
                "99C327186AF4E23C1A946834B6150BDA2583E9CA2AD44CE8DBBBC2DB" +
                "04DE8EF92E8EFC141FBECAA6287C59474E6BC05D99B2964FA090C3A2" +
                "233BA186515BE7ED1F612970CEE2D7AFB81BDD762170481CD0069127" +
                "D5B05AA993B4EA988D8FDDC186FFB7DC90A6C08F4DF435C934063199" +
                "FFFFFFFFFFFFFFFF",
        base = 16
    ),
    generator = BigInteger(5)
)

/**
 * Represents a [Group] whose [Group.prime] value has 2048 bits.
 */
val Group.Companion.N2048: Group
    get() = N2048GroupSingleton

/**
 * Represents a [Group] whose [Group.prime] value has 4096 bits.
 */
val Group.Companion.N4096: Group
    get() = N4096GroupSingleton
