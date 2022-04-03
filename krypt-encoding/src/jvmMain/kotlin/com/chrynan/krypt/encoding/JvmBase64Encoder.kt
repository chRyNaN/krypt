@file:Suppress("unused")

package com.chrynan.krypt.encoding

import java.nio.charset.Charset
import java.util.*

internal actual fun Base64Encoder(
    type: Base64Type,
    isWithPadding: Boolean
): Base64Encoder = JvmBase64Encoder(type = type, isWithPadding = isWithPadding)

fun Base64Encoder(
    type: Base64Type,
    isWithPadding: Boolean,
    charset: Charset
): Base64Encoder = JvmBase64Encoder(type = type, isWithPadding = isWithPadding, charset = charset)

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
