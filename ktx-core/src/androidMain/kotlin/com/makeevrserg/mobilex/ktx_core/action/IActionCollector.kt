package com.makeevrserg.mobilex.ktx_core.action

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface IActionCollector {
    val androidViewProvider: AndroidViewProvider
    val lifecycleScope: CoroutineScope
    fun collect(container: IActionContainer): Job

    fun <T, K> Flow<T>.collectOnMainLifecycleScope(block: (T) -> K) =
        lifecycleScope.launch(Dispatchers.IO) {
            collectLatest {
                withContext(Dispatchers.Main) {
                    block(it)
                }
            }
        }
}
