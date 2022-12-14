package com.makeevrserg.mobilex.core.routing

import android.content.Context
import com.makeevrserg.mobilex.ktx_core.RouteInfo

interface IRouter<T> {
    val isBackStackEmpty: Boolean
    fun <K : T> nextScreen(screen: K)
    fun <K : T> replaceScreen(screen: K)
    fun <K : T> clearBackStack(screen: K)
    fun popBack()
    fun <K> intent(context: Context, routeInfo: RouteInfo.Intent<K>)
}