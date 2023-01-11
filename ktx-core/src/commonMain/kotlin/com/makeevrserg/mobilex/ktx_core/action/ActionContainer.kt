package com.makeevrserg.mobilex.ktx_core.action

import com.makeevrserg.mobilex.ktx_core.action.components.RouteInfo
import com.makeevrserg.mobilex.ktx_core.action.components.UIDialogMessage
import com.makeevrserg.mobilex.ktx_core.action.components.UIMessage
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow


class ActionContainer : IActionContainer {

    private val _uiMessageChannel: Channel<UIMessage> = Channel<UIMessage>()
    override val uiMessageFlow: Flow<UIMessage> = _uiMessageChannel.receiveAsFlow()

    private val _uiRouteChannel: Channel<RouteInfo> = Channel<RouteInfo>()
    override val uiRouteFlow: Flow<RouteInfo> = _uiRouteChannel.receiveAsFlow()

    override val loadingFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)

    override val uiDialogFlow: MutableStateFlow<UIDialogMessage?> = MutableStateFlow(null)

    override fun sendDialog(it: UIDialogMessage?) {
        uiDialogFlow.value = it
    }

    override fun setLoading(it: Boolean) {
        loadingFlow.value = it
    }

    override suspend fun sendRoute(it: RouteInfo) {
        _uiRouteChannel.send(it)
    }

    override suspend fun sendMessage(it: UIMessage) {
        _uiMessageChannel.send(it)
    }
}