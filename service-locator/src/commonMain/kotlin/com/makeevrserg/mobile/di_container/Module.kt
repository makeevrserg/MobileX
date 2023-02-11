package com.makeevrserg.mobile.di_container

import kotlin.reflect.KProperty

/**
 * [Module] could be used to create Singletons with only one initialization
 * If you want to use singleton which could be reloadable see [IReloadable]
 */
abstract class Module<T> : Dependency<T> {
    protected abstract fun initializer(): T
    private val lazyValue by lazy {
        initializer()
    }
    override val value: T
        get() = lazyValue
}

fun <T> module(initializer: () -> T) = object : Module<T>() {
    override fun initializer(): T = initializer()
}

inline operator fun <reified T, K> Module<T>.getValue(t: K?, property: KProperty<*>): T = value
