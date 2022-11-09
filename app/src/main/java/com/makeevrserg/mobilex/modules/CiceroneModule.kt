package com.makeevrserg.mobilex.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.makeevrserg.mobilex.ktx_core.architecture.IModule

object CiceroneModule: IModule<Cicerone<Router>>() {
    override fun initializer(): Cicerone<Router> {
        return Cicerone.create()
    }
}