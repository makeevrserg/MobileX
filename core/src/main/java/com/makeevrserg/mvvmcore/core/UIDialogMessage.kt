package com.makeevrserg.mvvmcore.core

class UIDialogMessage(
    val title: UiText,
    val description: UiText,
    val positiveButton: UIDialogButton? = null,
    val negativeButton: UIDialogButton? = null,
    val isCancellable: Boolean = true,
)

class UIDialogButton(
    val text: UiText,
    val onClick: () -> Unit = {}
)