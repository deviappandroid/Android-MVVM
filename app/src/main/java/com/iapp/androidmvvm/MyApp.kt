package com.iapp.androidmvvm

import android.app.Application

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Injection.init(applicationContext)

    }

}
