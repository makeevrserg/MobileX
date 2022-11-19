package com.makeevrserg.mobilex.core.ui

import android.app.Dialog
import androidx.lifecycle.LifecycleOwner
import com.makeevrserg.mobilex.ktx_core.UIDialogMessage
import com.makeevrserg.mobilex.core.collectOn
import com.makeevrserg.mobilex.core.ui.IContextProvider
import com.makeevrserg.mobilex.core.ui.IRootViewProvider
import com.makeevrserg.mobilex.ktx_core.ui.IUIDialogAction
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
