package com.makeevrserg.mobilex.ktx_core.platform

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Workaround for using IO dispatcher with KMM ios sourceSet
 */
actual object KDispatchers : KotlinDispatchers {
    actual override val Main: CoroutineDispatcher = Dispatchers.Main
    actual override val IO: CoroutineDispatcher = Dispatchers.Default
    actual override val Default: CoroutineDispatcher = Dispatchers.Default
    actual override val Unconfined: CoroutineDispatcher = Dispatchers.Unconfined
}