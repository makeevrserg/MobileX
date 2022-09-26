package com.makeevrserg.mvvmcore.core.presentation.ui_provider

import android.content.Context
import androidx.fragment.app.Fragment
import com.makeevrserg.mvvmcore.core.UIDialogMessage
import com.makeevrserg.mvvmcore.core.presentation.CoreBindingFragment
import com.makeevrserg.mvvmcore.core.presentation.ui_dialog.IUiDialogProvider

fun Fragment.coreUiDialogListener(alertDialogProvider: () -> IUiDialogProvider) = lazy {
    CoreUiDialogListener(
        contextProvider = { context },
        alertDialogProvider = alertDialogProvider
    )
}
class CoreUiDialogListener(
    private val contextProvider: () -> Context?,
    val alertDialogProvider: () -> IUiDialogProvider,
) : IUiDialogListener {
    override fun onUiDialog(uiDialogMessage: UIDialogMessage) {
        val context = contextProvider() ?: return
        val provider = alertDialogProvider()
        provider.provide(context, uiDialogMessage).show()
    }
}
