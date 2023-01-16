@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.chrynan.krypt.uuid

import com.benasher44.uuid.*

/**
 * Represents a Universally Unique Identifier (UUID). A UUID represents a 128-bit value. The implementing class should
 * be considered immutable.
 *
 * @see [RFC-4122](https://www.ietf.org/rfc/rfc4122.txt)
 * @see [Wikipedia Explanation](https://en.wikipedia.org/wiki/Universally_unique_identifier)
 */
class Uuid internal constructor(private val uuid: com.benasher44.uuid.Uuid) : Comparable<Uuid> {

    /**
     * Returns the least significant 64 bits of this UUID's 128 bit value.
     */
    val leastSignificantBits: Long
        get() = uuid.leastSignificantBits

    /**
     * Returns the most significant 64 bits of this UUID's 128 bit value.
     */
    val mostSignificantBits: Long
        get() = uuid.mostSignificantBits

    /**
     * Retrieves the underlying [ByteArray] representing the 128-bit (16-byte) UUID value.
     */
    val bytes: ByteArray
        get() = uuid.bytes

    /**
     * The variant number of this [Uuid] instance. The [variant] describes the layout of the UUID:
     *
     * - **0** - Reserved for NCS backward compatibility and a null UUID
     * - **2** - Leach-Salz, as defined in [RFC 4122](https://tools.ietf.org/html/rfc4122) and used by this class
     * - **6** - Reserved, Microsoft Corporation backward compatibility
     * - **7** - Reserved for future definition
     */
    val variant: Int
        get() = uuid.variant

    /**
     * The version number of this [Uuid] instance. The [version] specifies how this UUID was generated:
     *
     * - **0** - Special case for a null UUID
     * - **1** - Time-based
     * - **2** - DCE Security
     * - **3** - Name-based using MD5 hashing
     * - **4** - Random or Pseudo-random
     * - **5** - Name-based using SHA-1 hashing
     * - **6-15** - Reserved for future definition
     *
     * Note that the version returned by this function is only meaningful if the [Uuid.variant] is
     * [RFC 4122](https://tools.ietf.org/html/rfc4122).
     */
    val version: Int
        get() = uuid.version

    override fun compareTo(other: Uuid): Int = uuid.compareTo(other.uuid)

    override fun equals(other: Any?): Boolean {
        if (other !is Uuid) return false

        return uuid == other.uuid
    }

    override fun hashCode(): Int = uuid.hashCode()

    /**
     * Converts this UUID to a UUID string, according to the [RFC-4122](https://www.rfc-editor.org/rfc/rfc4122)
     * specification.
     */
    override fun toString(): String = uuid.toString()

    companion object {

        /**
         * Creates a [Uuid] from the provided [String] [value] representation of a [Uuid].
         */
        @Suppress("RemoveRedundantQualifierName")
        fun from(value: String): Uuid =
            Uuid(com.benasher44.uuid.uuidFrom(value))

        /**
         * Creates a [Uuid] from the provided [ByteArray] [value] representation of a [Uuid].
         *
         * @throws [IllegalArgumentException] if the provided [ByteArray.count] value does not equal 16.
         */
        @Suppress("RemoveRedundantQualifierName")
        fun from(value: ByteArray): Uuid =
            Uuid(com.benasher44.uuid.uuidOf(value))

        /**
         * Creates a [Uuid] from the provided [mostSignificantBits] and [leastSignificantBits] values which are the
         * most significant and least significant bits of a [Uuid], which together represent the full 128-bits of a
         * UUID.
         */
        @Suppress("RemoveRedundantQualifierName")
        fun from(mostSignificantBits: Long, leastSignificantBits: Long): Uuid =
            Uuid(com.benasher44.uuid.Uuid(mostSignificantBits, leastSignificantBits))
    }
}
