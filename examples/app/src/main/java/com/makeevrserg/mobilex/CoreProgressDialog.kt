package com.makeevrserg.mobilex

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
object CoreProgressDialog {
    fun build(context: Context): Dialog = AlertDialog.Builder(context).apply {
        this.setView(R.layout.progress_dialog)
        setCancelable(false)
    }.create().apply {
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
    }

}