package com.makeevrserg.mobilex.core.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

/**
 * Workaround for using IO dispatcher with KMM ios sourceSet
 */
object DefaultKotlinDispatchers : KotlinDispatchers {
    override val Main: CoroutineDispatcher
        get() = Dispatchers.Main
    override val IO: CoroutineDispatcher
        get() = Dispatchers.IO
    override val Default: CoroutineDispatcher
        get() = Dispatchers.Default
    override val Unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined
}
