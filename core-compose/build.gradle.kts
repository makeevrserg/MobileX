plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.makeevrserg.mobilex.core_compose"
    compileSdk = Dependencies.compileSdkVersion

    defaultConfig {
        minSdk = Dependencies.minSdkVersion
        targetSdk = Dependencies.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled= false
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
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.compose_kotlinCompilerExtensionVersion
    }

}

dependencies {
    implementation("androidx.core:core-ktx:${Dependencies.Android.coreKTX}")
    implementation("androidx.appcompat:appcompat:${Dependencies.Android.androidxAppCompat}")
    implementation("com.google.android.material:material:${Dependencies.Android.androidMaterial}")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Dependencies.Kotlin.coroutines}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Dependencies.Android.lifecycle}")


    testImplementation("junit:junit:${Dependencies.Testing.jUnit}")
    androidTestImplementation("androidx.test.ext:junit:${Dependencies.Testing.extJunit}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Dependencies.Testing.espressoCore}")

    implementation("androidx.activity:activity-compose:${Dependencies.Compose.activityCompose}")
    implementation("androidx.compose.material:material:${Dependencies.Compose.composeMaterial}")
    implementation("androidx.compose.animation:animation:${Dependencies.Compose.composeAnimation}")
    implementation("androidx.compose.ui:ui-tooling:${Dependencies.Compose.composeUiTooling}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${Dependencies.Compose.lifecycleViewModelCompose}")

    debugImplementation("androidx.compose.ui:ui-tooling:${Dependencies.Compose.composeUiTooling}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Dependencies.Compose.composeUiTooling}")


    implementation(project(":core"))
    implementation(project(":ktx-core"))
}
