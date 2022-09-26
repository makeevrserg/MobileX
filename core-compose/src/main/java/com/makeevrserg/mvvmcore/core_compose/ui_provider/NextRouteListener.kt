package com.makeevrserg.mvvmcore.core_compose.ui_provider

import androidx.compose.runtime.Composable
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners.INextRouteListener
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.providers.INextRouteProvider
import com.makeevrserg.mvvmcore.core.routing.RouteInfo
import com.makeevrserg.mvvmcore.core_compose.collectOn

@Composable
fun NextRouteListener(provider: INextRouteProvider, listener: INextRouteListener) {
    provider.nextRoute.collectOn {
        it.value?.let {
            listener.onRouteInfo(it)
        }
    }
}