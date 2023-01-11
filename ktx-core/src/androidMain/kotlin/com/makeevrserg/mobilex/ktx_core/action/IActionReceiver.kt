package com.makeevrserg.mobilex.ktx_core.action

import com.makeevrserg.mobilex.ktx_core.action.components.RouteInfo
import com.makeevrserg.mobilex.ktx_core.action.components.UIDialogMessage
import com.makeevrserg.mobilex.ktx_core.action.components.UIMessage

interface IActionReceiver {
    suspend fun onUiMessage(it: UIMessage)
    suspend fun onRoute(it: RouteInfo)
    suspend fun onLoading(it: Boolean)
    suspend fun onDialog(it: UIDialogMessage?)
}