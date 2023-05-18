package com.iapp.androidmvvm.network

import com.iapp.androidmvvm.api.ApiService
import com.iapp.androidmvvm.utils.Constants

object ApiServices {

    fun createApiService(): ApiService {
        return ServiceGenerator.createService(
            Constants.BASE_URL,
            ApiService::class.java
        )
    }
}