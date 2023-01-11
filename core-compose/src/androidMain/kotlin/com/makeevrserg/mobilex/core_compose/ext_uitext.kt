package com.makeevrserg.mobilex.core_compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.makeevrserg.mobilex.ktx_core.action.components.UiText

/**
 * Compose support for [UiText]
 */
@Composable
fun UiText.asComposableString(): String {
    return when (this) {
        is UiText.DynamicString -> value
        is UiText.StringResource -> stringResource(id = resId)
    }
}