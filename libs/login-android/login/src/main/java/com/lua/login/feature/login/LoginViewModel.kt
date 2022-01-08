package com.lua.login.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lua.core.EMPTY_STRING
import com.lua.core.EventSender
import com.lua.core.EventSenderImpl
import com.lua.login.feature.login.TextFieldType.Email
import com.lua.login.feature.login.TextFieldType.Password
import com.lua.login.feature.util.Router.FORGOT_PASSWORD
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : ViewModel(), EventSender<ScreenEvent> by EventSenderImpl() {

    private val textFieldValues = TextFieldValues()
    val screenState = MutableStateFlow<ScreenState>(ScreenState.Screen(textFieldValues))

    fun onValueChanged(value: TextFieldType) = when (value) {
        is Email -> textFieldValues.email.value = TextFieldAttributes(value.email)
        is Password -> textFieldValues.password.value = TextFieldAttributes(value.password)
    }

    fun onBackClicked() {

    }

    fun onForgotPasswordClicked() {
        viewModelScope.sendEvent(ScreenEvent.Navigate(FORGOT_PASSWORD))
    }

    fun onSingInClicked() {

    }

    fun onSingUpClicked() {

    }
}

sealed class ScreenEvent {
    object GoBack : ScreenEvent()
    object Finish : ScreenEvent()
    data class Navigate(val router: String) : ScreenEvent()
}

sealed class ScreenState {
    object Loading : ScreenState()
    data class Screen(val textFieldValues: TextFieldValues) : ScreenState()
}

sealed class TextFieldType {
    data class Email(val email: String) : TextFieldType()
    data class Password(val password: String) : TextFieldType()
}

data class TextFieldValues(
    val email: MutableStateFlow<TextFieldAttributes> = MutableStateFlow(TextFieldAttributes()),
    val password: MutableStateFlow<TextFieldAttributes> = MutableStateFlow(TextFieldAttributes()),
)

data class TextFieldAttributes(
    val text: String = EMPTY_STRING,
    val isTextInvalid: Boolean = false,
)