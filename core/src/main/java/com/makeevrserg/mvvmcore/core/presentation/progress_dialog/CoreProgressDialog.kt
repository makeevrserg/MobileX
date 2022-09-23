package com.makeevrserg.mvvmcore.core.presentation.progress_dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import com.makeevrserg.mvvmcore.core.R

object CoreProgressDialog : IProgressDialog {
    override fun provide(context: Context): Dialog = AlertDialog.Builder(context).apply {
        this.setView(R.layout.progress_dialog)
        setCancelable(false)
    }.create().apply {
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
    }

}