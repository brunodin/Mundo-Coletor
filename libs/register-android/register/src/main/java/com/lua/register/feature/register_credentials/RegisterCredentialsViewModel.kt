package com.lua.register.feature.register_credentials

import androidx.lifecycle.ViewModel
import com.lua.core.EventSender
import com.lua.core.EventSenderImpl
import com.lua.register.feature.register_credentials.RegisterCredentialsViewModel.ScreenEvent

class RegisterCredentialsViewModel : ViewModel(), EventSender<ScreenEvent> by EventSenderImpl() {

    fun onBackClicked() {

    }

    fun onCloseClicked() {

    }

    sealed class ScreenEvent {

    }
}