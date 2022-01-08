package com.lua.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow

interface EventSender<Z> {
    val screenEvent: Flow<Z>
    fun CoroutineScope.sendEvent(item: Z): Job
}