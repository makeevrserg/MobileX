package com.makeevrserg.mobilex.presentation.stack

import androidx.lifecycle.ViewModel
import com.makeevrserg.mobilex.ktx_core.RouteInfo
import com.makeevrserg.mobilex.main.MainActivity
import com.makeevrserg.mobilex.main.NavigationProvider
import com.makeevrserg.mobilex.ktx_core.ui.IUIRouteAction
import com.makeevrserg.mobilex.ktx_core.SingleLiveEvent
import com.makeevrserg.mobilex.ktx_core.emptyLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow

class StackViewModel : ViewModel(), IUIRouteAction {
    companion object {
        var totalActiveViewModels = 0
    }

    override val uiRoute: MutableStateFlow<SingleLiveEvent<RouteInfo>> by emptyLiveEvent()

    val count = totalActiveViewModels++

    fun onClearBackStackClicked() {
        RouteInfo.NextScreen(NavigationProvider.Stack, clearBackStack = true).navigate()
    }

    fun onIntentClicked() {
        RouteInfo.Intent(MainActivity::class.java).navigate()
    }

    fun onPopBackClicked() {
        RouteInfo.PopBack.navigate()
    }

    fun onReplaceScreenClicked() {
        RouteInfo.NextScreen(NavigationProvider.Stack, replaceScreen = true).navigate()
    }

    fun onNewScreenClicked() {
        RouteInfo.NextScreen(NavigationProvider.Stack).navigate()
    }

    fun onViewDestroy() {
        totalActiveViewModels--
    }

}