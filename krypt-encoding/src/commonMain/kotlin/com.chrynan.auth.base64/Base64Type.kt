package com.chrynan.auth.base64

import kotlinx.serialization.Serializable

@Serializable
enum class Base64Type {

    DEFAULT,
    URL,
    MIME
}
