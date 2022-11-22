package com.makeevrserg.mobilex.ktx_core.ui

import com.makeevrserg.mobilex.ktx_core.UIDialogButton
import com.makeevrserg.mobilex.ktx_core.UIDialogMessage
import kotlinx.coroutines.flow.MutableStateFlow

interface IUILoadingAction {
    val uiLoading: MutableStateFlow<Boolean>
    fun setLoading(value: Boolean) {
        uiLoading.value = value
    }
}

class UILoadingAction : IUILoadingAction {
    override val uiLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
}

