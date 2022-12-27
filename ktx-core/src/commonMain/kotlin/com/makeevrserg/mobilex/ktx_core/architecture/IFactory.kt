package com.makeevrserg.mobilex.ktx_core.architecture

import kotlin.reflect.KProperty

/**
 * IFactory is need for re-creating object, for example, viewModels
 */
abstract class IFactory<T> : IDependency<T> {
    protected abstract fun initializer(): T
    override val value: T
        get() = initializer()
}

fun <T> value(initializer: () -> T) = object : IFactory<T>() {
    override fun initializer(): T = initializer()
}

inline operator fun <reified T, K> IFactory<T>.getValue(t: K?, property: KProperty<*>): T = value