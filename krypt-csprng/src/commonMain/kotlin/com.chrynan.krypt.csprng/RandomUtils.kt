@file:Suppress("unused")

package com.chrynan.krypt.csprng

import kotlin.random.Random

private const val ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
internal val ALPHA_NUMERIC_CHARS = ALPHA_NUMERIC_STRING.toCharArray()

/**
 * Gets the next random [Char] from the provided supported [characters].
 */
fun Random.nextChar(characters: CharArray = ALPHA_NUMERIC_CHARS): Char {
    val index = nextInt(characters.size)
    return characters[index]
}

/**
 * Gets the next random [CharArray] with the provided [length] and supported [characters].
 */
fun Random.nextCharArray(length: Int, characters: CharArray = ALPHA_NUMERIC_CHARS): CharArray {
    val charArray = CharArray(length)
    for (i in 0 until length) {
        charArray[i] = nextChar(characters = characters)
    }
    return charArray
}

/**
 * Gets the next random [String] with the provided [length] and supported [characters].
 */
fun Random.nextString(length: Int, characters: CharArray = ALPHA_NUMERIC_CHARS): String {
    val stringBuilder = StringBuilder()
    stringBuilder.append(nextCharArray(length = length, characters = characters).concatToString())
    return stringBuilder.toString()
}
