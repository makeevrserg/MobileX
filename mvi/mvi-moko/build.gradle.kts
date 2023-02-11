import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("kmm-library-convention")
    id("convention.publication")
}

val mokoMvvm = "0.15.0"

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Coroutines
                compileOnly(libs.kotlin.coroutines.core)
                // Moko
                compileOnly("dev.icerock.moko:mvvm-core:$mokoMvvm")
                compileOnly("dev.icerock.moko:mvvm-flow:$mokoMvvm")
                // Local
                implementation(project(":ktx-core"))
                implementation(project(":mvi:mvi-core"))
            }
        }
    }

}
android {
    namespace = "$APPLICATION_ID.moko_mvi"
}
