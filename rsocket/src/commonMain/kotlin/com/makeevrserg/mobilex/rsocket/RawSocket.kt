package com.makeevrserg.mobilex.rsocket

import kotlinx.coroutines.flow.StateFlow

interface RawSocket {
    val isSocketOpen: StateFlow<Boolean>
    val isSocketOpening: StateFlow<Boolean>
    fun open()
    fun close()
    fun sendMessage(message: SocketMessage<*, *>)
    fun sendByteMessage(message: SocketMessage<*, *>)
}

