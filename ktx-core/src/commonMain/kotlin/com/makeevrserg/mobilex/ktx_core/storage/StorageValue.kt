package com.makeevrserg.mobilex.ktx_core.storage

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * [StorageValue<T>] allows you to save/load values from your storage withou depending on SharedPreferences or other library
 */
interface StorageValue<T> {
    /**
     * Current state of a [value]
     */
    val value: T

    /**
     * Load value from storage and update [value]
     */
    fun loadValue(): T

    /**
     * Save new value into storage and update current
     */
    fun saveValue(value: T)

    /**
     * Save value with a refernce to current
     */
    fun saveValue(block: (T) -> T)

    /**
     * Reset value to to default
     */
    fun reset()
}

