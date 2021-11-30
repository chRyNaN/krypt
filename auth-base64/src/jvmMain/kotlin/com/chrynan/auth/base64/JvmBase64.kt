@file:Suppress("unused")

package com.chrynan.auth.base64

import java.nio.charset.Charset
import java.util.*

internal actual fun Base64Encoder(
    type: Base64Type,
    isWithPadding: Boolean
): Base64Encoder = JvmBase64Encoder(type = type, isWithPadding = isWithPadding)

internal actual fun Base64Decoder(type: Base64Type, isWithPadding: Boolean): Base64Decoder =
    JvmBase64Decoder(type = type, isWithPadding = isWithPadding)

fun Base64Encoder(
    type: Base64Type,
    isWithPadding: Boolean,
    charset: Charset
): Base64Encoder = JvmBase64Encoder(type = type, isWithPadding = isWithPadding, charset = charset)

fun Base64Decoder(type: Base64Type, isWithPadding: Boolean = true, charset: Charset): Base64Decoder =
    JvmBase64Decoder(type = type, isWithPadding = isWithPadding, charset = charset)

internal class JvmBase64Encoder(
    override val type: Base64Type,
    isWithPadding: Boolean,
    private val charset: Charset = Charsets.UTF_8
) : Base64Encoder {

    private val encoder: Base64.Encoder = when {
        type == Base64Type.DEFAULT && isWithPadding -> Base64.getEncoder()
        type == Base64Type.DEFAULT && !isWithPadding -> Base64.getEncoder().withoutPadding()
        type == Base64Type.URL && isWithPadding -> Base64.getUrlEncoder()
        type == Base64Type.URL && !isWithPadding -> Base64.getUrlEncoder().withoutPadding()
        type == Base64Type.MIME && isWithPadding -> Base64.getMimeEncoder()
        type == Base64Type.MIME && !isWithPadding -> Base64.getMimeEncoder().withoutPadding()
        else -> Base64.getEncoder()
    }

    override fun encode(source: ByteArray): ByteArray = encoder.encode(source)

    override fun encode(source: String): ByteArray = encode(source = source.toByteArray(charset))

    override fun encodeToString(source: ByteArray): String = encoder.encodeToString(source)

    override fun encodeToString(source: String): String = encodeToString(source = source.toByteArray(charset))
}

internal class JvmBase64Decoder(
    override val type: Base64Type,
    @Suppress("UNUSED_PARAMETER") isWithPadding: Boolean,
    private val charset: Charset = Charsets.UTF_8
) : Base64Decoder {

    private val decoder: Base64.Decoder = when (type) {
        Base64Type.DEFAULT -> Base64.getDecoder()
        Base64Type.URL -> Base64.getUrlDecoder()
        Base64Type.MIME -> Base64.getMimeDecoder()
    }

    override fun decode(source: ByteArray): ByteArray = decoder.decode(source)

    override fun decode(source: String): ByteArray = decode(source = source.toByteArray(charset))

    override fun decodeToString(source: ByteArray): String = decoder.decode(source).decodeToString()

    override fun decodeToString(source: String): String = decodeToString(source = source.toByteArray(charset))
}
