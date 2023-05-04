package com.makeevrserg.mobilex.core.platform

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual object KDispatchers : KotlinDispatchers {
    actual override val Main: CoroutineDispatcher = Dispatchers.Main
    actual override val IO: CoroutineDispatcher = Dispatchers.Default
    actual override val Default: CoroutineDispatcher = Dispatchers.Default
    actual override val Unconfined: CoroutineDispatcher = Dispatchers.Unconfined
}
