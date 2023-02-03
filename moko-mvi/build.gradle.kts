import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("kmm-library-convention")
}

val mokoMvvm = "0.15.0"

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Core
                implementation(libs.kotlin.coroutines.core)
                // Moko
                implementation("dev.icerock.moko:mvvm-core:$mokoMvvm")
                implementation("dev.icerock.moko:mvvm-flow:$mokoMvvm")
                // Local
                implementation(project(":ktx-core"))
                implementation(project(":mvi"))
            }
        }
    }

}
android {
    namespace = "$APPLICATION_ID.moko_mvi"
}
