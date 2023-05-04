import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}
group = libs.versions.library.group.get()
version = libs.versions.library.version.string.get()

kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    android() {
        publishLibraryVariants("release", "debug")
    }
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets{
        val commonMain by getting
        val androidMain by getting
        val jvmMain by getting
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
    compileSdk = libs.versions.library.sdk.compile.get().toInt()

    defaultConfig {
        minSdk = libs.versions.library.sdk.min.get().toInt()
        targetSdk = libs.versions.library.sdk.target.get().toInt()
    }
    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }
}