package com.makeevrserg.mvvmcore.core_compose.ui_provider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.makeevrserg.mvvmcore.core.UIDialogMessage
import com.makeevrserg.mvvmcore.core.collectOn
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.providers.IUiDialogProvider

@Composable
fun UiDialogMessageListener(
    provider: IUiDialogProvider,
    dialog: @Composable (UIDialogMessage) -> Unit
) {
    provider.uiDialogMessage.collectAsState()?.value?.let {
        dialog(it)
    }

}