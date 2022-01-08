package com.lua.login.feature

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel: ViewModel() {
    var hasPasswordChanged = MutableStateFlow(false)

    fun changePasswordStatus() {
        hasPasswordChanged.value = true
    }
}