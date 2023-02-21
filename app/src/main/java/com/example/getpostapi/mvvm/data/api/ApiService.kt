package com.razzagalangadzan.pklpaninti.Forecast.mvvm.data.api

import com.example.getpostapi.mvvm.data.model.Data
import com.example.getpostapi.mvvm.data.model.UserModel
import com.razzagalangadzan.pklpaninti.Forecast.mvvm.utils.EndPoint
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("api/users")
    suspend fun getUser(): UserModel

    @POST("api/register")
    suspend fun postRegister(
        @Query("username") username: String,
        @Query("full_name") full_name : String,
        @Query("email") email: String,
        @Query("gender") gender : String,
        @Query("password") password: String,
        @Query("password_confirmation") confirm_password: String
    ): UserModel

    @POST("api/register")
    fun register (@Body req: Data) : Call<UserModel>
}
