package com.makeevrserg.mobilex.mvi

import kotlinx.coroutines.flow.updateAndGet

inline fun <reified T : Any> ContainerHost<T, *, *>.reduce(block: (T) -> T): T {
    return this.container.mutableStateFlow.updateAndGet(block)
}

inline fun <reified T : Any,reified K : T> ContainerHost<T, *, *>.reduceState(block: (K) -> T): T {
    return this.container.mutableStateFlow.updateAndGet {
        (it as? K)?.let(block) ?: it
    }
}

suspend fun <T : Any> ContainerHost<*, T, *>.sideEffect(effect: T) {
    return this.container.send(effect)
}

suspend fun <T : Any> ContainerHost<*, T, *>.sideEffect(block: ()->T) {
    return this.container.send(block())
}
fun <T : Any> ContainerHost<*, *, T>.intent(block: ()->T) {
    return this.onIntent(block())
}