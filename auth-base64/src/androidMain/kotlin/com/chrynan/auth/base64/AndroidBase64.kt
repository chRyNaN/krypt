@file:Suppress("unused")

package com.chrynan.auth.base64

import android.annotation.TargetApi
import android.os.Build
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

fun Base64Decoder(type: Base64Type, charset: Charset): Base64Decoder =
    JvmBase64Decoder(type = type, isWithPadding = false, charset = charset)

internal class JvmBase64Encoder(
    override val type: Base64Type,
    isWithPadding: Boolean,
    private val charset: Charset = Charsets.UTF_8
) : Base64Encoder {

    @TargetApi(Build.VERSION_CODES.O)
    private val encoder: Base64.Encoder = when {
        type == Base64Type.DEFAULT && isWithPadding -> Base64.getEncoder()
        type == Base64Type.DEFAULT && !isWithPadding -> Base64.getEncoder().withoutPadding()
        type == Base64Type.URL && isWithPadding -> Base64.getUrlEncoder()
        type == Base64Type.URL && !isWithPadding -> Base64.getUrlEncoder().withoutPadding()
        type == Base64Type.MIME && isWithPadding -> Base64.getMimeEncoder()
        type == Base64Type.MIME && !isWithPadding -> Base64.getMimeEncoder().withoutPadding()
        else -> Base64.getEncoder()
    }

    private val androidBase64Type: Int = type.toAndroidType(isWithPadding = isWithPadding)

    override fun encode(source: ByteArray): ByteArray =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            encoder.encode(source)
        } else {
            android.util.Base64.encode(source, androidBase64Type)
        }

    override fun encode(source: String): ByteArray = encode(source = source.toByteArray(charset))

    override fun encodeToString(source: ByteArray): String =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            encoder.encodeToString(source)
        } else {
            android.util.Base64.encodeToString(source, androidBase64Type)
        }

    override fun encodeToString(source: String): String = encodeToString(source = source.toByteArray(charset))
}

internal class JvmBase64Decoder(
    override val type: Base64Type,
    isWithPadding: Boolean,
    private val charset: Charset = Charsets.UTF_8
) : Base64Decoder {

    @TargetApi(Build.VERSION_CODES.O)
    private val decoder: Base64.Decoder = when (type) {
        Base64Type.DEFAULT -> Base64.getDecoder()
        Base64Type.URL -> Base64.getUrlDecoder()
        Base64Type.MIME -> Base64.getMimeDecoder()
    }

    private val androidBase64Type: Int = type.toAndroidType(isWithPadding = isWithPadding)

    override fun decode(source: ByteArray): ByteArray =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            decoder.decode(source)
        } else {
            android.util.Base64.decode(source, androidBase64Type)
        }

    override fun decode(source: String): ByteArray = decode(source = source.toByteArray(charset))

    override fun decodeToString(source: ByteArray): String =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            decoder.decode(source).decodeToString()
        } else {
            android.util.Base64.decode(source, androidBase64Type).toString()
        }

    override fun decodeToString(source: String): String = decodeToString(source = source.toByteArray(charset))
}

private fun Base64Type.toAndroidType(isWithPadding: Boolean = true): Int =
    when {
        !isWithPadding -> android.util.Base64.NO_PADDING
        this == Base64Type.URL -> android.util.Base64.URL_SAFE
        else -> android.util.Base64.DEFAULT
    }
