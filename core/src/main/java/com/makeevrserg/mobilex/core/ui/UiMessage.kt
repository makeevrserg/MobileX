package com.makeevrserg.mobilex.core.ui

/**
 * This class allows you to handle snackbars and toast from viewModel by stateFlow or etc
 */
sealed class UIMessage(val uiText: UiText) {
    class SnackBar(uiText: UiText) : UIMessage(uiText)
    class Toast(uiText: UiText) : UIMessage(uiText)
}