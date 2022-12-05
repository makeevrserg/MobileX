package com.makeevrserg.mobilex.shared

import com.makeevrserg.mobilex.ktx_core.architecture.getValue
import com.makeevrserg.mobilex.ktx_core.architecture.module

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

val platformProvider = module { getPlatform() }

class SharedClass {
    private val provider by platformProvider
    val platformString = provider.name

}