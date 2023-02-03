package com.makeevrserg.mobile.di_container

import kotlin.reflect.KProperty

/**
 * Is there a better way?
 * [Lateinit] need to store Context for example and other stuff
 */
class Lateinit<T : Any> : Dependency<T> {
    fun initialize(value: T) {
        if (this::value.isInitialized) throw IllegalStateException("Lateinit value already initialized!")
        this.value = value
    }

    override lateinit var value: T
        private set
}

inline operator fun <reified T : Any, K> Lateinit<T>.getValue(t: K?, property: KProperty<*>): T = value
