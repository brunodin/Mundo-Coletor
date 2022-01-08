package com.lua.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

@Composable
fun rememberAlertWarningVisibility() = remember { AlertWarningVisibility() }

class AlertWarningVisibility {

    val passwordVisibility = mutableStateOf(true)

    companion object {
        const val DELAY_TIME: Long = 10000
    }

    init {
        changeAlertVisibilityAfterTime()
    }

    private fun changeAlertVisibilityAfterTime() = CoroutineScope(Dispatchers.Main).launch {
        delay(DELAY_TIME)
        passwordVisibility.value = false
    }
}