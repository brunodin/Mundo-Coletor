package com.lua.login.feature.forgot_password

import kotlinx.coroutines.flow.MutableStateFlow

class ForgotPasswordUiState(
    var isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false),
    var emailText: MutableStateFlow<String> = MutableStateFlow("")
)