package com.makeevrserg.mobile.di_container

import kotlinx.coroutines.flow.StateFlow

interface ValueHolder<T> {
    val initial: T
    val flow: StateFlow<T>
    fun update(value: T)
    fun update(block: (T) -> T)
    fun clear()
}
