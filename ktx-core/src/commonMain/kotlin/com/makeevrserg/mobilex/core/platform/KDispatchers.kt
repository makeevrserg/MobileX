package com.makeevrserg.mobilex.core.platform

import kotlinx.coroutines.CoroutineDispatcher
/**
 * Workaround for using IO dispatcher with KMM ios sourceSet
 */
expect object KDispatchers : KotlinDispatchers {
    override val Main: CoroutineDispatcher
    override val IO: CoroutineDispatcher
    override val Default: CoroutineDispatcher
    override val Unconfined: CoroutineDispatcher
}
