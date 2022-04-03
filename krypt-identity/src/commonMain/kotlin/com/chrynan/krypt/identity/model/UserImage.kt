package com.chrynan.krypt.identity.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.datetime.Instant
import com.chrynan.imagery.core.model.Image
import com.chrynan.imagery.core.model.ImageVariant

@Serializable
data class UserImage(
    @SerialName(value = "id") val id: String,
    @SerialName(value = "created") val created: Instant,
    @SerialName(value = "updated") val updated: Instant,
    @SerialName(value = "variants") val variants: Set<ImageVariant>,
    @SerialName(value = "default") val default: Image
) {

    companion object
}
