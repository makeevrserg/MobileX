package com.makeevrserg.mvvmcore.core.ui

/**
 * This class is created for handling ui dialogs from viewmodel by stateFlow or etc
 */
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