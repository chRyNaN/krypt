@file:Suppress("unused")

package com.chrynan.krypt.encoding

/**
 * An [Encoder] that encodes a [ByteArray] into a bit [String] value. For example: "11111111 00000000".
 *
 * @property [byteGroupSeparator] The [String] value used to separate every 8 bits. Defaults to a single space: " ".
 * @property [convertToUByte] Whether each [Byte] value in the [ByteArray] should first be converted to a [UByte].
 * Defaults to `false`.
 * @property [padWithZeros] Whether padding with zeros should be applied for each [Byte] in the bit [String], so that
 * it properly displays all 8 bits in a byte. Defaults to `true`.
 * @property [removeSign] Whether to remove the sign character, such as a minus sign, for each [Byte] in the bit
 * [String]. Defaults to `true`.
 */
class BitEncoder(
    private val byteGroupSeparator: String = " ",
    private val convertToUByte: Boolean = false,
    private val padWithZeros: Boolean = true,
    private val removeSign: Boolean = true
) : Encoder {

    override fun encodeToByteArray(source: ByteArray): ByteArray =
        throw UnsupportedOperationException("A ByteArray cannot be converted into a bit ByteArray. Use the encodeToString function instead to create a bit String.")

    override fun encodeToString(source: ByteArray): String {
        val bitset = mutableListOf<String>()

        source.forEachIndexed { index, byte ->
            if (index != 0) {
                bitset.add(byteGroupSeparator)
            }

            var value = if (convertToUByte) {
                byte.toUByte().toString(radix = 2)
            } else {
                byte.toString(radix = 2)
            }

            if (removeSign && (value.startsWith('-') || (value.startsWith('+')))) {
                value = value.drop(1)
            }

            if (padWithZeros) {
                val diff = 8 - value.length

                if (diff > 0) {
                    val sb = StringBuilder()

                    CharArray(diff) { '0' }.forEach {
                        sb.append(it)
                    }

                    value = if (value.startsWith('-') || value.startsWith('+')) {
                        val sign = value.first()

                        sign + sb.toString() + value.drop(1)
                    } else {
                        sb.toString() + value
                    }
                }
            }

            bitset.add(value.trim())
        }

        return bitset.joinToString(separator = "") { it }
    }
}

/**
 * Encodes the values within this [ByteArray] into a bit [String]. This is a convenience function for using a
 * [BitEncoder].
 *
 * @see [BitEncoder]
 */
fun ByteArray.encodeToBitString(
    byteGroupSeparator: String = " ",
    convertToUByte: Boolean = false,
    padWithZeros: Boolean = true,
    removeSign: Boolean = true
): String {
    val decoder = BitEncoder(
        byteGroupSeparator = byteGroupSeparator,
        convertToUByte = convertToUByte,
        padWithZeros = padWithZeros,
        removeSign = removeSign
    )

    return decoder.encodeToString(source = this)
}
