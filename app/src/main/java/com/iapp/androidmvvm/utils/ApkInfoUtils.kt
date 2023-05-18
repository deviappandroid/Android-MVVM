package com.iapp.androidmvvm.utils

import android.content.Context

class ApkInfoUtils(private val context: Context) {

    fun getFilePath(fileName: String) = context.filesDir.absolutePath + fileName

}