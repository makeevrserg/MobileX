package com.makeevrserg.mobilex.ktx_core.ui

import com.makeevrserg.mobilex.ktx_core.UiText

/**
 * This class allows you to handle snackbars and toast from viewModel by stateFlow or etc
 */
sealed class UIMessage(val uiText: UiText) {
    class SnackBar(uiText: UiText) : UIMessage(uiText)
    class Toast(uiText: UiText) : UIMessage(uiText)
}