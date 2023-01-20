package com.makeevrserg.mobilex.ktx_core.storage

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * This class allows you to create dataSources of your configuration
 * Also supports stateFlow so you are able to be notified when configuration changed
 */
abstract class ILocalStorage<T> {
    abstract val key: String
    abstract val default: T

    protected abstract val _mutableStateFlow: MutableStateFlow<T>
    val stateFlow: StateFlow<T>
        get() = _mutableStateFlow

    open fun setValue(it: T) {
        _mutableStateFlow.value = it
    }

    fun setValue(block: (T) -> T) {
        val prevValue = loadValue()
        val newValue = block(prevValue)
        setValue(newValue)
    }

    abstract fun clear()
    abstract fun loadValue(): T
}
