package com.chrynan.krypt.encoding

import okio.ByteString.Companion.encodeUtf8

internal fun String.toUtf8ByteArray(): ByteArray = encodeUtf8().toByteArray()
