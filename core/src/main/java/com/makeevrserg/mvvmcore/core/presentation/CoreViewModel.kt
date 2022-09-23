package com.makeevrserg.mvvmcore.core.presentation

import androidx.lifecycle.ViewModel
import com.makeevrserg.mvvmcore.core.SingleLiveEvent
import com.makeevrserg.mvvmcore.core.UIDialogMessage
import com.makeevrserg.mvvmcore.core.UIMessage
import com.makeevrserg.mvvmcore.core.routing.RouteAction
import com.makeevrserg.mvvmcore.core.routing.RouteInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Не всем экранам нужны ViewModel'и
 */
class EmptyViewModel : CoreViewModel()

/**
 * Базовая ViewModel для экранов - есть некоторые штуки из RX, с которыми в принципе, нет взаимодействия из вне
 */
abstract class CoreViewModel() : ViewModel() {

    /**
     * UI message, которое обсервится во фрагменте
     * Возможно, можно заменить на MutableSharedFlow чтобы не использовать SingleLiveEvent
     */
    protected val _uiMessage = MutableStateFlow<SingleLiveEvent<UIMessage>>(SingleLiveEvent())
    val uiMessage: StateFlow<SingleLiveEvent<UIMessage>>
        get() = _uiMessage

    protected val _uiDialogMessage = MutableStateFlow<UIDialogMessage?>(null)
    val uiDialogMessage: StateFlow<UIDialogMessage?>
        get() = _uiDialogMessage

    /**
     * На экранах можно поставить загрузку, которая блокирует пользовательский Interaction
     */
    protected val _loadingIndicator = MutableStateFlow(false)
    val loadingIndicator: StateFlow<Boolean>
        get() = _loadingIndicator

    /**
     * Навигация во ViewModel'и
     */
    protected val _nextRoute = MutableStateFlow<SingleLiveEvent<RouteInfo>>(SingleLiveEvent())
    val nextRoute: StateFlow<SingleLiveEvent<RouteInfo>>
        get() = _nextRoute


    /**
     * Передача параметров из фрагмента в фрагмент
     */
    protected val _routeAction = MutableStateFlow(SingleLiveEvent<RouteAction<*>>())
    val routeAction: StateFlow<SingleLiveEvent<RouteAction<*>>>
        get() = _routeAction


    /**
     * При первом биндинге - вызывается эта функция
     */
    open fun onBinding() = Unit

    open fun onCreate() = Unit

    init {
        onCreate()
    }
}