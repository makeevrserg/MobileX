package com.makeevrserg.mobilex.shared

import com.makeevrserg.mobilex.ktx_core.architecture.IModule

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect val platformProvider: IModule<Platform>