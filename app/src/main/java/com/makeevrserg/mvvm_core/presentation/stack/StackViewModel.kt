package com.makeevrserg.mvvm_core.presentation.stack

import com.makeevrserg.mvvm_core.main.MainActivity
import com.makeevrserg.mvvm_core.main.NavigationProvider
import com.makeevrserg.mvvmcore.core.presentation.CoreViewModel
import com.makeevrserg.mvvmcore.core.routing.RouteInfo
import com.makeevrserg.mvvmcore.core.singleLiveEvent

class StackViewModel : CoreViewModel() {
    companion object {
        var totalActiveViewModels = 0
    }

    val count = totalActiveViewModels++

    fun onClearBackStackClicked() {
        _nextRoute.value =
            RouteInfo.NextScreen(NavigationProvider.Stack, clearBackStack = true).singleLiveEvent()
    }

    fun onIntentClicked() {
        _nextRoute.value = RouteInfo.Intent(MainActivity::class.java).singleLiveEvent()
    }

    fun onPopBackClicked() {
        _nextRoute.value = RouteInfo.PopBack.singleLiveEvent()
    }

    fun onReplaceScreenClicked() {
        _nextRoute.value =
            RouteInfo.NextScreen(NavigationProvider.Stack, replaceScreen = true).singleLiveEvent()
    }

    fun onNewScreenClicked() {
        _nextRoute.value =
            RouteInfo.NextScreen(NavigationProvider.Stack).singleLiveEvent()
    }

    fun onViewDestroy() {
        totalActiveViewModels--
    }
}