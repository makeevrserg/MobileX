package com.makeevrserg.mobilex.presentation.stack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makeevrserg.mobilex.ktx_core.action.components.RouteInfo
import com.makeevrserg.mobilex.main.MainActivity
import com.makeevrserg.mobilex.main.NavigationProvider
import com.makeevrserg.mobilex.ktx_core.SingleLiveEvent
import com.makeevrserg.mobilex.ktx_core.action.ActionContainer
import com.makeevrserg.mobilex.ktx_core.action.ActionContainerHost
import com.makeevrserg.mobilex.ktx_core.action.IActionContainer
import com.makeevrserg.mobilex.ktx_core.emptyLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class StackViewModel : ViewModel(), ActionContainerHost {
    override val actionContainer: IActionContainer = ActionContainer()

    companion object {
        var totalActiveViewModels = 0
    }

    val count = totalActiveViewModels++

    fun onClearBackStackClicked() = viewModelScope.launch {
        RouteInfo.NextScreen(NavigationProvider.Stack).navigate()
    }

    fun onIntentClicked()  = viewModelScope.launch {
        RouteInfo.Intent(MainActivity::class.java).navigate()
    }

    fun onPopBackClicked()  = viewModelScope.launch {
        RouteInfo.PopBack.navigate()
    }

    fun onReplaceScreenClicked()  = viewModelScope.launch {

        RouteInfo.ReplaceScreen(NavigationProvider.Stack).navigate()
    }

    fun onNewScreenClicked()  = viewModelScope.launch {
        RouteInfo.NextScreen(NavigationProvider.Stack).navigate()
    }

    fun onViewDestroy() {
        totalActiveViewModels--
    }

}