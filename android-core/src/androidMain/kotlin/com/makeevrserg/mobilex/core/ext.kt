package com.makeevrserg.mobilex.core

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.provider.Settings
import androidx.annotation.IntRange
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.io.Serializable

/**
 * This function is intended to reduce boilerplate and callback-hell
 */
fun <T> MutableStateFlow<T>.collectOn(
    lifecycleOwner: LifecycleOwner,
    scope: CoroutineDispatcher = Dispatchers.Main,
    action: suspend CoroutineScope.(value: T) -> Unit
): Job = lifecycleOwner.lifecycleScope.launch(scope) {
    if (this@collectOn.subscriptionCount.value >= 1) return@launch
    collectLatest {
        action(it)
    }
}

/**
 * Lazy viewModel initialization in activities and fragments
 */
inline fun <reified T : ViewModel> HasDefaultViewModelProviderFactory.lazyViewModel(): Lazy<T> =
    lazy {
        defaultViewModelProviderFactory.create(T::class.java)
    }


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
fun Activity.askPermission(@IntRange(from = 0) requestCode:Int, vararg permissions: String){
    ActivityCompat.requestPermissions(this, permissions, requestCode)
}
