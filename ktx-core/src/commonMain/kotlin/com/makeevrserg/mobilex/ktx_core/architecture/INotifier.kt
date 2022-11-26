package com.makeevrserg.mobilex.ktx_core.architecture

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

interface INotifier<T> {
    val flow: MutableStateFlow<T>
    val initial: T
    fun notify(value: T) {
        flow.update { value }
    }
}
