package com.makeevrserg.mvvmcore.core.presentation.ui_provider.providers

import com.makeevrserg.mvvmcore.core.SingleLiveEvent
import com.makeevrserg.mvvmcore.core.routing.RouteInfo
import kotlinx.coroutines.flow.StateFlow

interface INextRouteProvider {
    val nextRoute: StateFlow<SingleLiveEvent<RouteInfo>>
}