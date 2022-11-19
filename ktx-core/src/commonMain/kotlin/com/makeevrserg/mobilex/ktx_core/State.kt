package com.makeevrserg.mobilex.ktx_core

import kotlinx.coroutines.flow.MutableStateFlow

abstract class State<T>  {
    abstract val flow: MutableStateFlow<T>
    inline fun <reified K : T> updateState(block: K.() -> K) {
        val child = flow.value as? K ?: return
        flow.value = block.invoke(child)
    }
}