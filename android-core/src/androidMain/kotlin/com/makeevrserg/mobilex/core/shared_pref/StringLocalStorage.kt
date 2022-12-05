package com.makeevrserg.mobilex.core.shared_pref

import android.content.SharedPreferences
import androidx.core.content.edit
import com.makeevrserg.mobilex.ktx_core.ILocalStorage
import kotlinx.coroutines.flow.MutableStateFlow

class StringLocalStorage(
    private val sharedPreferences: SharedPreferences,
    override val key: String,
    override val default: String,
) : ILocalStorage<String>() {
    override val _mutableStateFlow: MutableStateFlow<String> = MutableStateFlow(loadValue())
    override fun setValue(it: String) {
        super.setValue(it)
        sharedPreferences.edit {
            putString(key, it)
        }
    }
    override fun clear() {
        sharedPreferences.edit {
            remove(key)
            _mutableStateFlow.value = default
        }
    }
    override fun loadValue(): String = sharedPreferences.getString(key, default) ?: default
}
