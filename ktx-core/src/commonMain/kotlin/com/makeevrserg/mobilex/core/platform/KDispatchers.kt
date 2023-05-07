package com.makeevrserg.mobilex.core.platform

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

/**
 * Workaround for using IO dispatcher with KMM ios sourceSet
 */
object KDispatchers : KotlinDispatchers {
    override val Main: CoroutineDispatcher = Dispatchers.Main
    override val IO: CoroutineDispatcher = Dispatchers.IO
    override val Default: CoroutineDispatcher = Dispatchers.Default
    override val Unconfined: CoroutineDispatcher = Dispatchers.Unconfined
}
