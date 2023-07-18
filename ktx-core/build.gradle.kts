@file:Suppress("UnusedPrivateMember")

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    targetHierarchy.default()
    // android
    androidTarget {
        publishLibraryVariants("release", "debug")
        publishLibraryVariantsGroupedByFlavor = true
    }
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
    namespace = "${libs.versions.project.group.get()}.ktxcore"
}
