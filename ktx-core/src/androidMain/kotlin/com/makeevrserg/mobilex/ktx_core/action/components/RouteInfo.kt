package com.makeevrserg.mobilex.ktx_core.action.components

/**
 * This class allows you to navigation from ViewModels
 */
actual sealed interface RouteInfo {
    actual class NextScreen<T> actual constructor(val screen: T) : RouteInfo
    actual object PopBack : RouteInfo
    actual class ReplaceScreen<T> actual constructor(val screen: T): RouteInfo

    class Intent<T>(val clazz: Class<T>) : RouteInfo
}
