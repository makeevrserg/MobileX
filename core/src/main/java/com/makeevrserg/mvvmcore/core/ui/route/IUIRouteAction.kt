package com.makeevrserg.mvvmcore.core.ui.route

import com.makeevrserg.mvvmcore.core.routing.RouteInfo
import com.makeevrserg.mvvmcore.core.ui.SingleLiveEvent
import com.makeevrserg.mvvmcore.core.ui.singleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow

interface IUIRouteAction {
    val uiRoute: MutableStateFlow<SingleLiveEvent<RouteInfo>>
    fun <T:RouteInfo> T.navigate() {
        uiRoute.value = this.singleLiveEvent()
    }
}