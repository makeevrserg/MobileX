package com.makeevrserg.mvvmcore.core_compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.makeevrserg.mvvmcore.core.ui.UIDialogMessage
import com.makeevrserg.mvvmcore.core.ui.dialog.IUIDialogAction

@Composable
fun UIDialogListener(action: IUIDialogAction, content: @Composable (UIDialogMessage) -> Unit) {
    val uiDialogMessage by action.uiDialog.collectAsState()
    uiDialogMessage?.let { content(it) }
}