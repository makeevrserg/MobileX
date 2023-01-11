package com.makeevrserg.mobilex.ktx_core.action

import com.makeevrserg.mobilex.ktx_core.action.components.RouteInfo
import com.makeevrserg.mobilex.ktx_core.action.components.UIDialogMessage
import com.makeevrserg.mobilex.ktx_core.action.components.UIMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface IActionContainer {
    val uiMessageFlow: Flow<UIMessage>
    val uiRouteFlow: Flow<RouteInfo>
    val loadingFlow: Flow<Boolean>
    val uiDialogFlow: MutableStateFlow<UIDialogMessage?>
    fun sendDialog(it: UIDialogMessage?)

    fun setLoading(it: Boolean)

    suspend fun sendRoute(it: RouteInfo)

    suspend fun sendMessage(it: UIMessage)
}
