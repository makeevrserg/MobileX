package com.makeevrserg.mobilex.ktx_core.architecture

import kotlin.reflect.KProperty

abstract class ILateinit<T : Any> {
    fun initialize(value: T) {
        if (this::value.isInitialized) throw IllegalStateException("Lateinit value already initialized!")
        this.value = value
    }

    lateinit var value: T
        private set
}
inline operator fun <reified T: Any, K> ILateinit<T>.getValue(t: K?, property: KProperty<*>): T = value
