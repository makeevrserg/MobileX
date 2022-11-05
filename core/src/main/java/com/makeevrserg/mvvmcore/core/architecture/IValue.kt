package com.makeevrserg.mvvmcore.core.architecture

abstract class IValue<T> {
    protected abstract fun initializer(): T
    val value: T
        get() = initializer()
}