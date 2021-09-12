package com.chrynan.auth.core

import okio.ByteString.Companion.encodeUtf8

fun String.toUtf8ByteArray(): ByteArray = encodeUtf8().toByteArray()
