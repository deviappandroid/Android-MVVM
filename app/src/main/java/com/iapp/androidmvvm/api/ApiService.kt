package com.iapp.androidmvvm.api

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/api/iphone/")
    suspend fun downloadVpnCSVFile(): Response<ResponseBody>
}