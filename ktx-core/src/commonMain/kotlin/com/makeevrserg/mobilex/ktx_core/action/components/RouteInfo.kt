package com.makeevrserg.mobilex.ktx_core.action.components

expect sealed interface RouteInfo {
    object PopBack : RouteInfo
    class ReplaceScreen<T>(screen: T): RouteInfo
    class NextScreen<T>(screen: T): RouteInfo
}



