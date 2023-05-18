package com.iapp.androidmvvm.utils.resorceprovider

import android.content.Context

class ResourceProviderImpl(private val context: Context?) : ResourceProvider {
    override fun getString(resId: Int, vararg formatArgs: String): String? {
        return context?.getString(resId, *formatArgs)
    }

    override fun getString(resId: Int): String? {
        return context?.getString(resId)
    }
}