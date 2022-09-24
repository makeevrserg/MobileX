package com.makeevrserg.mvvmcore.core.shared_pref

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.coroutines.flow.MutableStateFlow

class BoolSharedPref(
    override val sharedPreferences: SharedPreferences,
    override val key: String,
    override val default: Boolean,
) : ISharedPref<Boolean>() {
    override val _mutableStateFlow: MutableStateFlow<Boolean> = MutableStateFlow(loadValue())
    override fun setValue(it: Boolean) {
        super.setValue(it)
        sharedPreferences.edit {
            putBoolean(key, it)
        }
    }

    override fun loadValue(): Boolean = sharedPreferences.getBoolean(key, default) ?: default
}

