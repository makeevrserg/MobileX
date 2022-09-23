package com.makeevrserg.mvvmcore.core.presentation.intent_manager

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.makeevrserg.mvvmcore.core.UIDialogMessage
import com.makeevrserg.mvvmcore.core.UIMessage
import com.makeevrserg.mvvmcore.core.presentation.CoreViewModel
import com.makeevrserg.mvvmcore.core.presentation.progress_dialog.IProgressDialog
import com.makeevrserg.mvvmcore.core.presentation.ui_dialog.IUiDialogProvider
import com.makeevrserg.mvvmcore.core.routing.INavigationProvider
import com.makeevrserg.mvvmcore.core.routing.RouteAction
import com.makeevrserg.mvvmcore.core.routing.RouteInfo

class CoreIntentManager<T : CoreViewModel>(
    override val viewModel: T,
    val contextProvider: () -> Context?,
    val progressDialogProvider: () -> IProgressDialog,
    val alertDialogProvider: () -> IUiDialogProvider,
    val navigationProvider: INavigationProvider
) : IIntentManager<T> {

    val progressDialog by lazy {
        val provider = progressDialogProvider()
        contextProvider()?.let(provider::provide)
    }

    override fun onUiDialogMessage(it: UIDialogMessage) {
        val context = contextProvider() ?: return
        val provider = alertDialogProvider()
        provider.provide(context, it).show()
    }

    override fun onUiMessage(view: View, it: UIMessage) {
        val context = contextProvider() ?: return
        when (it) {
            is UIMessage.SnackBar -> Snackbar.make(
                view,
                it.uiText.asString(context),
                Snackbar.LENGTH_SHORT
            ).show()

            is UIMessage.Toast -> Toast.makeText(
                context,
                it.uiText.asString(context),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onLoadingIndicator(isLoading: Boolean) {
        if (isLoading) progressDialog?.show()
        else progressDialog?.dismiss()
    }

    override fun <K> onRouteAction(it: RouteAction<K>) {

    }

    override fun onRouteInfo(it: RouteInfo) {
        when (it) {
            is RouteInfo.NextScreen -> {
                if (it.replaceScreen)
                    navigationProvider.replaceScreen(it)
                else if (it.clearBackStack)
                    navigationProvider.clearBackStack(it)
                else
                    navigationProvider.navigateTo(it)
            }

            is RouteInfo.PopBack -> navigationProvider.popBack(it)
            is RouteInfo.Intent<*> -> contextProvider()?.let { context ->
                navigationProvider.intent(context, it)
            }
        }
    }

}