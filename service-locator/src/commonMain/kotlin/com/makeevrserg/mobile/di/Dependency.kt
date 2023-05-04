package com.makeevrserg.mobile.di

import kotlin.reflect.KProperty

/**
 * Parent interface for all container types
 */
interface Dependency<T> {
    val value: T
}

/**
 * Fetch your dependency [Dependency.value]
 * be aware that [Factory.value] will be different on each [Dependency.value] call
 */
inline operator fun <reified T, K> Dependency<T>.getValue(t: K?, property: KProperty<*>): T = value
