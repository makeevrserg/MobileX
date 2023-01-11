package com.makeevrserg.mobilex.modules

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import com.makeevrserg.mobile.di_container.IModule
import com.makeevrserg.mobile.di_container.getValue
import com.makeevrserg.mobilex.CiceroneRouter
import com.makeevrserg.mobilex.ktx_core.AndroidRouter
import com.makeevrserg.mobilex.ktx_core.action.components.RouteInfo

class CiceroneRouterModule: IModule<AndroidRouter>() {
    override fun initializer(): AndroidRouter {
        val router by RouterModule
        return CiceroneRouter(router)
    }
}


