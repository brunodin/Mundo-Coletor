package com.lua.login.di

import com.lua.login.feature.MainViewModel
import com.lua.login.feature.forgot_password.ForgotPasswordViewModel
import com.lua.login.feature.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ForgotPasswordViewModel() }
    viewModel { MainViewModel() }
    viewModel { LoginViewModel() }
}