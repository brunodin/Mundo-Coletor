package com.lua.login.di

import org.koin.core.context.loadKoinModules

object LoginModule {
    fun init() = loadKoinModules(
        viewModelModule
    )
}