package com.chrynan.krypt.hash.sha

import com.chrynan.krypt.encoding.encodeToHexString
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SHA224And256HashFunctionTest {

    @Test
    fun only224And256AlgorithmsSupported() {
        // Should fail
        assertFailsWith<IllegalArgumentException> {
            SHA224And256HashFunction(algorithm = SHA2HashFunction.SupportedAlgorithm.Sha384)
        }
        assertFailsWith<IllegalArgumentException> {
            SHA224And256HashFunction(algorithm = SHA2HashFunction.SupportedAlgorithm.Sha512)
        }

        // Does not fail
        SHA224And256HashFunction(algorithm = SHA2HashFunction.SupportedAlgorithm.Sha224)
        SHA224And256HashFunction(algorithm = SHA2HashFunction.SupportedAlgorithm.Sha256)
    }

    @Test
    fun sha256ReturnsExpectedResult() = runTest {
        val hashFunction = SHA2HashFunction(algorithm = SHA2HashFunction.SupportedAlgorithm.Sha256)

        val message = "Testing123".encodeToByteArray()

        val result = hashFunction.invoke(source = message)

        val expectedResult = "0218b3506b9b9de4fd357c0865a393471b73fc5ea972c5731219cfae32cee483"

        assertEquals(
            expected = expectedResult,
            actual = result.encodeToHexString(lowercase = true)
        )
    }
}
