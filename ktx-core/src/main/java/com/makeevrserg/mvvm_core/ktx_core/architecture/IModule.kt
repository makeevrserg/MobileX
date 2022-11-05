package com.makeevrserg.mvvm_core.ktx_core.architecture

abstract class IModule<T> {
    protected abstract fun initializer(): T
    private val lazyValue by lazy {
        initializer()
    }
    val value: T
        get() = lazyValue
}