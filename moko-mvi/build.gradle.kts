plugins {
    id("kmm-library-convention")
}

val mokoMvvm = "0.15.0"
kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlin.coroutines.core)
                implementation(project(":ktx-core"))
                implementation(project(":mvi"))
                implementation("dev.icerock.moko:mvvm-core:$mokoMvvm")
                implementation("dev.icerock.moko:mvvm-flow:$mokoMvvm")
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
        }
        val jvmMain by getting {
            dependsOn(commonMain)
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }

}
android {
    namespace = "com.makeevrserg.mobilex.moko_mvi"
}
