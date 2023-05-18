package com.iapp.androidmvvm.utils

import android.util.Log
import com.iapp.androidmvvm.model.ServerData

import okhttp3.ResponseBody
import java.io.*


fun saveFile(body: ResponseBody?, pathWhereYouWantToSaveFile: String): String {
    if (body == null)
        return ""
    var input: InputStream? = null
    try {
        input = body.byteStream()
        //val file = File(getCacheDir(), "cacheFileAppeal.srl")
        val fos = FileOutputStream(pathWhereYouWantToSaveFile)
        fos.use { output ->
            val buffer = ByteArray(4 * 1024) // or other buffer size
            var read: Int
            while (input.read(buffer).also { read = it } != -1) {
                output.write(buffer, 0, read)
            }
            output.flush()
        }
        return pathWhereYouWantToSaveFile
    } catch (e: Exception) {
        Log.e("saveFile", e.toString())
    } finally {
        input?.close()
    }
    return ""
}


fun parseCSVFile(file: String): MutableList<ServerData> {
    val bufferedReader = BufferedReader(FileReader(file))
    val allServerData = mutableListOf<ServerData>()
    try {
        var i = 0
        var loopExit = true
        while (loopExit) {
            val readLine: String? = bufferedReader.readLine()
            if (readLine != null) {
                if (i >= 2) {
                    putLine(readLine, 0)?.let { allServerData.add(it) }
                }
                i++
            } else {
                loopExit = false
            }
        }
    } catch (e2: Exception) {
        e2.printStackTrace()
    }
    return allServerData
}

fun putLine(str: String, i: Int): ServerData? {
    var listOfServerData: ServerData? = null
    val split = str.split(",".toRegex()).toTypedArray()
    if (split.size == 15) {
        val contentValues = ServerData(
            hostname = split[0],
            ip = split[1],
            score = split[2],
            ping = split[3],
            speed = split[4],
            countryLong = split[5],
            countryShort = split[6],
            numVpnSessions = split[7],
            uptime = split[8],
            totalUsers = split[9],
            totalTraffic = split[10],
            logType = split[11],
            operator = split[12],
            message = split[13],
            configData = split[14],
            type = Integer.valueOf(i),
            quality = getConnectionQuality(split[4], split[7], split[3])
        )
        listOfServerData = contentValues
    }
    return listOfServerData
}

private fun getConnectionQuality(s: String, s1: String, s2: String): String {
    return "$s + $s1 + $s2"
}
