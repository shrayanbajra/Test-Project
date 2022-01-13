package com.example.testproject.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkUtils {

    fun init(applicationContext: Context) {
        this.applicationContext = applicationContext
    }

    private var applicationContext: Context? = null

    fun hasNoInternetConnection(): Boolean {

        val connectivityManager = applicationContext?.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo

        return activeNetwork?.isConnectedOrConnecting != true

    }
}