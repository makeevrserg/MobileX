package com.makeevrserg.mvvmcore.core.presentation.ui

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.makeevrserg.mvvmcore.core.UIDialogMessage

object CoreAlertUiDialog : IUiDialogBuilder {
    override fun build(context: Context, uiDialogMessage: UIDialogMessage): Dialog =
        AlertDialog.Builder(context).apply {
            this.setCancelable(uiDialogMessage.isCancellable)
            this.setTitle(uiDialogMessage.title.asString(context))
            this.setMessage(uiDialogMessage.description.asString(context))
            uiDialogMessage.positiveButton?.let { uiDialogButton ->
                this.setPositiveButton(uiDialogButton.text.asString(context)) { dialog, _ ->
                    dialog.cancel()
                    uiDialogButton.onClick()
                }
            }
            uiDialogMessage.negativeButton?.let { uiDialogButton ->
                this.setNegativeButton(uiDialogButton.text.asString(context)) { dialog, _ ->
                    dialog.cancel()
                    uiDialogButton.onClick()
                }
            }
        }.create()
}