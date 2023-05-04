package com.makeevrserg.mobile.di

/**
 * [Factory] is useful for re-creating object, for example, viewModels
 * [value] is different on each method call
 */
abstract class Factory<T> : Dependency<T> {
    protected abstract fun initializer(): T
    override val value: T
        get() = initializer()
}

/**
 * Create [Factory] in kotlin-way
 */
fun <T> factory(initializer: () -> T) = object : Factory<T>() {
    override fun initializer(): T = initializer()
}
