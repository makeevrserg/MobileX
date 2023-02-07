package com.makeevrserg.mobilex.uitext

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun UiText.asComposableString(): String = asString(LocalContext.current)