package com.makeevrserg.mobilex.uitext

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import dev.icerock.moko.resources.StringResource

@Composable
actual fun UiText.asComposableString(): String = asString(LocalContext.current)