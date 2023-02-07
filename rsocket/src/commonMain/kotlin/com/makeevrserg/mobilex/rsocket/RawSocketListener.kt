package com.makeevrserg.mobilex.rsocket

interface RawSocketListener {
    fun onOpen()
    fun onClosed()
    fun onFailure(t:Throwable)
    fun onMessage(message: String)
}