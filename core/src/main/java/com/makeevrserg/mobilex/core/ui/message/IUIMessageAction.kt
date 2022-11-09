package com.makeevrserg.mobilex.core.ui.message

import com.makeevrserg.mobilex.core.ui.UIMessage
import com.makeevrserg.mobilex.core.ui.SingleLiveEvent
import com.makeevrserg.mobilex.core.ui.UiText
import com.makeevrserg.mobilex.core.ui.singleLiveEvent
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