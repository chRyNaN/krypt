@file:Suppress("unused")

package com.chrynan.auth.base64

import kotlinx.serialization.Serializable
import okio.ByteString
import okio.ByteString.Companion.decodeBase64
import okio.ByteString.Companion.encodeUtf8
import okio.ByteString.Companion.toByteString

internal expect fun Base64Encoder(
    type: Base64Type = Base64Type.DEFAULT,
    isWithPadding: Boolean = true
): Base64Encoder

internal expect fun Base64Decoder(
    type: Base64Type = Base64Type.DEFAULT,
    isWithPadding: Boolean = true
): Base64Decoder

internal fun String.toUtf8ByteArray(): ByteArray = encodeUtf8().toByteArray()

@Serializable
enum class Base64Type {

    DEFAULT,
    URL,
    MIME
}

interface Base64Encoder {

    val type: Base64Type

    fun encode(source: ByteArray): ByteArray

    fun encode(source: String): ByteArray = encode(source = source.toUtf8ByteArray())

    fun encode(source: ByteString): ByteArray = encode(source = source.toByteArray())

    fun encodeToString(source: ByteArray): String

    fun encodeToString(source: String): String = encodeToString(source = source.toUtf8ByteArray())

    fun encodeToString(source: ByteString): String = encodeToString(source = source.toByteArray())
}

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
fun Base64Encoder(isWithPadding: Boolean = true): Base64Encoder =
    Base64Encoder(type = Base64Type.DEFAULT, isWithPadding = isWithPadding)

@Suppress("FunctionName")
fun Base64UrlEncoder(isWithPadding: Boolean = true): Base64Encoder =
    Base64Encoder(type = Base64Type.URL, isWithPadding = isWithPadding)

@Suppress("FunctionName")
fun Base64MimeEncoder(isWithPadding: Boolean = true): Base64Encoder =
    Base64Encoder(type = Base64Type.MIME, isWithPadding = isWithPadding)

@Suppress("FunctionName")
fun Base64Decoder(isWithPadding: Boolean = true): Base64Decoder =
    Base64Decoder(type = Base64Type.DEFAULT, isWithPadding = isWithPadding)

@Suppress("FunctionName")
fun Base64UrlDecoder(isWithPadding: Boolean = true): Base64Decoder =
    Base64Decoder(type = Base64Type.URL, isWithPadding = isWithPadding)

@Suppress("FunctionName")
fun Base64MimeDecoder(isWithPadding: Boolean = true): Base64Decoder =
    Base64Decoder(type = Base64Type.MIME, isWithPadding = isWithPadding)

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

internal class OkioBase64Decoder(
    override val type: Base64Type
) : Base64Decoder {

    override fun decode(source: ByteArray): ByteArray =
        source.decodeToString().decodeBase64()!!.utf8().encodeToByteArray()

    override fun decodeToString(source: ByteArray): String =
        source.decodeToString().decodeBase64()!!.utf8()
}
