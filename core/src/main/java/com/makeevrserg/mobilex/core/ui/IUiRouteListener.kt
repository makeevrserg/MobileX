package com.makeevrserg.mobilex.core.ui

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.makeevrserg.mobilex.core.collectOn
import com.makeevrserg.mobilex.core.routing.IRouter
import com.makeevrserg.mobilex.ktx_core.RouteInfo
import com.makeevrserg.mobilex.ktx_core.ui.IUIRouteAction
import kotlinx.coroutines.Dispatchers

interface IUiRouteListener<T> : IContextProvider {

    val navigationProvider: IRouter<T>
    fun collectUiRoute(lifecycleOwner: LifecycleOwner, action: IUIRouteAction) {
        action.uiRoute.collectOn(lifecycleOwner, Dispatchers.Main) {
            it.value?.let(::navigate)
        }
    }

    fun navigate(uiRouteInfo: RouteInfo) {
        val context = contextProvider.invoke() ?: return
        when (uiRouteInfo) {
            is RouteInfo.Intent<*> -> {
                navigationProvider.intent(context, uiRouteInfo)
            }

            is RouteInfo.NextScreen<*> -> {
                (uiRouteInfo as? RouteInfo.NextScreen<T>)?.let {
                    if (it.clearBackStack)
                        navigationProvider.clearBackStack(it.screen)
                    else if (it.replaceScreen)
                        navigationProvider.replaceScreen(it.screen)
                    else navigationProvider.nextScreen(it.screen)
                }
            }

            is RouteInfo.PopBack -> {
                navigationProvider.popBack()
            }
        }
    }
}