package com.lua.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

open class EventSenderImpl<Z>: EventSender<Z> {
    private val eventChannel = Channel<Z>(Channel.BUFFERED)
    override val screenEvent: Flow<Z>
        get() = eventChannel.receiveAsFlow()

    override fun CoroutineScope.sendEvent(item: Z) = this.launch{
        eventChannel.send(item)
    }
}