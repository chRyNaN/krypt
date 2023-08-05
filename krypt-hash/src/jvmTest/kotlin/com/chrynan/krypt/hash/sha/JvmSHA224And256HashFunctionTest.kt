package com.chrynan.krypt.hash.sha

import com.chrynan.krypt.core.hash
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.security.MessageDigest
import kotlin.random.Random
import kotlin.test.assertContentEquals

private const val ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
private val ALPHA_NUMERIC_CHARS = ALPHA_NUMERIC_STRING.toCharArray()

class JvmSHA224And256HashFunctionTest {

    private val javaSha256 = MessageDigest.getInstance("SHA-256")
    private val kotlinSha256 = SHA224And256HashFunction(algorithm = SHA2HashFunction.SupportedAlgorithm.Sha256)

    @Test
    @ExperimentalCoroutinesApi
    fun randomShortWordForSHA256MatchesJava() = runTest {
        val string = randomString(length = 4)
        val message = string.encodeToByteArray()

        val expected = javaSha256.digest(message)
        val actual = kotlinSha256.hash(message)

        assertContentEquals(expected = expected, actual = actual)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun randomMediumWordForSHA256MatchesJava() = runTest {
        val string = randomString(length = 10)
        val message = string.encodeToByteArray()

        val expected = javaSha256.digest(message)
        val actual = kotlinSha256.hash(message)

        assertContentEquals(expected = expected, actual = actual)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun randomLongWordForSHA256MatchesJava() = runTest {
        val string = randomString(length = 50)
        val message = string.encodeToByteArray()

        val expected = javaSha256.digest(message)
        val actual = kotlinSha256.hash(message)

        assertContentEquals(expected = expected, actual = actual)
    }

    private fun randomString(length: Int): String {
        val charArray = CharArray(length)

        for (i in 0 until length) {
            charArray[i] = ALPHA_NUMERIC_CHARS[Random.nextInt(ALPHA_NUMERIC_CHARS.size)]
        }

        return charArray.concatToString()
    }
}
