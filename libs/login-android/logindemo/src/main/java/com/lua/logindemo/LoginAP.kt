package com.lua.logindemo

import android.app.Application
import com.lua.login.di.LoginModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LoginAP: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@LoginAP)
            LoginModule.init()
        }
    }
}