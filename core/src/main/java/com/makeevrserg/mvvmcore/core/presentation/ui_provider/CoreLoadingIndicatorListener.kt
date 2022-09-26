package com.makeevrserg.mvvmcore.core.presentation.ui_provider

import android.content.Context
import androidx.fragment.app.Fragment
import com.makeevrserg.mvvmcore.core.presentation.progress_dialog.IProgressDialog
import com.makeevrserg.mvvmcore.core.routing.INavigationProvider

fun Fragment.coreLoadingIndicatorListener(progressDialogProvider: () -> IProgressDialog) = lazy {
    CoreLoadingIndicatorListener(
        contextProvider = { context },
        progressDialogProvider = progressDialogProvider
    )
}
class CoreLoadingIndicatorListener(
    val contextProvider: () -> Context?,
    val progressDialogProvider: () -> IProgressDialog,
) : ILoadingIndicatorListener {
    val progressDialog by lazy {
        val provider = progressDialogProvider()
        contextProvider()?.let(provider::provide)
    }

    override fun onLoadingIndication(state: Boolean) {
        if (state) progressDialog?.show()
        else progressDialog?.dismiss()
    }
}