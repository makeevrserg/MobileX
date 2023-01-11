package com.makeevrserg.mobilex.ktx_core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * This function is intended to reduce boilerplate and callback-hell
 */
fun <T> MutableStateFlow<T>.collectOn(
    lifecycleScope: CoroutineScope,
    scope: CoroutineDispatcher = Dispatchers.Main,
    action: suspend CoroutineScope.(value: T) -> Unit
): Job = lifecycleScope.launch(scope) {
    if (this@collectOn.subscriptionCount.value >= 1) return@launch
    collectLatest {
        action(it)
    }
}