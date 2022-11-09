package com.makeevrserg.mobilex.core_compose.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.zIndex
import com.makeevrserg.mobilex.core.ui.UIMessage
import com.makeevrserg.mobilex.core.ui.message.IUIMessageAction
import com.makeevrserg.mobilex.core_compose.asString
import kotlinx.coroutines.launch

@Composable
fun UiMessageListener(action: IUIMessageAction, snackbarZIndex: Float = Float.MAX_VALUE) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val uiMessages by action.uiMessage.collectAsState()
    uiMessages.value?.let {
        when (it) {
            is UIMessage.SnackBar -> {
                val text = it.uiText.asString()
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(text)
                }
            }

            is UIMessage.Toast -> {
                Toast.makeText(
                    LocalContext.current,
                    it.uiText.asString(),
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