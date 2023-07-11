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
    namespace = "${projectInfo.group}.rvadapter"
    buildFeatures.viewBinding = true
}
