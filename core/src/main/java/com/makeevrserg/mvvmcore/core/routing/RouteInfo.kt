package com.makeevrserg.mvvmcore.core.routing

import android.content.Context

/**
 * Тут можно будет вложить также интенты и бандлы при необходимости в будещм
 */
sealed class RouteInfo {
    class NextScreen(
        val screenProvider: IScreenProvider,
        val clearBackStack: Boolean = false,
        val replaceScreen: Boolean = false
    ) : RouteInfo()

    object PopBack : RouteInfo()
    class Intent<T>(val clazz: Class<T>) : RouteInfo()
}

interface IScreenProvider

interface INavigationProvider {

    fun replaceScreen(routeInfo: RouteInfo.NextScreen)
    fun clearBackStack(routeInfo: RouteInfo.NextScreen)
    fun navigateTo(routeInfo: RouteInfo.NextScreen)
    fun popBack(routeInfo: RouteInfo.PopBack)
    fun <T> intent(context: Context, routeInfo: RouteInfo.Intent<T>)
}