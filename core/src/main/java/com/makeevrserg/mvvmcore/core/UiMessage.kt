package com.makeevrserg.mvvmcore.core


sealed class UIMessage {
    class SnackBar(val uiText: UiText) : UIMessage()
    class Toast(val uiText: UiText) : UIMessage()
}