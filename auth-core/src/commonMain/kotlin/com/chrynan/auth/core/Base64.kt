@file:Suppress("unused")

package com.chrynan.auth.core

import kotlinx.serialization.Serializable
import okio.ByteString

@Serializable
enum class Base64Type {

    DEFAULT,
    URL,
    MIME
}

interface Base64Encoder {

    fun encode(source: ByteArray): ByteArray

    fun encode(source: String): ByteArray = encode(source = source.toUtf8ByteArray())

    fun encode(source: ByteString): ByteArray = encode(source = source.toByteArray())

    fun encodeToString(source: ByteArray): String

    fun encodeToString(source: String): String = encodeToString(source = source.toUtf8ByteArray())

    fun encodeToString(source: ByteString): String = encodeToString(source = source.toByteArray())
}

expect fun Base64Encoder(
    type: Base64Type = Base64Type.DEFAULT,
    isWithPadding: Boolean = true
): Base64Encoder

interface Base64Decoder {

    fun decode(source: ByteArray): ByteArray

    fun decode(source: String): ByteArray = decode(source = source.toUtf8ByteArray())

    fun decode(source: ByteString): ByteArray = decode(source = source.toByteArray())

    fun decodeToString(source: ByteArray): String

    fun decodeToString(source: String): String = decodeToString(source = source.toUtf8ByteArray())

    fun decodeToString(source: ByteString): String = decodeToString(source = source.toByteArray())
}

expect fun Base64Decoder(
    type: Base64Type = Base64Type.DEFAULT
): Base64Decoder

fun String.encodeToBase64(
    type: Base64Type = Base64Type.DEFAULT,
    isWithPadding: Boolean = true
): ByteArray {
    val encoder = Base64Encoder(type = type, isWithPadding = isWithPadding)

    return encoder.encode(this)
}

fun String.encodeToBase64String(
    type: Base64Type = Base64Type.DEFAULT,
    isWithPadding: Boolean = true
): String {
    val encoder = Base64Encoder(type = type, isWithPadding = isWithPadding)

    return encoder.encodeToString(this)
}

fun String.decodeBase64(
    type: Base64Type = Base64Type.DEFAULT
): ByteArray {
    val decoder = Base64Decoder(type = type)

    return decoder.decode(this)
}

fun String.decodeBase64String(
    type: Base64Type = Base64Type.DEFAULT
): String {
    val decoder = Base64Decoder(type = type)

    return decoder.decodeToString(this)
}
