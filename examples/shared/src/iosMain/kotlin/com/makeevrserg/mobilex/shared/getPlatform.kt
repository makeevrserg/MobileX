package com.makeevrserg.mobilex.shared

import com.makeevrserg.mobilex.ktx_core.architecture.module
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

val platformProvider = module { getPlatform() }