@file:Suppress("unused")

package com.chrynan.krypt.encoding

import okio.ByteString.Companion.toByteString

/**
 * A Base64 [Encoder].
 *
 * @see [Wikipedia explanation](https://en.wikipedia.org/wiki/Base64)
 */
interface Base64Encoder : Encoder,
    ByteStringEncoder {

    /**
     * The [Base64Type] of encoding this encoder performs.
     */
    val type: Base64Type

    /**
     * Converts a UTF-8 character encoded [String] into a Base64 [ByteArray] representation.
     */
    fun encodeToByteArray(source: String): ByteArray = encodeToByteArray(source = source.toUtf8ByteArray())

    /**
     * Converts a UTF-8 character encoded [String] into a Base64 [String] representation.
     */
    fun encodeToString(source: String): String = encodeToString(source = source.toUtf8ByteArray())
}

/**
 * Creates a [Base64Encoder] with the [Base64Type.DEFAULT] type.
 */
@Suppress("FunctionName")
fun Base64Encoder(isWithPadding: Boolean = true): Base64Encoder =
    Base64Encoder(type = Base64Type.DEFAULT, isWithPadding = isWithPadding)

/**
 * Creates a [Base64Encoder] with the [Base64Type.URL] type.
 */
@Suppress("FunctionName")
fun Base64UrlEncoder(isWithPadding: Boolean = true): Base64Encoder =
    Base64Encoder(type = Base64Type.URL, isWithPadding = isWithPadding)

/**
 * Creates a [Base64Encoder] with the [Base64Type.MIME] type.
 */
@Suppress("FunctionName")
fun Base64MimeEncoder(isWithPadding: Boolean = true): Base64Encoder =
    Base64Encoder(type = Base64Type.MIME, isWithPadding = isWithPadding)

internal expect fun Base64Encoder(
    type: Base64Type = Base64Type.DEFAULT,
    isWithPadding: Boolean = true
): Base64Encoder

/**
 * A multiplatform [Base64Encoder] that uses okio utilities to perform the encoding.
 *
 * If there is platform specific support for Base64, prefer that utility.
 */
internal class OkioBase64Encoder(
    override val type: Base64Type
) : Base64Encoder {

    override fun encodeToByteArray(source: ByteArray): ByteArray {
        val byteString = source.toByteString()

        return when (type) {
            Base64Type.DEFAULT -> byteString.base64().encodeToByteArray()
            Base64Type.URL -> byteString.base64Url().encodeToByteArray()
            Base64Type.MIME -> byteString.base64().encodeToByteArray()
        }
    }

    override fun encodeToString(source: ByteArray): String {
        val byteString = source.toByteString()

        return when (type) {
            Base64Type.DEFAULT -> byteString.base64()
            Base64Type.URL -> byteString.base64Url()
            Base64Type.MIME -> byteString.base64()
        }
    }
}
