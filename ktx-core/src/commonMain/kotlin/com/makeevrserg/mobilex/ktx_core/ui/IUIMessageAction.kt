package com.makeevrserg.mobilex.ktx_core.ui

import com.makeevrserg.mobilex.ktx_core.SingleLiveEvent
import com.makeevrserg.mobilex.ktx_core.UiText
import com.makeevrserg.mobilex.ktx_core.emptyLiveEvent
import com.makeevrserg.mobilex.ktx_core.singleLiveEvent
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

class UIMessageAction : IUIMessageAction {
    override val uiMessage: MutableStateFlow<SingleLiveEvent<UIMessage>> by emptyLiveEvent()
}
