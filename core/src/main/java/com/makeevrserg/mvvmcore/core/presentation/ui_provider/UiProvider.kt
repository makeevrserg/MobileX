package com.makeevrserg.mvvmcore.core.presentation.ui_provider

import android.view.View
import com.makeevrserg.mvvmcore.core.SingleLiveEvent
import com.makeevrserg.mvvmcore.core.UIDialogMessage
import com.makeevrserg.mvvmcore.core.UIMessage
import com.makeevrserg.mvvmcore.core.routing.RouteInfo
import kotlinx.coroutines.flow.StateFlow

interface IUiMessageProvider {
    val uiMessage: StateFlow<SingleLiveEvent<UIMessage>>
}

interface IUiDialogProvider {
    val uiDialogMessage: StateFlow<UIDialogMessage?>
}

interface ILoadingIndicatorProvider {
    val loadingIndicator: StateFlow<Boolean>
}

interface INextRouteProvider {
    val nextRoute: StateFlow<SingleLiveEvent<RouteInfo>>
}

interface IUiMessageListener {
    fun onUiMessage(view: View, uiMessage: UIMessage)
}

interface IUiDialogListener {
    fun onUiDialog(uiDialogMessage: UIDialogMessage)
}

interface INextRouteListener {
    fun onRouteInfo(routeInfo: RouteInfo)
}

interface ILoadingIndicatorListener {
    fun onLoadingIndication(state: Boolean)
}