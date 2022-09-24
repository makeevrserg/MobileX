package com.makeevrserg.mvvmcore.core.shared_pref

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.coroutines.flow.MutableStateFlow

class StringSharedPref(
    override val sharedPreferences: SharedPreferences,
    override val key: String,
    override val default: String,
) : ISharedPref<String>() {
    override val _mutableStateFlow: MutableStateFlow<String> = MutableStateFlow(loadValue())
    override fun setValue(it: String) {
        super.setValue(it)
        sharedPreferences.edit {
            putString(key, it)
        }
    }

    override fun loadValue(): String = sharedPreferences.getString(key, default) ?: default
}
