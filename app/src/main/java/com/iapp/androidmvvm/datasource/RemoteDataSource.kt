package com.iapp.androidmvvm.datasource

import com.iapp.androidmvvm.model.ServerData
import com.iapp.androidmvvm.utils.Resource

interface RemoteDataSource {
    suspend fun fetchVpnServerData(): Resource<List<ServerData>>
}