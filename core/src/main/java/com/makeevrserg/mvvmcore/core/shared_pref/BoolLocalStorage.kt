package com.makeevrserg.mvvmcore.core.shared_pref

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.coroutines.flow.MutableStateFlow

class BoolLocalStorage(
    private val sharedPreferences: SharedPreferences,
    override val key: String,
    override val default: Boolean,
) : com.makeevrserg.mvvm_core.ktx_core.ILocalStorage<Boolean>() {
    override val _mutableStateFlow: MutableStateFlow<Boolean> = MutableStateFlow(loadValue())
    override fun setValue(it: Boolean) {
        super.setValue(it)
        sharedPreferences.edit {
            putBoolean(key, it)
        }
    }

    override fun loadValue(): Boolean = sharedPreferences.getBoolean(key, default) ?: default
}

