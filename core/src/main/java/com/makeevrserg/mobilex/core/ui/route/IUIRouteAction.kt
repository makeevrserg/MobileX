package com.makeevrserg.mobilex.core.ui.route

import com.makeevrserg.mobilex.core.routing.RouteInfo
import com.makeevrserg.mobilex.core.ui.SingleLiveEvent
import com.makeevrserg.mobilex.core.ui.singleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow

interface IUIRouteAction {
    val uiRoute: MutableStateFlow<SingleLiveEvent<RouteInfo>>
    fun <T: RouteInfo> T.navigate() {
        uiRoute.value = this.singleLiveEvent()
    }
}