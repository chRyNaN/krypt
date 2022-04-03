@file:Suppress("unused")

package com.chrynan.krypt.encoding

import android.annotation.TargetApi
import android.os.Build
import java.nio.charset.Charset
import java.util.*

internal actual fun Base64Decoder(type: Base64Type, isWithPadding: Boolean): Base64Decoder =
    AndroidBase64Decoder(type = type, isWithPadding = isWithPadding)

fun Base64Decoder(type: Base64Type, charset: Charset): Base64Decoder =
    AndroidBase64Decoder(type = type, isWithPadding = false, charset = charset)

internal class AndroidBase64Decoder(
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

    override fun decodeToByteArray(source: ByteArray): ByteArray =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            decoder.decode(source)
        } else {
            android.util.Base64.decode(source, androidBase64Type)
        }

    override fun decodeToByteArray(source: String): ByteArray = decodeToByteArray(source = source.toByteArray(charset))

    override fun decodeToString(source: ByteArray): String =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            decoder.decode(source).decodeToString()
        } else {
            android.util.Base64.decode(source, androidBase64Type).toString()
        }

    override fun decodeToString(source: String): String = decodeToString(source = source.toByteArray(charset))
}
