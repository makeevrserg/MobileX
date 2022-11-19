package com.makeevrserg.mobilex.ktx_core.ui

import com.makeevrserg.mobilex.ktx_core.UIDialogMessage
import com.makeevrserg.mobilex.ktx_core.nullableStateFlow
import kotlinx.coroutines.flow.MutableStateFlow

interface IUIDialogAction {
    val uiDialog: MutableStateFlow<UIDialogMessage?>

    fun UIDialogMessage.send() {
        uiDialog.value = this
    }

    fun clearUiDialog() {
        uiDialog.value = null
    }
}

class UIDialogAction : IUIDialogAction {
    override val uiDialog: MutableStateFlow<UIDialogMessage?> by nullableStateFlow()

}