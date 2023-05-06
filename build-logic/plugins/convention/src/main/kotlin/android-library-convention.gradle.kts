@file:Suppress("UnusedPrivateMember")

import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}
group = libs.versions.project.group.get()
version = libs.versions.project.version.string.get()
java {
    java.sourceCompatibility = JavaVersion.VERSION_11
    java.targetCompatibility = JavaVersion.VERSION_11
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.majorVersion
}
kotlin {
    android() {
        publishLibraryVariants("release", "debug")
    }
    sourceSets {
        val commonMain by getting
        val androidMain by getting
    }
}
android {
    compileSdk = libs.versions.project.sdk.compile.get().toInt()

    defaultConfig {
        minSdk = libs.versions.project.sdk.min.get().toInt()
        targetSdk = libs.versions.project.sdk.target.get().toInt()
    }
    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
