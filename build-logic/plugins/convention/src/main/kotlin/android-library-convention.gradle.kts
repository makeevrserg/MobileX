import com.makeevrserg.mobilex.MobileXApk

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = MobileXApk.COMPILE_SDK_VERSION
    defaultConfig {
        minSdk = MobileXApk.MIN_SDK_VERSION
        targetSdk = MobileXApk.TARGET_SDK_VERSION
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    packagingOptions {
        with(resources.excludes) {
            add("META-INF/*.kotlin_module")
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}