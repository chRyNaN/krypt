@file:Suppress("unused")

package com.chrynan.krypt.encoding

/**
 * A [Decoder] that decodes a hexadecimal formatted [String] value into a [ByteArray]. Use the [decodeToByteArray]
 * function for proper decoding.
 */
class HexDecoder : Decoder {

    override fun decodeToByteArray(source: ByteArray): ByteArray =
        // FIXME: not sure if this works. Might lose value when encoding from String to ByteArray and back to String for hexadecimal String.
        source.decodeToString()
            .chunked(2)
            .map { it.toInt(16).toByte() }
            .toByteArray()

    override fun decodeToString(source: ByteArray): String =
        throw UnsupportedOperationException("A hexadecimal ByteArray cannot be decoded into a String. Use the decodeToByteArray function instead.\nBytes are not equivalent to hexadecimal values. An encoded hexadecimal value would be a String.")

    @Suppress("MemberVisibilityCanBePrivate")
    fun decodeToByteArray(source: String): ByteArray {
        require(source.length % 2 == 0) { "Invalid hexadecimal String. Cannot convert to a ByteArray." }

        return source.chunked(2)
            .map { it.toInt(16).toByte() }
            .toByteArray()
    }
}

private val hexDecoder = HexDecoder()

/**
 * Decodes the hexadecimal values within this [String] into a [ByteArray]. This is a shortcut function for using a
 * [HexDecoder]. This is a convenience since the [HexDecoder.decodeToString] function is not supported and this
 * helps prevent improper usage of a [HexDecoder].
 *
 * @see [HexDecoder]
 */
fun String.decodeHexToByteArray(): ByteArray =
    hexDecoder.decodeToByteArray(source = this)
