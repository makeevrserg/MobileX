package com.makeevrserg.mobilex.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * This function is intended to reduce boilerplate and callback-hell
 */
fun <T> Flow<T>.collectOn(
    lifecycleScope: CoroutineScope,
    scope: CoroutineDispatcher = Dispatchers.Main,
    action: suspend CoroutineScope.(value: T) -> Unit
): Job = lifecycleScope.launch(scope) {
    collectLatest {
        action(it)
    }
}
