package com.makeevrserg.mobilex.ktx_core.storage

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * This DefaultFlowStorageValue<T> can be used with delegation
 */
class DefaultFlowStorageValue<T>(
    private val default: T,
    private val loadValue: () -> T,
    private val saveValue: (T) -> Unit
) : FlowStorageValue<T> {

    private val mutableStateFlow by lazy {
        MutableStateFlow(loadValue())
    }
    override val stateFlow: StateFlow<T>
        get() = mutableStateFlow

    override val value: T
        get() = stateFlow.value

    override fun loadValue(): T {
        return loadValue.invoke()
    }

    override fun saveValue(value: T) {
        saveValue.invoke(value)
    }

    override fun reset() {
        saveValue(default)
    }

    override fun saveValue(block: (T) -> T) {
        saveValue(block(value))
    }
}

