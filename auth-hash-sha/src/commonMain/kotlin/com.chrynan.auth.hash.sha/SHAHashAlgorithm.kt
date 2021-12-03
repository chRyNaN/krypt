package com.chrynan.auth.hash.sha

import com.chrynan.auth.hash.HashAlgorithm

data class SHAHashAlgorithm internal constructor(
    val type: SHAType,
    val outputFormat: SHAOutputFormat = SHAOutputFormat.UTF_8,
    override val name: String = type.typeName,
    override val version: String = type.typeVersion.toString()
) : HashAlgorithm
