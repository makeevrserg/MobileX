package com.makeevrserg.mobilex.ktx_core.action

import com.makeevrserg.mobilex.ktx_core.action.components.RouteInfo
import com.makeevrserg.mobilex.ktx_core.action.components.UIDialogMessage
import com.makeevrserg.mobilex.ktx_core.action.components.UIMessage
import com.makeevrserg.mobilex.ktx_core.action.components.UiText

interface ActionContainerHost {
    val actionContainer: IActionContainer

    suspend fun <T : RouteInfo> T.navigate() {
        actionContainer.sendRoute(this)
    }

    suspend fun UiText.sendToast() {
        actionContainer.sendMessage(UIMessage.Toast(this))
    }

    suspend fun UiText.sendSnackbar() {
        actionContainer.sendMessage(UIMessage.SnackBar(this))
    }

    fun setLoading(it:Boolean){
        actionContainer.setLoading(it)
    }

    fun UIDialogMessage.send() {
        actionContainer.sendDialog(this)
    }

    fun clearUiDialog() {
        actionContainer.sendDialog(null)
    }

}