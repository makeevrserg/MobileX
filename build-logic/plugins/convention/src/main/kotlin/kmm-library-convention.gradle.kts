import com.makeevrserg.mobilex.MobileXApk
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.project

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("convention.publication")
}
group = MobileXApk.GROUP
version = MobileXApk.VERSION_NAME

kotlin {
    android() {
        publishLibraryVariants("release", "debug")
    }
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
}
android {
    compileSdk = MobileXApk.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = MobileXApk.MIN_SDK_VERSION
        targetSdk = MobileXApk.TARGET_SDK_VERSION
    }
    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }
}