package com.makeevrserg.mobilex.core.storage

/**
 * This DefaultStorageValue<T> can be used with delegation
 */
class DefaultStorageValue<T>(
    private val default: T,
    private val loadSettingsValue: () -> T,
    private val saveSettingsValue: (T) -> Unit
) : StorageValue<T> {
    private var currentValue: T = loadSettingsValue.invoke()
    override val value: T
        get() = currentValue

    override fun loadValue(): T {
        val newValue = loadSettingsValue.invoke()
        currentValue = newValue
        return newValue
    }

    override fun saveValue(value: T) {
        saveSettingsValue.invoke(value)
        currentValue = value
    }

    override fun reset() {
        saveValue(default)
    }

    override fun saveValue(block: (T) -> T) {
        saveValue(block(value))
    }
}
