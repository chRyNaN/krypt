package com.chrynan.krypt.hash.sha

import com.chrynan.krypt.encoding.encodeToBitString
import com.chrynan.krypt.encoding.encodeToHexString
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SHA224And256HashFunctionTest {

    @Test
    fun only224And256AlgorithmsSupported() {
        // Should fail
        assertFailsWith<IllegalArgumentException> {
            SHA224And256HashFunction(algorithm = SHA2HashFunction.SupportedAlgorithm.SHA_384)
        }
        assertFailsWith<IllegalArgumentException> {
            SHA224And256HashFunction(algorithm = SHA2HashFunction.SupportedAlgorithm.SHA_512)
        }

        // Does not fail
        SHA224And256HashFunction(algorithm = SHA2HashFunction.SupportedAlgorithm.SHA_224)
        SHA224And256HashFunction(algorithm = SHA2HashFunction.SupportedAlgorithm.SHA_256)
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun sha256ReturnsExpectedResult() = runTest {
        val hashFunction = SHA2HashFunction(algorithm = SHA2HashFunction.SupportedAlgorithm.SHA_256)

        val message = "Testing123".encodeToByteArray()

        val result = hashFunction.invoke(source = message)

        val expectedResult = "0218b3506b9b9de4fd357c0865a393471b73fc5ea972c5731219cfae32cee483"
        val expectedResultBinary = "00000010 00011000 10110011 01010000 01101011 10011011 10011101 11100100 11111101 00110101 01111100 00001000 01100101 10100011 10010011 01000111 00011011 01110011 11111100 01011110 10101001 01110010 11000101 01110011 00010010 00011001 11001111 10101110 00110010 11001110 11100100 10000011"

        assertEquals(
            expected = expectedResult,
            actual = result.encodeToHexString(lowercase = true),
            message = """
                |
                |expected bytes: $expectedResultBinary
                |actual   bytes: ${result.encodeToBitString()}
                |
                |expected hex: $expectedResult
                |actual   hex: ${result.encodeToHexString(lowercase = true)}
                |
            """.trimMargin()
        )
    }
}
