package com.andreynaz4renko.masterapplication.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponseData(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("avatar")
    val avatar: String,
    @SerialName("online")
    val online: Boolean,
)
