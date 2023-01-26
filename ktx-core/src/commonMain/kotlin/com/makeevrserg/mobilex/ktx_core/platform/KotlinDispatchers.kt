package com.makeevrserg.mobilex.ktx_core.platform

import kotlinx.coroutines.CoroutineDispatcher

interface KotlinDispatchers {
    val Main: CoroutineDispatcher
    val IO: CoroutineDispatcher
    val Default: CoroutineDispatcher
    val Unconfined: CoroutineDispatcher
}