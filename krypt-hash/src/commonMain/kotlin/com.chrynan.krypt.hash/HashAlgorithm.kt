@file:Suppress("unused")

package com.chrynan.krypt.hash

/**
 * Defines the type of algorithm that is performed by a [Hasher].
 */
interface HashAlgorithm {

    /**
     * The [String] name of the algorithm.
     */
    val name: String

    /**
     * The [String] version of the algorithm.
     */
    val version: String

    /**
     * Determines whether this [HashAlgorithm] is compatible with the provided [other] [HashAlgorithm].
     *
     * The default implementation compares the [name] and [version] of the properties.
     */
    fun isCompatible(other: HashAlgorithm): Boolean =
        name == other.name && version == other.version
}
