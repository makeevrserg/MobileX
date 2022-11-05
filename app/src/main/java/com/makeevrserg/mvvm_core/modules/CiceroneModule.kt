package com.makeevrserg.mvvm_core.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.makeevrserg.mvvm_core.ktx_core.architecture.IModule

object CiceroneModule: IModule<Cicerone<Router>>() {
    override fun initializer(): Cicerone<Router> {
        return Cicerone.create()
    }
}