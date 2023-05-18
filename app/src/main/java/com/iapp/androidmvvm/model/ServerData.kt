package com.iapp.androidmvvm.model

import androidx.recyclerview.widget.DiffUtil
import java.io.Serializable
import java.util.UUID

data class ServerData(
    val hostname: String,
    val ip: String,
    val score: String,
    val ping: String,
    val speed: String,
    val countryLong: String,
    val countryShort: String,
    val numVpnSessions: String,
    val uptime: String,
    val totalUsers: String,
    val totalTraffic: String,
    val logType: String,
    val operator: String,
    val message: String,
    val configData: String,
    val type: Int,
    val quality: String,
    val city: String? = null,
    val regionName: String? = null,
    val lat: Long? = null,
    val lon: Long? = null,
    val id: String = UUID.randomUUID().toString()
): Serializable {
    companion object {
        val diff = object : DiffUtil.ItemCallback<ServerData>() {
            override fun areItemsTheSame(
                oldItem: ServerData,
                newItem: ServerData
            ) = oldItem.id== newItem.id

            override fun areContentsTheSame(
                oldItem: ServerData,
                newItem: ServerData
            ) = oldItem.ip == newItem.ip
        }
    }
}