@file:Suppress("UnusedPrivateMember")

import ru.astrainteractive.gradleplugin.util.ProjectProperties.projectInfo


plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    targetHierarchy.default()
    // android
    androidTarget()
    // jvm
    jvm()
    // ios
    ios()
    iosSimulatorArm64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Kotlin
                implementation(libs.kotlin.tooling.core)
                // Coroutines
                implementation(libs.kotlin.coroutines.core)
            }
        }
        val androidMain by getting {
            dependencies {
                // Android core
                implementation(libs.androidx.core.ktx)
            }
        }
    }
}

android {
    namespace = "${projectInfo.group}.ktxcore"
}
