plugins {
    id("kmm-library-convention")
}
val version = "4.5.0"
val mokoMvvm = "0.15.0"
kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlin.coroutines.core)
                implementation("org.orbit-mvi:orbit-core:$version")
                implementation("dev.icerock.moko:mvvm-core:$mokoMvvm")
                implementation("dev.icerock.moko:mvvm-flow:$mokoMvvm")
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies{
                implementation("org.orbit-mvi:orbit-viewmodel:$version")
            }
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
    namespace = "com.makeevrserg.mobilex.orbit_mvi"
}
