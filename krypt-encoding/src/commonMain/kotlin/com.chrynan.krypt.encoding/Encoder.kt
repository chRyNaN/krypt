@file:Suppress("unused")

package com.chrynan.krypt.encoding

import okio.ByteString

/**
 * A utility that can convert a [ByteArray] input type in one format to either a [ByteArray] or [String] type in
 * another format. An [Encoder] will data to a particular, whereas, a [Decoder] will decode from that format into the
 * original format.
 */
interface Encoder {

    /**
     * Encodes the provided [source] into a [ByteArray] in the format this encoder supports.
     */
    fun encodeToByteArray(source: ByteArray): ByteArray

    /**
     * Encodes the provided [source] into a [String] in the format this encoder supports. Note that the character
     * encoding of the [String] return value is defined by this encoder implementation.
     */
    fun encodeToString(source: ByteArray): String
}

/**
 * Encodes the provided UTF-8 formatted [String] [source] into a [ByteArray] in the format this encoder supports.
 */
fun Encoder.encodeUtf8ToByteArray(source: String): ByteArray = encodeToByteArray(source = source.encodeToByteArray())

/**
 * Encodes the provided UTF-8 formatted [String] [source] into a [String] in the format this encoder supports. Note
 * that the character encoding of the [String] return value is defined by this encoder implementation.
 */
fun Encoder.encodeUtf8ToString(source: String): String = encodeToString(source = source.encodeToByteArray())

/**
 * An [Encoder] that has overloaded functions for encoding [ByteString]s.
 */
interface ByteStringEncoder : Encoder {

    fun encodeToByteArray(source: ByteString): ByteArray = encodeToByteArray(source = source.toByteArray())

    fun encodeToString(source: ByteString): String = encodeToString(source = source.toByteArray())
}
