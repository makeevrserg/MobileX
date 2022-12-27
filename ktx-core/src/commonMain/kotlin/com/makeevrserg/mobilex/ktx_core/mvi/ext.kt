package com.makeevrserg.mobilex.ktx_core.mvi

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.updateAndGet

inline fun <reified T : Any> ContainerHost<T, *, *>.reduce(block: (T) -> T): T {
    return this.container.stateFlow.updateAndGet(block)
}

inline fun <reified T : Any, K : T> ContainerHost<T, *, *>.reduceState(block: (K) -> T): T {
    return this.container.stateFlow.updateAndGet {
        (it as? K)?.let(block) ?: it
    }
}

suspend fun <T : Any> ContainerHost<*, T, *>.sideEffect(effect: T) {
    return this.container.send(effect)
}