@file:Suppress("unused")

package com.chrynan.krypt.encoding

/**
 * An [Encoder] that encodes a [ByteArray] into a hexadecimal [String] value.
 *
 * @property [lowercase] Whether the output of the [encodeToString] function should encode the characters to lowercase
 * values or not. The default is `false`. A value of `true`, will result in lowercase character values. A value of
 * `false` will result in uppercase character values.
 */
class HexEncoder(
    private val lowercase: Boolean = false
) : Encoder {

    override fun encodeToByteArray(source: ByteArray): ByteArray =
        throw UnsupportedOperationException("A ByteArray cannot be encoded into a hexadecimal ByteArray. Use the encodeToString function instead.\nBytes are not equivalent to hexadecimal values. An encoded hexadecimal value would be a String.")

    override fun encodeToString(source: ByteArray): String {
        val hexChars = CharArray(source.size * 2)

        for (i in source.indices) {
            val v = source[i].toInt() and 0xFF

            hexChars[i * 2] = HEX_ARRAY[v ushr 4]
            hexChars[i * 2 + 1] = HEX_ARRAY[v and 0x0F]
        }

        return if (lowercase) {
            hexChars.concatToString().lowercase()
        } else {
            hexChars.concatToString()
        }
    }

    companion object {

        private val HEX_ARRAY = "0123456789ABCDEF".toCharArray()
    }
}

private val lowercaseHexEncoder = HexEncoder(lowercase = true)
private val uppercaseHexEncoder = HexEncoder(lowercase = false)

/**
 * Encodes the values within this [ByteArray] into a hexadecimal [String]. This is a convenience function for using a
 * [HexEncoder].
 *
 * @see [HexEncoder]
 */
fun ByteArray.encodeToHexString(lowercase: Boolean = false): String =
    if (lowercase) {
        lowercaseHexEncoder.encodeToString(source = this)
    } else {
        uppercaseHexEncoder.encodeToString(source = this)
    }
