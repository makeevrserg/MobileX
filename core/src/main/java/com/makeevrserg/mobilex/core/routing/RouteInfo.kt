package com.makeevrserg.mobilex.core.routing

/**
 * This class allows you to navigation from ViewModels
 */
sealed class RouteInfo {
    class NextScreen<T>(
        val screen: T,
        val clearBackStack: Boolean = false,
        val replaceScreen: Boolean = false
    ) : RouteInfo()

    object PopBack : RouteInfo()
    class Intent<T>(val clazz: Class<T>) : RouteInfo()
}