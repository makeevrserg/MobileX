package com.makeevrserg.mobilex.ktx_core.storage

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface LocalStorage<T> {
    /**
     * The flow will be updated on [save]; [load] and [reset]
     */
    val stateFlow: StateFlow<T>

    var value: T

    fun reset()

    fun update(block: (T) -> T) {
        value = block(value)
    }

    interface Optional<T : Any> : LocalStorage<T> {
        val default: T
        override var value: T
    }
}


