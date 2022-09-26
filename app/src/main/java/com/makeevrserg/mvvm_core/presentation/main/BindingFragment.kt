package com.makeevrserg.mvvm_core.presentation.main

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.makeevrserg.mvvm_core.main.App
import com.makeevrserg.mvvm_core.main.CiceroneNavigationProvider
import com.makeevrserg.mvvmcore.core.presentation.CoreBindingFragment
import com.makeevrserg.mvvmcore.core.presentation.CoreViewModel
import com.makeevrserg.mvvmcore.core.presentation.ui.CoreProgressDialog
import com.makeevrserg.mvvmcore.core.presentation.ui.CoreAlertUiDialog
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.coreLoadingIndicatorListener
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.coreNextRouteProvider
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.coreUiDialogListener
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.coreUiMessageListener
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners.ILoadingIndicatorListener
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners.INextRouteListener
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners.IUiDialogListener
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners.IUiMessageListener

abstract class BindingFragment<T : ViewBinding, V : CoreViewModel>(bindingFactory: (LayoutInflater) -> T) :
    CoreBindingFragment<T, V>(bindingFactory) {
    override val uiMessageListener: IUiMessageListener by coreUiMessageListener()
    override val uiDialogListener: IUiDialogListener by coreUiDialogListener {
        CoreAlertUiDialog
    }
    override val nextRouteListener: INextRouteListener by coreNextRouteProvider {
        CiceroneNavigationProvider(App.router)
    }
    override val loadingIndicatorListener: ILoadingIndicatorListener by coreLoadingIndicatorListener {
        CoreProgressDialog
    }
}