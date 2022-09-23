package com.makeevrserg.mvvm_core.main

import android.content.Context
import android.content.Intent
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.makeevrserg.mvvmcore.core.routing.INavigationProvider
import com.makeevrserg.mvvmcore.core.routing.RouteInfo

class CiceroneNavigationProvider(private val router: Router) : INavigationProvider {
    override fun replaceScreen(routeInfo: RouteInfo.NextScreen) {
        router.replaceScreen(routeInfo.screenProvider as FragmentScreen)
    }

    override fun clearBackStack(routeInfo: RouteInfo.NextScreen) {
        router.newRootChain(routeInfo.screenProvider as FragmentScreen)
    }

    override fun navigateTo(routeInfo: RouteInfo.NextScreen) {
        router.navigateTo(routeInfo.screenProvider as FragmentScreen)
    }

    override fun popBack(routeInfo: RouteInfo.PopBack) {
        router.exit()
    }

    override fun <T> intent(context: Context, routeInfo: RouteInfo.Intent<T>) {
        val myIntent = Intent(context, routeInfo.clazz)
        context.startActivity(myIntent)
    }

}