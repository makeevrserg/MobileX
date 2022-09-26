package com.makeevrserg.mvvmcore.core.presentation.ui_provider.providers

import com.makeevrserg.mvvmcore.core.SingleLiveEvent
import com.makeevrserg.mvvmcore.core.UIMessage
import kotlinx.coroutines.flow.StateFlow

interface IUiMessageProvider {
    val uiMessage: StateFlow<SingleLiveEvent<UIMessage>>
}