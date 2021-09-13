@file:Suppress("unused")

package com.chrynan.auth.core

import okio.ByteString
import java.nio.charset.Charset
import java.security.SecureRandom

internal class JvmAlphaNumericKeyGenerator(
    bitCount: Int = 128,
    private val charset: Charset = Charsets.UTF_8
) : KeyGenerator {

    private val bytes = ByteArray(bitCount / 8)

    private val secureRandom = SecureRandom()

    override suspend fun generate(): String {
        secureRandom.nextBytes(bytes)
        val byteString = ByteString.of(*bytes)
        return byteString.string(charset)
    }
}

@Suppress("FunctionName")
actual fun AlphaNumericKeyGenerator(bitCount: Int): KeyGenerator = JvmAlphaNumericKeyGenerator(bitCount = bitCount)

@Suppress("FunctionName")
fun AlphaNumericKeyGenerator(bitCount: Int, charset: Charset): KeyGenerator =
    JvmAlphaNumericKeyGenerator(bitCount = bitCount, charset = charset)
