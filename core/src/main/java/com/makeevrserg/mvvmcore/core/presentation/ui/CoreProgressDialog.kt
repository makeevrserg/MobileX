package com.makeevrserg.mvvmcore.core.presentation.ui

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import com.makeevrserg.mvvmcore.core.R

object CoreProgressDialog : IProgressDialogBuilder {
    override fun build(context: Context): Dialog = AlertDialog.Builder(context).apply {
        this.setView(R.layout.progress_dialog)
        setCancelable(false)
    }.create().apply {
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
    }

}