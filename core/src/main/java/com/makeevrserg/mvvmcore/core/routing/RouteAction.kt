package com.makeevrserg.mvvmcore.core.routing

/**
 * This class was originally created to handle Cicerone actions
 */
data class RouteAction<T>(
    val key: String,
    val obj: T
)