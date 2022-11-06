plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace ="com.makeevrserg.mvvmcore.core"
    compileSdk = Dependencies.compileSdkVersion

    defaultConfig {
        minSdk = Dependencies.minSdkVersion
        targetSdk = Dependencies.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

dependencies {
    implementation("androidx.core:core-ktx:${Dependencies.Android.coreKTX}")
    implementation("androidx.appcompat:appcompat:${Dependencies.Android.androidxAppCompat}")
    implementation("com.google.android.material:material:${Dependencies.Android.androidMaterial}")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Dependencies.Kotlin.coroutines}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Dependencies.Android.lifecycle}")


    implementation("androidx.databinding:viewbinding:${Dependencies.Android.viewBinding}")

    testImplementation("junit:junit:${Dependencies.Testing.jUnit}")
    androidTestImplementation("androidx.test.ext:junit:${Dependencies.Testing.extJunit}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Dependencies.Testing.espressoCore}")
    implementation(project(":ktx-core"))
}