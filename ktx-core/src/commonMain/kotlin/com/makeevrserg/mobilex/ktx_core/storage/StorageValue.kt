package com.makeevrserg.mobilex.ktx_core.storage

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * [StorageValue<T>] allows you to save/load values from your storage withou depending on SharedPreferences or other library
 */
interface StorageValue<T> {
    val value: T
    fun loadValue(): T
    fun saveValue(value: T)
    fun saveValue(block: (T) -> T)
    fun reset()

}

