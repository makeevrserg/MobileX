package com.makeevrserg.mobilex.mvi

import com.makeevrserg.mobilex.ktx_core.collectOn
import kotlinx.coroutines.CoroutineScope


interface ContainerListener<STATE : Any, SIDE_EFFECT : Any>  {
    fun onState(state: STATE)
    fun onSideEffect(sideEffect: SIDE_EFFECT)
    fun collectState(lifecycleScope: CoroutineScope, container: Container<STATE, SIDE_EFFECT>) {
        container.mutableStateFlow.collectOn(lifecycleScope) {
            onState(it)
        }
        container.sideEffectFlow.collectOn(lifecycleScope){
            onSideEffect(it)
        }
    }
}