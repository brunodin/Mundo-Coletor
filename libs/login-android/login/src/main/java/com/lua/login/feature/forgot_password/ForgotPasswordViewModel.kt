package com.lua.login.feature.forgot_password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lua.core.EventSender
import com.lua.core.EventSenderImpl
import com.lua.login.feature.forgot_password.ForgotPasswordViewModel.ScreenEvent
import com.lua.login.feature.util.Router.LOGIN
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ForgotPasswordViewModel : ViewModel(), EventSender<ScreenEvent> by EventSenderImpl() {

    private val email = MutableStateFlow(String())
    val screenState = MutableStateFlow<ScreenState>(ScreenState.Screen(email))

    fun onValueChanged(value: String) {
        email.value = value
    }

    fun onSendEmailClicked() {
        viewModelScope.sendEvent(ScreenEvent.ChangePasswordInShared)
        viewModelScope.sendEvent(ScreenEvent.Navigate(LOGIN))
    }

    fun onBackClicked() {
        viewModelScope.sendEvent(ScreenEvent.GoBack)
    }

    private fun dispatchGetUserInfo() = viewModelScope.launch {

    }

    sealed class ScreenState {
        object Loading : ScreenState()
        object RequestError(va) : ScreenState()
        data class Screen(val email: MutableStateFlow<String>) : ScreenState()
    }

    sealed class ScreenEvent {
        object GoBack : ScreenEvent()
        object ChangePasswordInShared : ScreenEvent()
        data class Navigate(val router: String) : ScreenEvent()
    }
}