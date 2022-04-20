package com.jinyeob.eqt

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    init {
        instance = this
    }

    companion object {
        const val TAG = "tag"
        private lateinit var instance: MyApplication

        fun applicationContext(): Context {
            return instance.applicationContext
        }
    }
}
