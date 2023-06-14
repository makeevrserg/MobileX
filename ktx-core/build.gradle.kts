@file:Suppress("UnusedPrivateMember")

plugins {
    id("kmm-library-convention")
    id("convention.publication")
    id("dokka-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Kotlin
                implementation(libs.kotlin.tooling.core)
                implementation(libs.kotlin.gradle)
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
