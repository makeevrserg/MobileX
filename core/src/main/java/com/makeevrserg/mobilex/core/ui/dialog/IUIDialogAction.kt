package com.makeevrserg.mobilex.core.ui.dialog

import com.makeevrserg.mobilex.core.ui.UIDialogMessage
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