package com.makeevrserg.mvvm_core.presentation.compose

sealed class ComposeScreen(val route: String) {
    open fun createRoute() = route
    object Main : ComposeScreen("main")
    class Custom(val displayText: String) : ComposeScreen(route) {
        override fun createRoute(): String {
            return withArgs("string" to displayText)
        }
        companion object {
            const val route: String = "custom"
        }
    }

    fun <T> withArgs(vararg args: Pair<String, T>): String = withArgs(args.toMap())
    fun <T> withArgs(args: Pair<String, T>): String = withArgs(mapOf(args))
    fun <T> withArgs(args: Map<String, T>): String {
        if (args.isEmpty()) return route
        val route = "$route?" + args.map { "${it.key}=${it.value}" }.joinToString("&")
        println(route)
        return route
    }
}