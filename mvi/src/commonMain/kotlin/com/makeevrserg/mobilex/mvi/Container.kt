package com.makeevrserg.mobilex.mvi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface Container<STATE : Any, SIDE_EFFECT : Any> {
    public val mutableStateFlow: MutableStateFlow<STATE>
    public val sideEffectFlow: Flow<SIDE_EFFECT>
    suspend fun send(effect: SIDE_EFFECT)

}

