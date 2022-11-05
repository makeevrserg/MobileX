package com.makeevrserg.mvvm_core.ktx_core

import kotlinx.coroutines.flow.MutableStateFlow

abstract class State<T>  {
    abstract val state: MutableStateFlow<T>
    inline fun <reified K : T> updateState(block: K.() -> K) {
        val child = state.value as? K ?: return
        state.value = block.invoke(child)
    }
}