package com.makeevrserg.mobilex.ktx_core.architecture

import kotlin.reflect.KProperty

interface IDependency<T> {
    val value: T
}

inline operator fun <reified T, K> IDependency<T>.getValue(t: K?, property: KProperty<*>): T = value