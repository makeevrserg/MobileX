package com.makeevrserg.mvvmcore.core.presentation.ui_provider.providers

import com.makeevrserg.mvvmcore.core.UIDialogMessage
import kotlinx.coroutines.flow.StateFlow

interface IUiDialogProvider {
    val uiDialogMessage: StateFlow<UIDialogMessage?>
}