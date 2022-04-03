package com.chrynan.krypt.encoding

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The type of characters used in Base 64 encoding/decoding.
 *
 * @see [Wikipedia explanation](https://en.wikipedia.org/wiki/Base64)
 */
@Serializable
enum class Base64Type(val typeName: String) {

    @SerialName(value = "default")
    DEFAULT(typeName = "default"),

    @SerialName(value = "url")
    URL(typeName = "url"),

    @SerialName(value = "mime")
    MIME(typeName = "mime");

    companion object {

        fun getByName(name: String, ignoreCase: Boolean = true): Base64Type? =
            values().firstOrNull { it.typeName.equals(name, ignoreCase) }
    }
}
