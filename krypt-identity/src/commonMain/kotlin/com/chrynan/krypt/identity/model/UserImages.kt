package com.chrynan.krypt.identity.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class UserImages(
    @SerialName(value = "avatar") val avatar: UserImage? = null,
    @SerialName(value = "banner") val banner: UserImage? = null
) {

    companion object
}
