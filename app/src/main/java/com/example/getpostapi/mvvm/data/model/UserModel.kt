package com.example.getpostapi.mvvm.data.model


import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("data")
    val `data`: List<Data>
)