package com.makeevrserg.mvvmcore.core.ui

import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.properties.ReadOnlyProperty

/**
 * Converting object into SingleLiveEvent sou you won't need to wrap it in class
 */
fun <T> T.singleLiveEvent() = SingleLiveEvent(this)
fun <T> emptyLiveEvent(): Lazy<MutableStateFlow<SingleLiveEvent<T>>> = lazy { ->
    MutableStateFlow(SingleLiveEvent<T>())
}
fun <T> nullableStateFlow(): Lazy<MutableStateFlow<T?>> = lazy { ->
    MutableStateFlow(null)
}

/**
 * This class is useful for creating single events
 * For example: Message, Routing
 */
class SingleLiveEvent<T>() {
    var value: T? = null
        private set
        get() {
            val value = field
            this.value = null
            return value
        }

    constructor(value: T) : this() {
        this.value = value
    }
}