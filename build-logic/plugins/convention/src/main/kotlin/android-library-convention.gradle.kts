import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.named

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}
group = libs.versions.library.group.get()
version = libs.versions.library.version.string.get()

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }
    sourceSets{
        val androidMain by getting
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