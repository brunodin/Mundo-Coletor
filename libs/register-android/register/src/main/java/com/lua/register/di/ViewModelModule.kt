package com.lua.register.di

import com.lua.register.feature.RegisterViewModel
import com.lua.register.feature.register_credentials.RegisterCredentialsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RegisterCredentialsViewModel() }
    viewModel { RegisterViewModel() }
}