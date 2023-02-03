package com.makeevrserg.mobilex.shared

import com.makeevrserg.mobile.di_container.Module

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect val platformProvider: Module<Platform>