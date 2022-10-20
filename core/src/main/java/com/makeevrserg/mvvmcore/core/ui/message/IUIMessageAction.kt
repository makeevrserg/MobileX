package com.makeevrserg.mvvmcore.core.ui.message

import com.makeevrserg.mvvmcore.core.ui.UIMessage
import com.makeevrserg.mvvmcore.core.ui.SingleLiveEvent
import com.makeevrserg.mvvmcore.core.ui.UiText
import com.makeevrserg.mvvmcore.core.ui.singleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

interface IUIMessageAction {
    val uiMessage: MutableStateFlow<SingleLiveEvent<UIMessage>>
    fun UiText.sendToast() {
        uiMessage.update { UIMessage.Toast(this).singleLiveEvent() }
    }

    fun UiText.sendSnackbar() {
        uiMessage.update { UIMessage.SnackBar(this).singleLiveEvent() }
    }
}