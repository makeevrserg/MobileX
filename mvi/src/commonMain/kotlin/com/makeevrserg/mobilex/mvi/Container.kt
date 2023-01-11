package com.makeevrserg.mobilex.mvi

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

class Container<STATE : Any, SIDE_EFFECT : Any>(initialState: STATE) :
    IContainer<STATE, SIDE_EFFECT> {
    override val mutableStateFlow: MutableStateFlow<STATE> = MutableStateFlow(initialState)
    private val _sideEffectChannel: Channel<SIDE_EFFECT> = Channel<SIDE_EFFECT>()
    override val sideEffectFlow: Flow<SIDE_EFFECT> = _sideEffectChannel.receiveAsFlow()

    override suspend fun send(effect: SIDE_EFFECT) {
        _sideEffectChannel.send(effect)
    }

}