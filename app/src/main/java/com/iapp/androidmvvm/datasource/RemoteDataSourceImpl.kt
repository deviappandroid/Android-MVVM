package com.iapp.androidmvvm.datasource

import com.iapp.androidmvvm.api.ApiService
import com.iapp.androidmvvm.model.ServerData
import com.iapp.androidmvvm.utils.ApkInfoUtils
import com.iapp.androidmvvm.utils.Resource
import com.iapp.androidmvvm.utils.parseCSVFile
import com.iapp.androidmvvm.utils.safeApiCall
import com.iapp.androidmvvm.utils.saveFile
import okhttp3.ResponseBody

class RemoteDataSourceImpl(
    private val service: ApiService,
    private val apkUtils: ApkInfoUtils
) : RemoteDataSource {
    override suspend fun fetchVpnServerData(): Resource<List<ServerData>> {
        return safeApiCall(
            call = { service.downloadVpnCSVFile() },
            result = { getServerDataFromResponse(it) }
        )
    }
    private fun getServerDataFromResponse(it: ResponseBody): MutableList<ServerData> {
        val filePath = apkUtils.getFilePath("gate_vpn_servers_data.csv")
        val savedFile = saveFile(it, filePath)
        val servers = parseCSVFile(savedFile)
        return servers
    }

}