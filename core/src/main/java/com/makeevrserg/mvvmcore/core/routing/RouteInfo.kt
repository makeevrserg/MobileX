package com.makeevrserg.mvvmcore.core.routing

import android.content.Context

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

interface INavigationProvider<T> {

    fun replaceScreen(routeInfo: RouteInfo.NextScreen<T>)
    fun clearBackStack(routeInfo: RouteInfo.NextScreen<T>)
    fun navigateTo(routeInfo: RouteInfo.NextScreen<T>)
    fun popBack(routeInfo: RouteInfo.PopBack)
    fun <K> intent(context: Context, routeInfo: RouteInfo.Intent<K>)
}