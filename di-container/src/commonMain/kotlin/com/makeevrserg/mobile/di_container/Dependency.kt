package com.makeevrserg.mobile.di_container

import kotlin.reflect.KProperty

/**
 * Parent interface for all container types
 */
interface Dependency<T> {
    val value: T
}

inline operator fun <reified T, K> Dependency<T>.getValue(t: K?, property: KProperty<*>): T = value