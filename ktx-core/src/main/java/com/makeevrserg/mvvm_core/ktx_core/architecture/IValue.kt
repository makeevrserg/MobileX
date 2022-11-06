package com.makeevrserg.mvvm_core.ktx_core.architecture

import kotlin.reflect.KProperty

abstract class IValue<T> {
    protected abstract fun initializer(): T
    val value: T
        get() = initializer()
}
fun <T> value(initializer: () -> T) = object : IValue<T>() {
    override fun initializer(): T = initializer()
}
inline operator fun <reified T, K> IValue<T>.getValue(t: K?, property: KProperty<*>): T = value