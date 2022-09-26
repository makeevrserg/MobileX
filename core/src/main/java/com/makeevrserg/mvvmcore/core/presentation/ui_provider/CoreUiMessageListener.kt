package com.makeevrserg.mvvmcore.core.presentation.ui_provider

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.makeevrserg.mvvmcore.core.UIMessage
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners.IUiMessageListener

fun Fragment.coreUiMessageListener() = lazy {
    CoreUiMessageListener { context }
}

class CoreUiMessageListener(private val contextProvider: () -> Context?) : IUiMessageListener {
    override fun onUiMessage(view: View, uiMessage: UIMessage) {
        val context = contextProvider() ?: return
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
