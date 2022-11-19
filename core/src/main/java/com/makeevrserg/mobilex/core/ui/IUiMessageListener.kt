package com.makeevrserg.mobilex.core.ui

import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.snackbar.Snackbar
import com.makeevrserg.mobilex.ktx_core.ui.UIMessage
import com.makeevrserg.mobilex.core.collectOn
import com.makeevrserg.mobilex.ktx_core.ui.IUIMessageAction
import kotlinx.coroutines.Dispatchers

interface IUiMessageListener : IRootViewProvider, IContextProvider {

    fun collectUiMessage(lifecycleOwner: LifecycleOwner, action: IUIMessageAction) {
        action.uiMessage.collectOn(lifecycleOwner, Dispatchers.Main) {
            it.value?.let(::showUiMessage)
        }
    }

    fun showUiMessage(uiMessage: UIMessage) {
        val context = contextProvider.invoke() ?: return
        val view = rootProvider.invoke() ?: return
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
}