package com.example.getpostapi.mvvm.data.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("full_name")
    var fullName: String,
    @SerializedName("gender")
    var gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("username")
    var username: String
)