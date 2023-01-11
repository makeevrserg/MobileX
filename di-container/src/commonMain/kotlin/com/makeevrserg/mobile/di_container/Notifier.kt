package com.makeevrserg.mobile.di_container

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

interface Notifier<T> {
    val flow: MutableStateFlow<T>
    val initial: T
    fun update(value: T) {
        flow.update { value }
    }

    fun update(block: (T) -> T) {
        flow.update { block(it) }
    }
}
