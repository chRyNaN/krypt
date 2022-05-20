package com.chrynan.krypt.hash.pbkdf

import com.chrynan.krypt.core.HashFunction

internal class PBKDF2HashFunction : HashFunction<ByteArray, ByteArray> {

    override val algorithmName: String?
        get() = TODO("Not yet implemented")

    override suspend fun invoke(source: ByteArray): ByteArray {
        TODO("Not yet implemented")
    }
}
