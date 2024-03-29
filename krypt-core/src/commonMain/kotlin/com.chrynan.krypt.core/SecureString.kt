@file:Suppress("unused")

package com.chrynan.krypt.core

import kotlin.jvm.Synchronized

/**
 * More secure implementation of [CharSequence] than [String], attempting to prevent heap memory attacks.
 *
 * This implementation was inspired by the following:
 * https://github.com/Password4j/password4j/blob/master/src/main/java/com/password4j/SecureString.java
 */
class SecureString(
    chars: CharArray = charArrayOf(),
    eraseSource: Boolean = true
) : RedactedProperty<Unit>(),
    CharSequence {

    // Deliberately [Unit] so we don't expose the [CharArray] accidentally.
    override val value: Unit = Unit

    override val length: Int
        @Synchronized
        get() = chars.size

    private val chars: CharArray

    init {
        this.chars = CharArray(chars.size)

        chars.copyInto(destination = this.chars, destinationOffset = 0, startIndex = 0, endIndex = chars.size)

        if (eraseSource) {
            chars.clear()
        }
    }

    @Synchronized
    override operator fun get(index: Int): Char = chars[index]

    @Synchronized
    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
        require(startIndex in chars.indices) { "startIndex must be within the CharSequence indices range." }
        require(endIndex <= chars.size) { "endIndex must be less than or equal to the CharSequence size." }
        require(startIndex < endIndex) { "startIndex must be less than endIndex in subSequence function." }

        val newCharArray = CharArray(endIndex - startIndex)

        for (i in startIndex..endIndex) {
            newCharArray[i] = chars[i]
        }

        return SecureString(chars = newCharArray, eraseSource = true)
    }

    @Synchronized
    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is CharSequence) return false

        if (chars.size != other.length) return false

        var equals = 0
        for (i in chars.indices) {
            equals = equals or (chars[i].code xor other[i].code)
        }

        return equals == 0
    }

    @Synchronized
    override fun hashCode(): Int {
        var result = 1
        for (element in chars) {
            val elementHash = (element.code xor (element.code ushr 32))
            result = 31 * result + elementHash
        }

        return result
    }

    operator fun plus(other: SecureString): SecureString {
        val charArray = CharArray(this.length + other.length)

        for (i in 0 until this.length) {
            charArray[i] = this.chars[i]
        }

        for (i in 0 until other.length) {
            charArray[i + this.length] = other.chars[i]
        }

        return SecureString(chars = chars, eraseSource = true)
    }

    @Synchronized
    fun clear() = chars.clear()

    fun toInsecureString(): String = chars.concatToString()

    private fun CharArray.clear(char: Char = Char.MIN_VALUE) {
        for (i in indices) {
            this[i] = char
        }
    }

    companion object
}

fun CharArray.toSecureString(eraseSource: Boolean = true): SecureString =
    SecureString(chars = this, eraseSource = eraseSource)

fun CharSequence.toSecureString(): SecureString {
    val tempCharArray = CharArray(this.length)

    this.forEachIndexed { index, char ->
        tempCharArray[index] = char
    }

    return SecureString(chars = tempCharArray, eraseSource = true)
}

operator fun SecureString.Companion.invoke(charSequence: CharSequence): SecureString =
    charSequence.toSecureString()

operator fun SecureString.plus(other: CharSequence): SecureString {
    val otherSecureString = other.toSecureString()

    val result = this + otherSecureString

    otherSecureString.clear()

    return result
}
