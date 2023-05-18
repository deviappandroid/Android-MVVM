package com.iapp.androidmvvm.repo

import com.iapp.androidmvvm.model.ServerData
import com.iapp.androidmvvm.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    suspend fun fetchServerData(): Flow<Resource<List<ServerData>>>
}