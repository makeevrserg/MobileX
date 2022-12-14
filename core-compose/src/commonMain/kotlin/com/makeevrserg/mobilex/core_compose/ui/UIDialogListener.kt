package com.makeevrserg.mobilex.core_compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.makeevrserg.mobilex.ktx_core.UIDialogMessage
import com.makeevrserg.mobilex.ktx_core.ui.IUIDialogAction

@Composable
fun UIDialogListener(action: IUIDialogAction, content: @Composable (UIDialogMessage) -> Unit) {
    val uiDialogMessage by action.uiDialog.collectAsState()
    uiDialogMessage?.let { content(it) }
}