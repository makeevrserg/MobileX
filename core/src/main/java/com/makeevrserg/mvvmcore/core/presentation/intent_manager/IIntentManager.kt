package com.makeevrserg.mvvmcore.core.presentation.intent_manager

import android.view.View
import com.makeevrserg.mvvmcore.core.UIDialogMessage
import com.makeevrserg.mvvmcore.core.UIMessage
import com.makeevrserg.mvvmcore.core.presentation.CoreViewModel
import com.makeevrserg.mvvmcore.core.routing.RouteAction
import com.makeevrserg.mvvmcore.core.routing.RouteInfo

interface IIntentManager<T : CoreViewModel> {
    val viewModel: T
    fun onUiDialogMessage(it: UIDialogMessage)
    fun onUiMessage(view: View, it: UIMessage)
    fun onLoadingIndicator(isLoading: Boolean)
    fun <K> onRouteAction(it: RouteAction<K>)
    fun onRouteInfo(it: RouteInfo)
}