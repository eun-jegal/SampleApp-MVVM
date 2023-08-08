package com.example.sampleapp_mvvm.data.model


import com.example.sampleapp_mvvm.domain.User
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("avatar")
    val avatar: String = "",
    @SerializedName("device_Token")
    val deviceToken: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("id")
    val id: Int = -1,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("userId")
    val userId: String = "",
    @SerializedName("userToken")
    val userToken: String = ""
) {
    fun toUser(): User = User(id = id, name = name, email = email, imagePath = avatar)
}