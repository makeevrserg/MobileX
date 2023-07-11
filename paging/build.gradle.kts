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
                // Coroutines
                implementation(libs.kotlin.coroutines.core)
            }
        }
    }
}
android {
    namespace = "${projectInfo.group}.paging"
}
