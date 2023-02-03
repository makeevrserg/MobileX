import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("kmm-library-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Core
                implementation(libs.kotlin.coroutines.core)
                // Local
                implementation(project(":ktx-core"))
            }
        }
    }
}

android {
    namespace = "$APPLICATION_ID.mvi"
}
