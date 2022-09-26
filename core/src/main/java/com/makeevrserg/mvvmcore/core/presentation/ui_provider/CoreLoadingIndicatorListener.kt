package com.makeevrserg.mvvmcore.core.presentation.ui_provider

import android.content.Context
import androidx.fragment.app.Fragment
import com.makeevrserg.mvvmcore.core.presentation.ui.IProgressDialogBuilder
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners.ILoadingIndicatorListener

fun Fragment.coreLoadingIndicatorListener(progressDialogProvider: () -> IProgressDialogBuilder) = lazy {
    CoreLoadingIndicatorListener(
        contextProvider = { context },
        progressDialogProvider = progressDialogProvider
    )
}
class CoreLoadingIndicatorListener(
    val contextProvider: () -> Context?,
    val progressDialogProvider: () -> IProgressDialogBuilder,
) : ILoadingIndicatorListener {
    val progressDialog by lazy {
        val provider = progressDialogProvider()
        contextProvider()?.let(provider::build)
    }

    override fun onLoadingIndication(state: Boolean) {
        if (state) progressDialog?.show()
        else progressDialog?.dismiss()
    }
}