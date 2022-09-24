package com.makeevrserg.mvvmcore.core.shared_pref

import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class ISharedPref<T> {
    abstract val sharedPreferences: SharedPreferences
    abstract val key: String
    abstract val default: T

    protected abstract val _mutableStateFlow: MutableStateFlow<T>
    val stateFlow: StateFlow<T>
        get() = _mutableStateFlow

    open fun setValue(it: T) {
        _mutableStateFlow.value = it
    }

    abstract fun loadValue(): T
}