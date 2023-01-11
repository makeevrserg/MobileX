package com.makeevrserg.mobilex

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import com.makeevrserg.mobilex.ktx_core.AndroidRouter
import com.makeevrserg.mobilex.ktx_core.action.components.RouteInfo

class CiceroneRouter(private val router: Router): AndroidRouter {
    override fun popBack() {
        router.exit()
    }

    override fun <T> intent(it: RouteInfo.Intent<T>) {
        TODO("Not yet implemented")
    }

    override fun <T> nextScreen(it: RouteInfo.NextScreen<T>) {
        router.navigateTo(it.screen as Screen)
    }

    override fun <T> replaceScreen(it: RouteInfo.ReplaceScreen<T>) {
        router.replaceScreen(it.screen as Screen)
    }

}