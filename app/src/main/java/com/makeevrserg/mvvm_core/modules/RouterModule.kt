package com.makeevrserg.mvvm_core.modules

import com.github.terrakok.cicerone.Router
import com.makeevrserg.mvvm_core.ktx_core.architecture.IModule

object RouterModule: IModule<Router>() {
    override fun initializer(): Router {
        return CiceroneModule.value.router
    }
}