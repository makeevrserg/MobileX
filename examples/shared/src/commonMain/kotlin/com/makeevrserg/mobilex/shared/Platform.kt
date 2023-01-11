package com.makeevrserg.mobilex.shared

import com.makeevrserg.mobile.di_container.IModule

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect val platformProvider: IModule<Platform>