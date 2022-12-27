import com.makeevrserg.mobilex.MobileXApk

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("import-convention")
}
kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    jvm("desktop")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":ktx-core"))
            }
        }
        val desktopMain by getting
        val androidMain by getting

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
    namespace = "com.makeevrserg.mobilex.shared"
    compileSdk = MobileXApk.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = MobileXApk.MIN_SDK_VERSION
        targetSdk = MobileXApk.TARGET_SDK_VERSION
    }
}