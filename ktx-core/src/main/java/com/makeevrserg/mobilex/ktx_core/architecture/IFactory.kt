package com.makeevrserg.mobilex.ktx_core.architecture

import kotlin.reflect.KProperty

/**
 * IFactory is need for re-creating object, for example, viewModels
 */
fun interface IFactory<T> {
    fun provide(): T
}
inline operator fun <reified T, K> IFactory<T>.getValue(t: K?, property: KProperty<*>): T = provide()