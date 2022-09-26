package com.makeevrserg.mvvmcore.core.presentation.ui

import android.app.Dialog
import android.content.Context

interface IProgressDialogBuilder {
    fun build(context: Context): Dialog
}

