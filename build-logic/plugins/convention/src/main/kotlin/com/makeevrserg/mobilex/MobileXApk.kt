package com.makeevrserg.mobilex

import org.gradle.api.Project
import java.io.InputStream
import java.util.Properties


object MobileXApk {
    const val APPLICATION_ID = "com.makeevrserg.mobilex"
    const val GROUP = "ru.astrainteractive.mobilex"
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 33
    const val COMPILE_SDK_VERSION = 33
    const val buildTools = "7.2.2"

    val VERSION_NAME = "2.0.7-local1"


    val Project.KEY_ALIAS: String
        get() = MobileXApk.getCredential(this, "KEY_ALIAS")
    val Project.KEY_PASSWORD: String
        get() = MobileXApk.getCredential(this, "KEY_PASSWORD")
    val Project.STORE_PASSWORD: String
        get() = MobileXApk.getCredential(this, "STORE_PASSWORD")

    val Project.WEB_CLIENT_ID: String
        get() = MobileXApk.getCredential(this, "WEB_CLIENT_ID")
    val Project.BANNER_AD_UNIT_ID: String
        get() = MobileXApk.getCredential(this, "BANNER_AD_UNIT_ID")
    val Project.ACTIVITY_AD_UNIT_ID: String
        get() = MobileXApk.getCredential(this, "ACTIVITY_AD_UNIT_ID")
    val Project.INTERSITIAL_AD_UNIT_ID: String
        get() = MobileXApk.getCredential(this, "INTERSITIAL_AD_UNIT_ID")

    fun getCredential(project: Project, path: String): String {
        val properties: Properties = Properties()
        val inputStream: InputStream = project.rootProject.file("keys.properties").inputStream()
        properties.load(inputStream)
        return properties.getProperty(path)
    }
}


