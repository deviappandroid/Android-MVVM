package com.iapp.androidmvvm.utils.resorceprovider

interface ResourceProvider {
    fun getString(resId: Int, vararg formatArgs: String): String?
    fun getString(resId: Int): String?
}


