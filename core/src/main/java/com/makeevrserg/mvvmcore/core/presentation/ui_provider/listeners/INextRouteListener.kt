package com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners

import com.makeevrserg.mvvmcore.core.routing.RouteInfo

interface INextRouteListener {
    fun onRouteInfo(routeInfo: RouteInfo)
}