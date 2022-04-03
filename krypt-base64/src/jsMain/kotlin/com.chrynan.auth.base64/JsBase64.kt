package com.chrynan.auth.base64

internal actual fun Base64Encoder(type: Base64Type, isWithPadding: Boolean): Base64Encoder =
    OkioBase64Encoder(type = type)

internal actual fun Base64Decoder(type: Base64Type, isWithPadding: Boolean): Base64Decoder =
    OkioBase64Decoder(type = type)
