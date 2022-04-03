@file:Suppress("unused")

package com.chrynan.krypt.encoding

import okio.ByteString
import okio.ByteString.Companion.toByteString

interface Base64Encoder {

    val type: Base64Type

    fun encode(source: ByteArray): ByteArray

    fun encode(source: String): ByteArray = encode(source = source.toUtf8ByteArray())

    fun encode(source: ByteString): ByteArray = encode(source = source.toByteArray())

    fun encodeToString(source: ByteArray): String

    fun encodeToString(source: String): String = encodeToString(source = source.toUtf8ByteArray())

    fun encodeToString(source: ByteString): String = encodeToString(source = source.toByteArray())
}

@Suppress("FunctionName")
fun Base64Encoder(isWithPadding: Boolean = true): Base64Encoder =
    Base64Encoder(type = Base64Type.DEFAULT, isWithPadding = isWithPadding)

@Suppress("FunctionName")
fun Base64UrlEncoder(isWithPadding: Boolean = true): Base64Encoder =
    Base64Encoder(type = Base64Type.URL, isWithPadding = isWithPadding)

@Suppress("FunctionName")
fun Base64MimeEncoder(isWithPadding: Boolean = true): Base64Encoder =
    Base64Encoder(type = Base64Type.MIME, isWithPadding = isWithPadding)

internal expect fun Base64Encoder(
    type: Base64Type = Base64Type.DEFAULT,
    isWithPadding: Boolean = true
): Base64Encoder

internal class OkioBase64Encoder(
    override val type: Base64Type
) : Base64Encoder {

    override fun encode(source: ByteArray): ByteArray {
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
