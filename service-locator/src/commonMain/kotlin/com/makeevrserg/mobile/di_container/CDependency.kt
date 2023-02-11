package com.makeevrserg.mobile.di_container

import kotlin.reflect.KProperty

/**
 * Working-out for ios Swift
 */
class CDependency<T>(private val dependency: Dependency<T>) : Dependency<T> by dependency

inline operator fun <reified T, K> CDependency<T>.getValue(t: K?, property: KProperty<*>): T = value

inline fun <reified T> Dependency<T>.cDependency(): CDependency<T> = CDependency(this)
