package com.makeevrserg.mobilex.ktx_core.mvi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface IContainer<STATE : Any, SIDE_EFFECT : Any> {
    public val stateFlow: MutableStateFlow<STATE>
    public val sideEffectFlow: Flow<SIDE_EFFECT>
    suspend fun send(effect: SIDE_EFFECT)

}

