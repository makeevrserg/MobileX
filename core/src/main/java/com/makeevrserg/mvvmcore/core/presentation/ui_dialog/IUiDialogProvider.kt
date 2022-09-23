package com.makeevrserg.mvvmcore.core.presentation.ui_dialog

import android.app.Dialog
import android.content.Context
import com.makeevrserg.mvvmcore.core.UIDialogMessage

interface IUiDialogProvider {
    fun provide(context: Context, uiDialogMessage: UIDialogMessage): Dialog
}