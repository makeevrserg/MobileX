package com.makeevrserg.mobilex.ktx_core.storage

import kotlinx.coroutines.flow.StateFlow

interface StorageValue<T> {
    /**
     * The flow will be updated on [setValue]; [getValue] and [reset]
     */
    val stateFlow: StateFlow<T>

    var value: T

    fun reset()

    fun update(block: (T) -> T) {
        value = block(value)
    }

    interface Optional<T : Any> : StorageValue<T> {
        val default: T
        override var value: T
    }
}

