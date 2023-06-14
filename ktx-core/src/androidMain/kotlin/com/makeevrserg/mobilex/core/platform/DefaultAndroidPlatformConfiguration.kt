package com.makeevrserg.mobilex.core.platform

import android.content.Context

class DefaultAndroidPlatformConfiguration(override val applicationContext: Context) : PlatformConfiguration {
    override val type: PlatformConfigurationType
        get() = PlatformConfigurationType.ANDROID
}
