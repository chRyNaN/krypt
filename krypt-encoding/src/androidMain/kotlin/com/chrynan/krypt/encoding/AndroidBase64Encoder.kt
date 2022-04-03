@file:Suppress("unused")

package com.chrynan.krypt.encoding

import android.annotation.TargetApi
import android.os.Build
import java.nio.charset.Charset
import java.util.*

internal actual fun Base64Encoder(
    type: Base64Type,
    isWithPadding: Boolean
): Base64Encoder = AndroidBase64Encoder(type = type, isWithPadding = isWithPadding)

fun Base64Encoder(
    type: Base64Type,
    isWithPadding: Boolean,
    charset: Charset
): Base64Encoder = AndroidBase64Encoder(type = type, isWithPadding = isWithPadding, charset = charset)

internal class AndroidBase64Encoder(
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

    override fun encodeToByteArray(source: ByteArray): ByteArray =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            encoder.encode(source)
        } else {
            android.util.Base64.encode(source, androidBase64Type)
        }

    override fun encodeToByteArray(source: String): ByteArray = encodeToByteArray(source = source.toByteArray(charset))

    override fun encodeToString(source: ByteArray): String =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            encoder.encodeToString(source)
        } else {
            android.util.Base64.encodeToString(source, androidBase64Type)
        }

    override fun encodeToString(source: String): String = encodeToString(source = source.toByteArray(charset))
}
