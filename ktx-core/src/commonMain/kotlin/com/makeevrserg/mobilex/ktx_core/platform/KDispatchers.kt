package com.makeevrserg.mobilex.ktx_core.platform

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
/**
 * Workaround for using IO dispatcher with KMM ios sourceSet
 */
expect object KDispatchers: KotlinDispatchers {
    override val Main: CoroutineDispatcher
    override val IO: CoroutineDispatcher
    override val Default: CoroutineDispatcher
    override val Unconfined: CoroutineDispatcher
}
