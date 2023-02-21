package com.razzagalangadzan.pklpaninti.Forecast.mvvm.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getUser() = apiService.getUser()

    suspend fun postRegister() = apiService.postRegister("","","","","","")
}