@file:Suppress("unused")

package com.chrynan.krypt.encoding

import okio.ByteString.Companion.decodeBase64

/**
 * A Base64 [Decoder].
 *
 * @see [Wikipedia explanation](https://en.wikipedia.org/wiki/Base64)
 */
// TODO: Replace implementation with new Kotlin Base64 utils.
interface Base64Decoder : Decoder,
    ByteStringDecoder {

    /**
     * The [Base64Type] of decoding this decoder performs.
     */
    val type: Base64Type

    /**
     * Converts a Base64 encoded [String] into a [ByteArray] representation.
     */
    fun decodeToByteArray(source: String): ByteArray = decodeToByteArray(source = source.toUtf8ByteArray())

    /**
     * Converts a Base64 encoded [String] into a UTF-8 character encoded [String] representation.
     */
    fun decodeToString(source: String): String = decodeToString(source = source.toUtf8ByteArray())
}

/**
 * Creates a [Base64Decoder] with the [Base64Type.DEFAULT] type.
 */
@Suppress("FunctionName")
fun Base64Decoder(isWithPadding: Boolean = true): Base64Decoder =
    Base64Decoder(type = Base64Type.DEFAULT, isWithPadding = isWithPadding)

/**
 * Creates a [Base64Decoder] with the [Base64Type.URL] type.
 */
@Suppress("FunctionName")
fun Base64UrlDecoder(isWithPadding: Boolean = true): Base64Decoder =
    Base64Decoder(type = Base64Type.URL, isWithPadding = isWithPadding)

/**
 * Creates a [Base64Decoder] with the [Base64Type.MIME] type.
 */
@Suppress("FunctionName")
fun Base64MimeDecoder(isWithPadding: Boolean = true): Base64Decoder =
    Base64Decoder(type = Base64Type.MIME, isWithPadding = isWithPadding)

fun Base64Decoder(
    type: Base64Type = Base64Type.DEFAULT,
    isWithPadding: Boolean = true
): Base64Decoder = OkioBase64Decoder(type = type)

/**
 * A multiplatform [Base64Decoder] that uses okio utilities to perform the decoding.
 *
 * If there is platform specific support for Base64, prefer that utility.
 */
internal class OkioBase64Decoder(
    override val type: Base64Type
) : Base64Decoder {

    override fun decodeToByteArray(source: ByteArray): ByteArray =
        source.decodeToString().decodeBase64()!!.utf8().encodeToByteArray()

    override fun decodeToString(source: ByteArray): String =
        source.decodeToString().decodeBase64()!!.utf8()
}
