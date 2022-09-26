package com.makeevrserg.mvvmcore.core.presentation.ui

import android.app.Dialog
import android.content.Context
import com.makeevrserg.mvvmcore.core.UIDialogMessage

interface IUiDialogBuilder {
    fun build(context: Context, uiDialogMessage: UIDialogMessage): Dialog
}