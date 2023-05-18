package com.iapp.androidmvvm.repo

import com.iapp.androidmvvm.datasource.RemoteDataSource
import com.iapp.androidmvvm.model.ServerData
import com.iapp.androidmvvm.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainRepositoryImpl(private val remoteDataSource: RemoteDataSource):MainRepository {

    override suspend fun fetchServerData(): Flow<Resource<List<ServerData>>> = flow {
        emit(Resource.Loading())
        emit(remoteDataSource.fetchVpnServerData())
    }.flowOn(Dispatchers.IO)
}