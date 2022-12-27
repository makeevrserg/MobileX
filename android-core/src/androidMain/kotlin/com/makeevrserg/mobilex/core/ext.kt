package com.makeevrserg.mobilex.core

import android.os.Build
import android.os.Bundle
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
