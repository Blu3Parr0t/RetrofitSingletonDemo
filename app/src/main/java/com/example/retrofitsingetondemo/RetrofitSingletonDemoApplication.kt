package com.example.retrofitsingetondemo

import android.app.Application
import timber.log.Timber

class RetrofitSingletonDemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
