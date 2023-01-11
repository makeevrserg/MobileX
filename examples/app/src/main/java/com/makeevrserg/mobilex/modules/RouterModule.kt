package com.makeevrserg.mobilex.modules

import com.github.terrakok.cicerone.Router
import com.makeevrserg.mobile.di_container.IModule

object RouterModule: IModule<Router>() {
    override fun initializer(): Router {
        return CiceroneModule.value.router
    }
}