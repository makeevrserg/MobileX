package com.makeevrserg.mobilex.ktx_core.action

import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.makeevrserg.mobilex.ktx_core.action.components.UIMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UIMessageListener(
    override val lifecycleScope: CoroutineScope,
    override val androidViewProvider: AndroidViewProvider
) : IActionCollector {
    fun showUiMessage(uiMessage: UIMessage) {
        val context = androidViewProvider.getViewContext() ?: return
        val view = androidViewProvider.getRootView() ?: return
        when (uiMessage) {
            is UIMessage.SnackBar -> Snackbar.make(
                view,
                uiMessage.uiText.asString(context),
                Snackbar.LENGTH_SHORT
            ).show()

            is UIMessage.Toast -> Toast.makeText(
                context,
                uiMessage.uiText.asString(context),
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    override fun collect(container: IActionContainer) =
        container.uiMessageFlow.collectOnMainLifecycleScope(::showUiMessage)
}
