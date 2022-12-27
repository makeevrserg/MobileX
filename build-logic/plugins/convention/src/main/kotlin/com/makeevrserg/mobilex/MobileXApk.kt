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

    val VERSION_NAME = "2.0.8"

    fun getCredential(project: Project, path: String): String {
        val properties: Properties = Properties()
        val inputStream: InputStream = project.rootProject.file("keys.properties").inputStream()
        properties.load(inputStream)
        return properties.getProperty(path)
    }
}


