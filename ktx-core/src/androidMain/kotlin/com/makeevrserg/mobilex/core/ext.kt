package com.makeevrserg.mobilex.core

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.PackageManager
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.annotation.IntRange
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

@SuppressLint("MissingPermission")
fun Context.vibratePhone(length: Long = 200) {
    val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (!vibrator.hasVibrator()) return
    if (Build.VERSION.SDK_INT >= 26) {
        vibrator.vibrate(VibrationEffect.createOneShot(length, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        vibrator.vibrate(length)
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
