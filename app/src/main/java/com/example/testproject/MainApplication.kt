package com.example.testproject

import android.app.Application
import com.example.testproject.utils.NetworkUtils

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        NetworkUtils.init(this.applicationContext)

    }

}