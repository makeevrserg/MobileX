package com.makeevrserg.mvvmcore.core_compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.makeevrserg.mvvmcore.core.ui.loading.IUILoadingAction

@Composable
fun UiLoadingListener(action: IUILoadingAction, content: @Composable (show: Boolean) -> Unit) {
    val isLoading by action.uiLoading.collectAsState()
    content(show = isLoading)
}