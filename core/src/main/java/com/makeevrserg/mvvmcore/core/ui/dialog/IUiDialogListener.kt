package com.makeevrserg.mvvmcore.core.ui.dialog

import android.app.Dialog
import androidx.lifecycle.LifecycleOwner
import com.makeevrserg.mvvmcore.core.ui.UIDialogMessage
import com.makeevrserg.mvvmcore.core.collectOn
import com.makeevrserg.mvvmcore.core.ui.IContextProvider
import com.makeevrserg.mvvmcore.core.ui.IRootViewProvider
import kotlinx.coroutines.Dispatchers

interface IUiDialogListener : IRootViewProvider, IContextProvider {
    val dialogBuilder: (UIDialogMessage) -> Dialog?
    var currentDialog: Dialog?
    fun collectUiDialog(lifecycleOwner: LifecycleOwner, action: IUIDialogAction) {
        action.uiDialog.collectOn(lifecycleOwner, Dispatchers.Main) {
            if (it == null) {
                currentDialog?.dismiss()
                currentDialog = null
                return@collectOn
            }
            if (currentDialog?.isShowing != true) {
                currentDialog?.dismiss()
                currentDialog = null
            }
            currentDialog = dialogBuilder(it) ?: return@collectOn
            currentDialog?.show()
        }
    }
}