package com.lua.desingsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun rememberPasswordVisibility() = remember { PasswordVisibilityHandler() }

class PasswordVisibilityHandler() {

    val isVisible = mutableStateOf(false)

    fun onVisibilityChanged() {
        this.isVisible.value = isVisible.value.not()
    }
}