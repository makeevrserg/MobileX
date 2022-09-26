package com.makeevrserg.mvvmcore.core

/**
 * Converting object into SingleLiveEvent sou you won't need to wrap it in class
 */
fun <T> T.singleLiveEvent() = SingleLiveEvent(this)

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