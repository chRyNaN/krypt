@file:Suppress("unused")

package com.chrynan.krypt.encoding

import okio.ByteString
import okio.ByteString.Companion.decodeBase64

interface Base64Decoder {

    val type: Base64Type

    fun decode(source: ByteArray): ByteArray

    fun decode(source: String): ByteArray = decode(source = source.toUtf8ByteArray())

    fun decode(source: ByteString): ByteArray = decode(source = source.toByteArray())

    fun decodeToString(source: ByteArray): String

    fun decodeToString(source: String): String = decodeToString(source = source.toUtf8ByteArray())

    fun decodeToString(source: ByteString): String = decodeToString(source = source.toByteArray())
}

@Suppress("FunctionName")
fun Base64Decoder(isWithPadding: Boolean = true): Base64Decoder =
    Base64Decoder(type = Base64Type.DEFAULT, isWithPadding = isWithPadding)

@Suppress("FunctionName")
fun Base64UrlDecoder(isWithPadding: Boolean = true): Base64Decoder =
    Base64Decoder(type = Base64Type.URL, isWithPadding = isWithPadding)

@Suppress("FunctionName")
fun Base64MimeDecoder(isWithPadding: Boolean = true): Base64Decoder =
    Base64Decoder(type = Base64Type.MIME, isWithPadding = isWithPadding)

internal expect fun Base64Decoder(
    type: Base64Type = Base64Type.DEFAULT,
    isWithPadding: Boolean = true
): Base64Decoder

internal class OkioBase64Decoder(
    override val type: Base64Type
) : Base64Decoder {

    override fun decode(source: ByteArray): ByteArray =
        source.decodeToString().decodeBase64()!!.utf8().encodeToByteArray()

    override fun decodeToString(source: ByteArray): String =
        source.decodeToString().decodeBase64()!!.utf8()
}
