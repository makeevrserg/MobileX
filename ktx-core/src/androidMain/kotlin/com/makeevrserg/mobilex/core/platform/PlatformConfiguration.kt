package com.makeevrserg.mobilex.core.platform

import android.content.Context

actual interface PlatformConfiguration {
    val applicationContext: Context
    actual val type: PlatformConfigurationType
}
