package com.makeevrserg.mvvmcore.core.routing

data class RouteAction<T>(
    val key: String,
    val obj: T
)