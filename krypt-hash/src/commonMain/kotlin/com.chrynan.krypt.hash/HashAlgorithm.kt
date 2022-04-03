@file:Suppress("unused")

package com.chrynan.krypt.hash

interface HashAlgorithm {

    val name: String
    val version: String

    fun isCompatible(other: HashAlgorithm): Boolean =
        name == other.name && version == other.version
}
