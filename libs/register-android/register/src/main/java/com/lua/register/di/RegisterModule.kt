package com.lua.register.di

import org.koin.core.context.loadKoinModules

object RegisterModule {

    fun init() = loadKoinModules(viewModelModule)
}