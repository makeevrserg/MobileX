package com.makeevrserg.mobilex.ktx_core.platform

import kotlinx.coroutines.CoroutineDispatcher

/**
 * You can pass dispatchers also as interface in your DI
 */
interface KotlinDispatchers {
    val Main: CoroutineDispatcher
    val IO: CoroutineDispatcher
    val Default: CoroutineDispatcher
    val Unconfined: CoroutineDispatcher
}