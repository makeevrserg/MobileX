package com.makeevrserg.mobilex.shared

import com.makeevrserg.mobile.di_container.module
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual val platformProvider = module { getPlatform() }