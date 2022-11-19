package com.makeevrserg.mobilex.modules

import com.github.terrakok.cicerone.Router
import com.makeevrserg.mobilex.ktx_core.architecture.IModule

object RouterModule: IModule<Router>() {
    override fun initializer(): Router {
        return CiceroneModule.value.router
    }
}