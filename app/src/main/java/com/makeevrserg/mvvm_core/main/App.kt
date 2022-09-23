package com.makeevrserg.mvvm_core.main

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

class App : Application() {
    companion object {
        lateinit var cicerone: Cicerone<Router>
            private set
        lateinit var router: Router
            private set
        lateinit var navigatorHolder: NavigatorHolder
            private set

    }

    override fun onCreate() {
        super.onCreate()
        cicerone = Cicerone.create()
        router = cicerone.router
        navigatorHolder = cicerone.getNavigatorHolder()


    }
}