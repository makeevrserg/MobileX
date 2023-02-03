package com.makeevrserg.mobilex.modules

import com.github.terrakok.cicerone.Cicerone
import com.makeevrserg.mobile.di_container.getValue
import com.makeevrserg.mobile.di_container.module

object Modules {
    val cicerone = module {
        Cicerone.create()
    }
    val navigationHolder = module {
        val cicerone by cicerone
        cicerone.getNavigatorHolder()
    }
    val ciceroneRouter = module {
        val cicerone by cicerone
        cicerone.router
    }
}