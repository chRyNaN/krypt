@file:Suppress("unused")

package com.chrynan.auth.hash

interface HashAlgorithm {

    val name: String
    val version: String

    fun isCompatible(other: HashAlgorithm): Boolean =
        name == other.name && version == other.version
}
