
plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = libs.versions.library.sdk.compile.get().toInt()

    defaultConfig {
        minSdk = libs.versions.library.sdk.min.get().toInt()
        targetSdk = libs.versions.library.sdk.target.get().toInt()
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