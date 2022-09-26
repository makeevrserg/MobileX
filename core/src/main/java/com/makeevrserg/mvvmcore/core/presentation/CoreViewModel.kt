package com.makeevrserg.mvvmcore.core.presentation

import androidx.lifecycle.ViewModel
import com.makeevrserg.mvvmcore.core.SingleLiveEvent
import com.makeevrserg.mvvmcore.core.UIDialogMessage
import com.makeevrserg.mvvmcore.core.UIMessage
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.providers.ILoadingIndicatorProvider
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.providers.INextRouteProvider
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.providers.IUiDialogProvider
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.providers.IUiMessageProvider
import com.makeevrserg.mvvmcore.core.routing.RouteAction
import com.makeevrserg.mvvmcore.core.routing.RouteInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Not every screen need viewModels, so here's empty one
 */
class EmptyViewModel : CoreViewModel()

/**
 * Basic viewModel for your needs
 */
abstract class CoreViewModel() : ViewModel(),
    IUiMessageProvider,
    IUiDialogProvider,
    ILoadingIndicatorProvider,
    INextRouteProvider {

    protected val _uiMessage = MutableStateFlow<SingleLiveEvent<UIMessage>>(SingleLiveEvent())
    override val uiMessage: StateFlow<SingleLiveEvent<UIMessage>>
        get() = _uiMessage

    protected val _uiDialogMessage = MutableStateFlow<UIDialogMessage?>(null)
    override val uiDialogMessage: StateFlow<UIDialogMessage?>
        get() = _uiDialogMessage

    protected val _loadingIndicator = MutableStateFlow(false)
    override val loadingIndicator: StateFlow<Boolean>
        get() = _loadingIndicator

    protected val _nextRoute = MutableStateFlow<SingleLiveEvent<RouteInfo>>(SingleLiveEvent())
    override val nextRoute: StateFlow<SingleLiveEvent<RouteInfo>>
        get() = _nextRoute


    protected val _routeAction = MutableStateFlow(SingleLiveEvent<RouteAction<*>>())
    val routeAction: StateFlow<SingleLiveEvent<RouteAction<*>>>
        get() = _routeAction


    open fun onBinding() = Unit

    open fun onCreate() = Unit

    init {
        onCreate()
    }
}