package com.makeevrserg.mobilex.modules

import com.makeevrserg.mobile.di_container.IModule
import com.makeevrserg.mobile.di_container.getValue
import com.makeevrserg.mobilex.CiceroneRouter

class CiceroneRouterModule: IModule<AndroidRouter>() {
    override fun initializer(): AndroidRouter {
        val router by RouterModule
        return CiceroneRouter(router)
    }
}


