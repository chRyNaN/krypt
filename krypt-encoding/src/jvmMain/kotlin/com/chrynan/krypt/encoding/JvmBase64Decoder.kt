@file:Suppress("unused")

package com.chrynan.krypt.encoding

import java.nio.charset.Charset
import java.util.*

internal actual fun Base64Decoder(type: Base64Type, isWithPadding: Boolean): Base64Decoder =
    JvmBase64Decoder(type = type, isWithPadding = isWithPadding)

fun Base64Decoder(type: Base64Type, isWithPadding: Boolean = true, charset: Charset): Base64Decoder =
    JvmBase64Decoder(type = type, isWithPadding = isWithPadding, charset = charset)

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
