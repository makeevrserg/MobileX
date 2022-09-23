package com.makeevrserg.mvvmcore.core.presentation.progress_dialog

import android.app.Dialog
import android.content.Context

interface IProgressDialog {
    fun provide(context: Context): Dialog
}

