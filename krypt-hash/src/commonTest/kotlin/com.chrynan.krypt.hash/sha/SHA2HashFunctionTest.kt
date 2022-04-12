package com.chrynan.krypt.hash.sha

import com.chrynan.krypt.encoding.HexEncoder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SHA2HashFunctionTest {

    private val hexEncoder = HexEncoder(lowercase = true)

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun sha256ReturnsExpectedResult() = runTest {
        val hashFunction = SHA2HashFunction(algorithm = SHA2HashFunction.SupportedAlgorithm.SHA_256)

        val message = "Testing123".encodeToByteArray()

        val result = hashFunction.invoke(source = message)

        val expectedResult = "0218b3506b9b9de4fd357c0865a393471b73fc5ea972c5731219cfae32cee483"

        assertEquals(expected = expectedResult, actual = hexEncoder.encodeToString(result))
    }
}
