package com.lua.registerdemo

import android.app.Application
import com.lua.register.di.RegisterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RegisterApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RegisterApp)
            RegisterModule.init()
        }
    }
}