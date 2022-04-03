package com.chrynan.krypt.encoding

import kotlinx.serialization.Serializable

@Serializable
enum class Base64Type {

    DEFAULT,
    URL,
    MIME
}
