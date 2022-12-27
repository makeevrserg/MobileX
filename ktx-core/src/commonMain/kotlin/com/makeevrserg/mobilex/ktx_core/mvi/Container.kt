package com.makeevrserg.mobilex.ktx_core.mvi

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

class Container<STATE : Any, SIDE_EFFECT : Any>(initialState: STATE) : IContainer<STATE, SIDE_EFFECT> {
    override val stateFlow: MutableStateFlow<STATE> = MutableStateFlow(initialState)
    private val _sideEffectFlow: Channel<SIDE_EFFECT> = Channel<SIDE_EFFECT>()
    override val sideEffectFlow: Flow<SIDE_EFFECT> = _sideEffectFlow.receiveAsFlow()

    override suspend fun send(effect: SIDE_EFFECT) {
        _sideEffectFlow.send(effect)
    }

}