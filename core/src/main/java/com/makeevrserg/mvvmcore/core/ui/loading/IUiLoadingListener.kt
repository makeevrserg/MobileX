package com.makeevrserg.mvvmcore.core.ui.loading

import android.app.Dialog
import androidx.lifecycle.LifecycleOwner
import com.makeevrserg.mvvmcore.core.collectOn
import com.makeevrserg.mvvmcore.core.ui.IContextProvider
import com.makeevrserg.mvvmcore.core.ui.IRootViewProvider
import kotlinx.coroutines.Dispatchers

interface IUiLoadingListener : IRootViewProvider, IContextProvider {
    val loadingDialogBuilder: () -> Dialog?
    var currentLoadingDialog: Dialog?
    fun collectUiLoading(lifecycleOwner: LifecycleOwner, action: IUILoadingAction) {
        action.uiLoading.collectOn(lifecycleOwner, Dispatchers.Main) {
            if (it != true) {
                val dialog = currentLoadingDialog
                currentLoadingDialog = null
                dialog?.dismiss()
                return@collectOn
            }
            if (currentLoadingDialog?.isShowing != true) {
                val dialog = currentLoadingDialog
                currentLoadingDialog = null
                dialog?.dismiss()
            }
            currentLoadingDialog = loadingDialogBuilder() ?: return@collectOn
            currentLoadingDialog?.show()
        }
    }
}