package com.makeevrserg.mvvmcore.core.presentation.ui_provider

import android.content.Context
import androidx.fragment.app.Fragment
import com.makeevrserg.mvvmcore.core.UIDialogMessage
import com.makeevrserg.mvvmcore.core.presentation.ui.IUiDialogBuilder
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners.IUiDialogListener

fun Fragment.coreUiDialogListener(alertDialogProvider: () -> IUiDialogBuilder) = lazy {
    CoreUiDialogListener(
        contextProvider = { context },
        alertDialogProvider = alertDialogProvider
    )
}
class CoreUiDialogListener(
    private val contextProvider: () -> Context?,
    val alertDialogProvider: () -> IUiDialogBuilder,
) : IUiDialogListener {
    override fun onUiDialog(uiDialogMessage: UIDialogMessage) {
        val context = contextProvider() ?: return
        val provider = alertDialogProvider()
        provider.build(context, uiDialogMessage).show()
    }
}
