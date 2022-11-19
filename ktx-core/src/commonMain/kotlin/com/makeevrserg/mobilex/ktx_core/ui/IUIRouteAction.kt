package com.makeevrserg.mobilex.ktx_core.ui

import com.makeevrserg.mobilex.ktx_core.RouteInfo
import com.makeevrserg.mobilex.ktx_core.SingleLiveEvent
import com.makeevrserg.mobilex.ktx_core.emptyLiveEvent
import com.makeevrserg.mobilex.ktx_core.singleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow

interface IUIRouteAction {
    val uiRoute: MutableStateFlow<SingleLiveEvent<RouteInfo>>
    fun <T : RouteInfo> T.navigate() {
        uiRoute.value = this.singleLiveEvent()
    }
}

class UIRouteAction : IUIRouteAction {
    override val uiRoute: MutableStateFlow<SingleLiveEvent<RouteInfo>> by emptyLiveEvent()
}