package com.makeevrserg.mvvmcore.core

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

inline fun <reified T : Serializable> simpleName() = T::class.java.simpleName

/**
 * Save [Serializable] in bundle without passing a name
 */
inline fun <reified T : Serializable> Bundle.getSerializable(): T? =
    getSerializable(this, simpleName<T>(), T::class.java)

/**
 * Get [Serializable] from bundle without passing a name and consider a version
 */
fun <T : Serializable> getSerializable(bundle: Bundle, key: String, clazz: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= 33) {
        bundle.getSerializable(key, clazz)
    } else bundle.getSerializable(key) as? T?
}

/**
 * When you'll recieve null from api, for example, this function will make a few attemptes to fetch non-null value
 */
suspend fun <T> withGenericAttempt(maxAmount: Int, block: suspend () -> T?): T? {
    var attemptsLeft = maxAmount
    var result = block()
    while (result == null && attemptsLeft > 0) {
        result = block()
        attemptsLeft--
    }
    return result
}