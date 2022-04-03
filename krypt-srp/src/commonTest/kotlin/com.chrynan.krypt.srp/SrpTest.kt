package com.chrynan.krypt.srp

import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.*

@OptIn(ExperimentalUnsignedTypes::class, ExperimentalCoroutinesApi::class)
class SrpTest {

    @Test
    fun calculateX_returns_expected_result() = runTest {
        val salt = ubyteArrayOf(0u, 1u, 2u, 3u, 4u, 5u, 6u, 7u)
        val identifier = "email@example.com"
        val secret = "password"
        val secretHash = "$identifier:$secret".encodeToUByteArray()
        val expectedHash = salt + secretHash
        val expectedResult = expectedHash.toBigInteger()

        val actualResult = calculateX(hash = NO_OP_HASH_FUNCTION, salt = salt, identifier = identifier, secret = secret)

        assertEquals(expected = expectedResult, actual = actualResult)
    }

    @Test
    fun calculateX_returns_expected_result_with_reversed_hash_function() = runTest {
        val salt = ubyteArrayOf(0u, 1u, 2u, 3u, 4u, 5u, 6u, 7u)
        val identifier = "email@example.com"
        val secret = "password"
        val secretHash = ("$identifier:$secret".encodeToUByteArray()).reversedArray()
        val expectedHash = (salt + secretHash).reversedArray()
        val expectedResult = expectedHash.toBigInteger()

        val actualResult =
            calculateX(hash = REVERSE_HASH_FUNCTION, salt = salt, identifier = identifier, secret = secret)

        assertEquals(expected = expectedResult, actual = actualResult)
    }

    @Test
    fun calculateV_returns_expected_result() = runTest {
        var result = calculateV(group = Group.N2048, x = BigInteger.ZERO)
        var expectedResult = Group.N2048.g.pow(BigInteger.ZERO).mod(Group.N2048.N)

        assertEquals(expected = expectedResult, actual = result)

        result = calculateV(group = Group.N2048, x = BigInteger.ONE)
        expectedResult = Group.N2048.g.pow(BigInteger.ONE).mod(Group.N2048.N)

        assertEquals(expected = expectedResult, actual = result)

        result = calculateV(group = Group.N2048, x = BigInteger.TWO)
        expectedResult = Group.N2048.g.pow(BigInteger.TWO).mod(Group.N2048.N)

        assertEquals(expected = expectedResult, actual = result)

        result = calculateV(group = Group.N2048, x = BigInteger.TEN)
        expectedResult = Group.N2048.g.pow(BigInteger.TEN).mod(Group.N2048.N)

        assertEquals(expected = expectedResult, actual = result)
    }

    @Test
    fun calculateK_returns_expected_result() = runTest {
        val expectedResult = (Group.N2048.N.toUByteArray() + pad(
            Group.N2048.g.toUByteArray(),
            Group.N2048.N.toUByteArray().size
        )).toBigInteger()
        val result = calculateK(hash = NO_OP_HASH_FUNCTION, group = Group.N2048)

        assertEquals(expected = expectedResult, actual = result)
    }

    @Test
    fun calculateA_returns_expected_result() = runTest {
        var expectedResult = Group.N2048.g.pow(BigInteger.ZERO).mod(Group.N2048.N)
        var result = calculateA(group = Group.N2048, a = BigInteger.ZERO)

        assertEquals(expected = expectedResult, actual = result)

        expectedResult = Group.N2048.g.pow(BigInteger.ONE).mod(Group.N2048.N)
        result = calculateA(group = Group.N2048, a = BigInteger.ONE)

        assertEquals(expected = expectedResult, actual = result)

        expectedResult = Group.N2048.g.pow(BigInteger.TWO).mod(Group.N2048.N)
        result = calculateA(group = Group.N2048, a = BigInteger.TWO)

        assertEquals(expected = expectedResult, actual = result)

        expectedResult = Group.N2048.g.pow(BigInteger.TEN).mod(Group.N2048.N)
        result = calculateA(group = Group.N2048, a = BigInteger.TEN)

        assertEquals(expected = expectedResult, actual = result)
    }

    @Test
    fun calculateB_returns_expected_result() = runTest {
        val expectedResult =
            ((BigInteger.ONE * BigInteger.TWO) + Group.N2048.g.pow(BigInteger.TEN).mod(Group.N2048.N)) % Group.N2048.N
        val result = calculateB(group = Group.N2048, k = BigInteger.ONE, v = BigInteger.TWO, b = BigInteger.TEN)

        assertEquals(expected = expectedResult, actual = result)
    }

    @Test
    fun calculateSharedSessionKey_returns_expected_result() = runTest {
        var result = calculateSharedSessionKey(hash = NO_OP_HASH_FUNCTION, S = BigInteger.ZERO)

        assertContentEquals(expected = BigInteger.ZERO.toUByteArray(), actual = result)

        result = calculateSharedSessionKey(hash = NO_OP_HASH_FUNCTION, S = BigInteger.ONE)

        assertContentEquals(expected = BigInteger.ONE.toUByteArray(), actual = result)

        result = calculateSharedSessionKey(hash = NO_OP_HASH_FUNCTION, S = BigInteger.TWO)

        assertContentEquals(expected = BigInteger.TWO.toUByteArray(), actual = result)

        result = calculateSharedSessionKey(hash = NO_OP_HASH_FUNCTION, S = BigInteger.TEN)

        assertContentEquals(expected = BigInteger.TEN.toUByteArray(), actual = result)
    }

    @Test
    fun pad_fails_for_size_less_than_array_size() {
        val array = ubyteArrayOf(0u, 1u) // Size of 2

        var exception: Exception? = null
        try {
            pad(array = array, size = 1)
        } catch (e: Exception) {
            exception = e
        }

        assertNotNull(actual = exception)
    }

    @Test
    fun pad_succeeds_for_size_equal_to_array_size() {
        val array = ubyteArrayOf(0u, 1u) // Size of 2

        var exception: Exception? = null
        try {
            pad(array = array, size = 2)
        } catch (e: Exception) {
            exception = e
        }

        assertNull(actual = exception)
    }

    @Test
    fun pad_succeeds_for_size_greater_than_array_size() {
        val array = ubyteArrayOf(0u, 1u) // Size of 2

        var exception: Exception? = null
        try {
            pad(array = array, size = 2)
        } catch (e: Exception) {
            exception = e
        }

        assertNull(actual = exception)
    }

    @Test
    fun pad_returns_expected_result() {
        val array = ubyteArrayOf(0u, 1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u)

        val result = pad(array = array, size = 20)

        assertEquals(expected = 20, actual = result.size)

        val expectedResult =
            ubyteArrayOf(0u, 0u, 0u, 0u, 0u, 0u, 0u, 0u, 0u, 0u, 1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u)

        assertContentEquals(expected = expectedResult, actual = result)
    }

    companion object {

        @ExperimentalUnsignedTypes
        val NO_OP_HASH_FUNCTION = object : SrpHashFunction {

            override suspend fun invoke(source: UByteArray): UByteArray = source
        }

        @ExperimentalUnsignedTypes
        val REVERSE_HASH_FUNCTION = object : SrpHashFunction {

            override suspend fun invoke(source: UByteArray): UByteArray = source.reversedArray()
        }
    }
}
