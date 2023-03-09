package com.makeevrserg.mobile.di_container

import kotlin.reflect.KProperty

/**
 * [Module] could be used to create Singletons with only one initialization
 * [value] is always the same
 */
abstract class Module<T> : Dependency<T> {
    protected abstract fun initializer(): T
    override val value: T by lazy {
        initializer()
    }
}

/**
 * Creating a [Module] in kotlin-way
 */
fun <T> module(initializer: () -> T) = object : Module<T>() {
    override fun initializer(): T = initializer()
}

/**
 * Get [Module.value]
 */
inline operator fun <reified T, K> Module<T>.getValue(t: K?, property: KProperty<*>): T = value
