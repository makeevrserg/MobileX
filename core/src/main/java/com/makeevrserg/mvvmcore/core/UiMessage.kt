package com.makeevrserg.mvvmcore.core


sealed class UIMessage(val uiText: UiText) {
    class SnackBar(uiText: UiText) : UIMessage(uiText)
    class Toast(uiText: UiText) : UIMessage(uiText)
}