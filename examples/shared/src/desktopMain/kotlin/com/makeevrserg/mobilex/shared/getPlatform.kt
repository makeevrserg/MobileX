package com.makeevrserg.mobilex.shared

import com.makeevrserg.mobile.di_container.module


class DesktopPlatform : Platform {
    override val name: String = "Desktop ${System.getProperty("os.name")}"
}

actual fun getPlatform(): Platform = DesktopPlatform()

actual val platformProvider = module { getPlatform() }