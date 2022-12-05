package com.makeevrserg.mobilex.shared

import com.makeevrserg.mobilex.ktx_core.architecture.module

class DesktopPlatform : Platform {
    override val name: String = "Desktop ${System.getProperty("os.name")}"
}

actual fun getPlatform(): Platform = DesktopPlatform()

val platformProvider = module { getPlatform() }