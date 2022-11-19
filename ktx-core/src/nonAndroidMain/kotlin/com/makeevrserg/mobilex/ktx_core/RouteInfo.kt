package com.makeevrserg.mobilex.ktx_core

/**
 * This class allows you to navigation from ViewModels
 */
actual sealed interface RouteInfo {
    class NextScreen<T>(
        val screen: T,
        val clearBackStack: Boolean = false,
        val replaceScreen: Boolean = false
    ) : RouteInfo

    object PopBack : RouteInfo
}
