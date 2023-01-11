package com.makeevrserg.mobilex.ktx_core

import com.makeevrserg.mobilex.ktx_core.action.components.RouteInfo

interface AndroidRouter {
    fun popBack()
    fun <T> intent(it: RouteInfo.Intent<T>)
    fun <T> nextScreen(it: RouteInfo.NextScreen<T>)
    fun <T> replaceScreen(it: RouteInfo.ReplaceScreen<T>)
    fun navigate(it: RouteInfo) {
        when (it) {
            is RouteInfo.Intent<*> -> intent(it)
            is RouteInfo.NextScreen<*> -> nextScreen(it)
            is RouteInfo.PopBack -> popBack()
            is RouteInfo.ReplaceScreen<*> -> replaceScreen(it)
        }
    }
}