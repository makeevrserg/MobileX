package com.makeevrserg.mobilex.core_compose.ui

import androidx.compose.runtime.Composable
import com.makeevrserg.mobilex.ktx_core.ui.IUIMessageAction

@Composable
expect fun UiMessageListener(action: IUIMessageAction, snackbarZIndex: Float = Float.MAX_VALUE)
