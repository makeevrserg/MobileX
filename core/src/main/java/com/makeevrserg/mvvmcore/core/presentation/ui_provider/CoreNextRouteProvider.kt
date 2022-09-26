package com.makeevrserg.mvvmcore.core.presentation.ui_provider

import android.content.Context
import androidx.fragment.app.Fragment
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners.INextRouteListener
import com.makeevrserg.mvvmcore.core.routing.INavigationProvider
import com.makeevrserg.mvvmcore.core.routing.RouteInfo

fun Fragment.coreNextRouteProvider(navigationProvider: () -> INavigationProvider) = lazy {
    CoreNextRouteProvider(
        contextProvider = { context },
        navigationProvider = navigationProvider
    )
}

class CoreNextRouteProvider(
    val contextProvider: () -> Context?,
    val navigationProvider: () -> INavigationProvider
) : INextRouteListener {
    override fun onRouteInfo(routeInfo: RouteInfo) {
        val navigation = navigationProvider()
        when (routeInfo) {
            is RouteInfo.NextScreen -> {
                if (routeInfo.replaceScreen)
                    navigation.replaceScreen(routeInfo)
                else if (routeInfo.clearBackStack)
                    navigation.clearBackStack(routeInfo)
                else
                    navigation.navigateTo(routeInfo)
            }

            is RouteInfo.PopBack -> navigation.popBack(routeInfo)
            is RouteInfo.Intent<*> -> contextProvider()?.let { context ->
                navigation.intent(context, routeInfo)
            }
        }
    }
}