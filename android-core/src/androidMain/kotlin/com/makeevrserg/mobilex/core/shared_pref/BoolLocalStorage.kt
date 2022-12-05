package com.makeevrserg.mobilex.core.shared_pref

import android.content.SharedPreferences
import androidx.core.content.edit
import com.makeevrserg.mobilex.ktx_core.ILocalStorage
import kotlinx.coroutines.flow.MutableStateFlow

class BoolLocalStorage(
    private val sharedPreferences: SharedPreferences,
    override val key: String,
    override val default: Boolean,
) : ILocalStorage<Boolean>() {
    override val _mutableStateFlow: MutableStateFlow<Boolean> = MutableStateFlow(loadValue())
    override fun setValue(it: Boolean) {
        super.setValue(it)
        sharedPreferences.edit {
            putBoolean(key, it)
        }
    }

    override fun clear() {
        sharedPreferences.edit {
            remove(key)
            _mutableStateFlow.value = default
        }
    }
    override fun loadValue(): Boolean = sharedPreferences.getBoolean(key, default) ?: default
}

