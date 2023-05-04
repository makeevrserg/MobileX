package com.makeevrserg.mobile.di

import kotlin.reflect.KProperty

/**
 * Is there a better way?
 * [Lateinit] need to store Context for example and other stuff
 * [value] is always the same
 */
class Lateinit<T : Any> : Dependency<T> {
    fun initialize(value: T) {
        check(this::value.isInitialized) { "Lateinit value already initialized!" }
        this.value = value
    }

    override lateinit var value: T
        private set
}

/**
 * Getting [Lateinit.value]
 */
inline operator fun <reified T : Any, K> Lateinit<T>.getValue(t: K?, property: KProperty<*>): T = value
