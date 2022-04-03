@file:Suppress("unused")

package com.chrynan.krypt.identity.model

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class User(
    @SerialName(value = "id") val id: String,
    @SerialName(value = "created") val created: Instant,
    @SerialName(value = "updated") val updated: Instant,
    @SerialName(value = "name") val name: UserName,
    @SerialName(value = "images") val images: UserImages = UserImages(),
    @SerialName(value = "gravatar_hash") val gravatarHash: String? = null
) {

    companion object
}
