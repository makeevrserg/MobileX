package com.makeevrserg.mobile.di_container

import kotlin.reflect.KProperty

interface IDependency<T> {
    val value: T
}

inline operator fun <reified T, K> IDependency<T>.getValue(t: K?, property: KProperty<*>): T = value