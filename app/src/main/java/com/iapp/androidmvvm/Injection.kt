package com.iapp.androidmvvm

import android.content.Context
import com.iapp.androidmvvm.utils.resorceprovider.ResourceProvider
import com.iapp.androidmvvm.utils.resorceprovider.ResourceProviderImpl
import com.iapp.androidmvvm.datasource.RemoteDataSourceImpl
import com.iapp.androidmvvm.network.ApiServices
import com.iapp.androidmvvm.repo.MainRepository
import com.iapp.androidmvvm.repo.MainRepositoryImpl
import com.iapp.androidmvvm.utils.ApkInfoUtils

object Injection {

    lateinit var appContext: Context

    fun init(context: Context) {
        setResourceProvider(context)
        setContext(context)
    }

    private fun setContext(context: Context) {
        appContext = context
    }

    /** resource provider initialization **/
    private var resourceProvider: ResourceProvider? = null
    private fun setResourceProvider(context: Context) {
        resourceProvider = ResourceProviderImpl(context)
    }

    private fun getRemoteDataSource(): RemoteDataSourceImpl {
        return RemoteDataSourceImpl(
            ApiServices.createApiService(),
            ApkInfoUtils(appContext)
        )
    }

    private var mainRepositoryInstance: MainRepository? = null
    fun getMainRepository(): MainRepository {
        if (mainRepositoryInstance == null) {
            mainRepositoryInstance = MainRepositoryImpl(
                getRemoteDataSource()
            )
        }
        return requireNotNull(mainRepositoryInstance)
    }
}