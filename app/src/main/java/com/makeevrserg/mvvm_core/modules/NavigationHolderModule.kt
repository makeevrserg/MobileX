package com.makeevrserg.mvvm_core.modules

import com.github.terrakok.cicerone.NavigatorHolder
import com.makeevrserg.mvvmcore.core.architecture.IModule

object NavigationHolderModule:IModule<NavigatorHolder>() {
    override fun initializer(): NavigatorHolder {
        return CiceroneModule.value.getNavigatorHolder()
    }
}