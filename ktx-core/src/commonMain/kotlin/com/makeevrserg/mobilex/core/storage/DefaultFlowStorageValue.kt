package com.makeevrserg.mobilex.core.storage

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * This DefaultFlowStorageValue<T> can be used with delegation
 */
class DefaultFlowStorageValue<T>(
    private val default: T,
    private val loadSettingsValue: () -> T,
    private val saveSettingsValue: (T) -> Unit
) : FlowStorageValue<T> {

    private val mutableStateFlow by lazy {
        MutableStateFlow(loadSettingsValue.invoke())
    }
    override val stateFlow: StateFlow<T>
        get() = mutableStateFlow

    override fun loadValue(): T {
        val newValue = loadSettingsValue.invoke()
        mutableStateFlow.value = newValue
        return newValue
    }

    override fun saveValue(value: T) {
        saveSettingsValue.invoke(value)
        mutableStateFlow.value = value
    }

    override fun reset() {
        saveValue(default)
    }

    override fun saveValue(block: (T) -> T) {
        saveValue(block(value))
    }
}
