package com.makeevrserg.mobilex.core.ui.loading

import kotlinx.coroutines.flow.MutableStateFlow

interface IUILoadingAction {
    val uiLoading: MutableStateFlow<Boolean>
    fun setLoading(value: Boolean) {
        uiLoading.value = value
    }
}