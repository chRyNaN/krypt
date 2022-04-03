package com.chrynan.krypt.hash.sha

import com.chrynan.krypt.hash.HashAlgorithm

data class SHAHashAlgorithm internal constructor(
    val type: SHAType,
    val outputFormat: SHAOutputFormat = SHAOutputFormat.UTF_8,
    override val name: String = type.typeName,
    override val version: String = type.typeVersion.toString()
) : HashAlgorithm
