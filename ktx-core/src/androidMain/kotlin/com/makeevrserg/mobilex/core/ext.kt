@file:Suppress("Filename")

package com.makeevrserg.mobilex.core

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.PackageManager
import android.os.Build
import android.os.Vibrator
import android.os.VibratorManager
import androidx.annotation.IntRange
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService

@SuppressLint("MissingPermission")
fun Context.getVibratorOrNull(): Vibrator? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        getSystemService<VibratorManager>()?.defaultVibrator
    } else {
        getSystemService<Vibrator>()
    }
}

fun Context.hasPermissions(vararg permissions: String) = permissions.all { permission ->
    ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}

fun Activity.askPermission(@IntRange(from = 0) requestCode: Int, vararg permissions: String) {
    ActivityCompat.requestPermissions(this, permissions, requestCode)
}

/**
 * Recursively looking for closest activity
 */
tailrec fun Context.activity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext?.activity()
    else -> null
}
