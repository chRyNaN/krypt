package com.chrynan.auth.core

import okio.ByteString
import okio.ByteString.Companion.decodeBase64
import okio.ByteString.Companion.decodeHex
import okio.ByteString.Companion.encode
import okio.ByteString.Companion.encodeUtf8
import java.nio.charset.Charset
import java.security.SecureRandom
import java.util.*

fun test(byteString: ByteString) {
    "".encodeUtf8().toByteArray()
    "".encode()
    "".decodeBase64()
    "".decodeHex()
    val random = SecureRandom.getInstanceStrong()

    random.nextInt(5)

    byteString.toByteArray()
}
