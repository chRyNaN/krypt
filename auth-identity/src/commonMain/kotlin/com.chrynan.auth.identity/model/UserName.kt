@file:Suppress("unused")

package com.chrynan.auth.identity.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserName(
    @SerialName(value = "full") val full: String,
    @SerialName(value = "preferred") val preferred: String = full,
    @SerialName(value = "given") val given: String? = null,
    @SerialName(value = "middle") val middle: String? = null,
    @SerialName(value = "family") val family: String? = null,
    @SerialName(value = "prefix") val prefix: String? = null,
    @SerialName(value = "suffix") val suffix: String? = null,
    @SerialName(value = "phonetic_full") val phoneticFull: String? = null,
    @SerialName(value = "phonetic_preferred") val phoneticPreferred: String? = null,
    @SerialName(value = "phonetic_given") val phoneticGiven: String? = null,
    @SerialName(value = "phonetic_middle") val phoneticMiddle: String? = null,
    @SerialName(value = "phonetic_family") val phoneticFamily: String? = null,
    @SerialName(value = "phonetic_prefix") val phoneticPrefix: String? = null,
    @SerialName(value = "phonetic_suffix") val phoneticSuffix: String? = null
) {

    val first: String?
        get() = given

    val last: String?
        get() = family

    val phoneticFirst: String?
        get() = phoneticGiven

    val phoneticLast: String?
        get() = phoneticFamily

    companion object
}
