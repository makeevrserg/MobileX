package com.makeevrserg.mvvm_core.modules

import com.github.terrakok.cicerone.NavigatorHolder
import com.makeevrserg.mvvm_core.ktx_core.architecture.IModule

object NavigationHolderModule : IModule<NavigatorHolder>() {
    override fun initializer(): NavigatorHolder {
        return CiceroneModule.value.getNavigatorHolder()
    }
}