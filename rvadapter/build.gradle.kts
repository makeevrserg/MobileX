

@file:Suppress("UnusedPrivateMember")

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
        val androidMain by getting {
            dependencies {
                // RecyclerView
                implementation(libs.android.recyclerview)
            }
        }
    }
}

android {
    namespace = "${libs.versions.project.group.get()}.rvadapter"
    buildFeatures.viewBinding = true
}
