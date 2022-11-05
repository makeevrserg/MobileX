package com.makeevrserg.mvvm_core.presentation.compose

import android.content.Context
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import com.makeevrserg.mvvmcore.core.routing.IRouter
import com.makeevrserg.mvvmcore.core.routing.RouteInfo

class NavHostRouter(
    private val navHostController: NavHostController,
    private val viewModelStoreOwner: ViewModelStoreOwner
) : IRouter<ComposeScreen> {
    override val isBackStackEmpty: Boolean
        get() = navHostController.backQueue.isEmpty()

    override fun popBack() {
        navHostController.navigateUp()
    }

    override fun <K> intent(context: Context, routeInfo: RouteInfo.Intent<K>) {

    }

    override fun <K : ComposeScreen> clearBackStack(screen: K) {
        navHostController.popBackStack()
    }

    override fun <K : ComposeScreen> replaceScreen(screen: K) {
        navHostController.navigate(screen.createRoute())
    }

    override fun <K : ComposeScreen> nextScreen(screen: K) {
        navHostController.navigate(screen.createRoute())
    }

}