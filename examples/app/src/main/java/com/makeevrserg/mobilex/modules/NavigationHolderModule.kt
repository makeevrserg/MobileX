package com.makeevrserg.mobilex.modules

import com.github.terrakok.cicerone.NavigatorHolder
import com.makeevrserg.mobile.di_container.IModule

object NavigationHolderModule : IModule<NavigatorHolder>() {
    override fun initializer(): NavigatorHolder {
        return CiceroneModule.value.getNavigatorHolder()
    }
}