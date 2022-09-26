package com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners

import android.view.View
import com.makeevrserg.mvvmcore.core.UIMessage

interface IUiMessageListener {
    fun onUiMessage(view: View, uiMessage: UIMessage)
}