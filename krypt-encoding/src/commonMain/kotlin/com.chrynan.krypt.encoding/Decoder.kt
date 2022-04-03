package com.chrynan.krypt.encoding

import okio.ByteString

/**
 * A utility that can convert a [ByteArray] input type in one format to either a [ByteArray] or [String] type in
 * another format. An [Encoder] will encode data to a particular, whereas, a [Decoder] will decode from that format
 * into the original format.
 */
interface Decoder {

    /**
     * Decodes the provided [source] into a [ByteArray] in the format this decoder supports.
     */
    fun decodeToByteArray(source: ByteArray): ByteArray

    /**
     * Decodes the provided [source] into a [String] in the format this decoder supports. Note that the character
     * encoding of the [String] return value is defined by this decoder implementation.
     */
    fun decodeToString(source: ByteArray): String
}

/**
 * An [Decoder] that has overloaded functions for decoding [ByteString]s.
 */
interface ByteStringDecoder : Decoder {

    fun decodeToByteArray(source: ByteString): ByteArray = decodeToByteArray(source = source.toByteArray())

    fun decodeToString(source: ByteString): String = decodeToString(source = source.toByteArray())
}
