package com.makeevrserg.mvvmcore.core_compose.ui_provider

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
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.makeevrserg.mvvmcore.core.UIMessage
import com.makeevrserg.mvvmcore.core.collectOn
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.providers.IUiMessageProvider
import com.makeevrserg.mvvmcore.core_compose.asString
import kotlinx.coroutines.launch

@Composable
fun UiMessageListener(provider: IUiMessageProvider) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    provider.uiMessage.collectAsState()?.value?.value?.let {
        val message = it.uiText.asString()
        when (it) {
            is UIMessage.Toast -> {
                Toast.makeText(LocalContext.current, message, Toast.LENGTH_SHORT).show()
            }

            is UIMessage.SnackBar -> {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(message)
                }
            }
        }
    }

    Box(
        Modifier
            .fillMaxSize()
            .imePadding()
            .systemBarsPadding()
            .background(Color.Transparent),
        Alignment.BottomCenter
    ) {
        SnackbarHost(hostState = snackbarHostState)
    }
}