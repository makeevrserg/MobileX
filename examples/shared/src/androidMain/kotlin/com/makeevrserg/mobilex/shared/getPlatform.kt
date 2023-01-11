package com.makeevrserg.mobilex.shared

import com.makeevrserg.mobile.di_container.getValue
import com.makeevrserg.mobile.di_container.module

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual val platformProvider = module { getPlatform() }

class SharedClass {
    private val provider by platformProvider
    val platformString = provider.name

}