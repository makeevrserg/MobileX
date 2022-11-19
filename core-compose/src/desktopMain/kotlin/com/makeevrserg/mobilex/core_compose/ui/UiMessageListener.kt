package com.makeevrserg.mobilex.core_compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.zIndex
import com.makeevrserg.mobilex.ktx_core.ui.IUIMessageAction
import com.makeevrserg.mobilex.ktx_core.ui.UIMessage
import kotlinx.coroutines.launch

@Composable
actual fun UiMessageListener(action: IUIMessageAction, snackbarZIndex: Float) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val uiMessages by action.uiMessage.collectAsState()
    uiMessages.value?.let {
        when (it) {
            is UIMessage.Toast, is UIMessage.SnackBar -> {
                val text = it.uiText.asString()
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(text)
                }
            }
        }
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .zIndex(snackbarZIndex), Alignment.BottomCenter
    ) {
        SnackbarHost(hostState = snackbarHostState)
    }

}