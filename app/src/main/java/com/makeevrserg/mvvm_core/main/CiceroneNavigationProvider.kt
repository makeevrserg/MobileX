package com.makeevrserg.mvvm_core.main

import android.content.Context
import android.content.Intent
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.makeevrserg.mvvmcore.core.routing.IRouter
import com.makeevrserg.mvvmcore.core.routing.RouteInfo

class CiceroneNavigationProvider(private val router: Router) : IRouter<FragmentScreen> {
    override val isBackStackEmpty: Boolean
        get() = true

    override fun popBack() {
        router.exit()
    }

    override fun <K : FragmentScreen> clearBackStack(screen: K) {
        router.newRootChain(screen as FragmentScreen)
    }

    override fun <K : FragmentScreen> replaceScreen(screen: K) {
        router.replaceScreen(screen as FragmentScreen)
    }

    override fun <K : FragmentScreen> nextScreen(screen: K) {
        router.navigateTo(screen as FragmentScreen)
    }


    override fun <T> intent(context: Context, routeInfo: RouteInfo.Intent<T>) {
        val myIntent = Intent(context, routeInfo.clazz)
        context.startActivity(myIntent)
    }

}