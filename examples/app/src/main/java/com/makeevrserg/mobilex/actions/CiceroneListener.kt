package com.makeevrserg.mobilex.actions

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import com.makeevrserg.mobilex.ktx_core.action.IActionContainer
import com.makeevrserg.mobilex.ktx_core.action.components.RouteInfo
import kotlinx.coroutines.CoroutineScope

class CiceroneListener(
    private val router: Router,
    override val lifecycleScope: CoroutineScope,
    override val androidViewProvider: AndroidViewProvider,
) : IActionCollector {
    fun navigate(it: RouteInfo) {
        when (it) {
            is RouteInfo.ReplaceScreen<*> -> router.replaceScreen(it.screen as Screen)
            is RouteInfo.Intent<*> -> Unit
            is RouteInfo.NextScreen<*> -> router.navigateTo(it.screen as Screen)
            is RouteInfo.PopBack -> router.exit()
        }
    }

    override fun collect(container: IActionContainer) =
        container.uiRouteFlow.collectOnMainLifecycleScope {
            navigate(it)
        }
}