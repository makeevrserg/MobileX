package com.makeevrserg.mvvm_core.ktx_core.architecture

abstract class IValue<T> {
    protected abstract fun initializer(): T
    val value: T
        get() = initializer()
}