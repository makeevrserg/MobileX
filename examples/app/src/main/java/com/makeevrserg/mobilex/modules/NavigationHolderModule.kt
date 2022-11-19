package com.makeevrserg.mobilex.modules

import com.github.terrakok.cicerone.NavigatorHolder
import com.makeevrserg.mobilex.ktx_core.architecture.IModule

object NavigationHolderModule : IModule<NavigatorHolder>() {
    override fun initializer(): NavigatorHolder {
        return CiceroneModule.value.getNavigatorHolder()
    }
}