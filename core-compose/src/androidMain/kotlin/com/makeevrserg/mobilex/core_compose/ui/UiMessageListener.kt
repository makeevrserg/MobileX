package com.makeevrserg.mobilex.core_compose.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.zIndex
import com.makeevrserg.mobilex.core_compose.asComposableString
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
            is UIMessage.SnackBar -> {
                val text = it.uiText.asComposableString()
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(text)
                }
            }

            is UIMessage.Toast -> {
                Toast.makeText(
                    LocalContext.current,
                    it.uiText.asComposableString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    Box(
        Modifier
            .fillMaxSize()
            .imePadding()
            .systemBarsPadding()
            .background(Color.Transparent)
            .zIndex(snackbarZIndex), Alignment.BottomCenter
    ) {
        SnackbarHost(hostState = snackbarHostState)
    }
}