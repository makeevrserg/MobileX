plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.makeevrserg.mobilex"
    compileSdk = Dependencies.compileSdkVersion

    defaultConfig {
        applicationId = "com.makeevrserg.mobilex"
        minSdk = Dependencies.minSdkVersion
        targetSdk = Dependencies.targetSdkVersion
        versionCode = 1
        versionName = Dependencies.version

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
    buildFeatures {
        viewBinding= true
        compose= true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.compose_kotlinCompilerExtensionVersion
    }
}

dependencies {

    implementation("androidx.core:core-ktx:${Dependencies.Android.coreKTX}")
    implementation("androidx.appcompat:appcompat:${Dependencies.Android.androidxAppCompat}")
    implementation("com.google.android.material:material:${Dependencies.Android.androidMaterial}")
    implementation("androidx.constraintlayout:constraintlayout:${Dependencies.Android.constraintLayout}")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Dependencies.Kotlin.coroutines}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Dependencies.Android.lifecycleViewModel}")

    implementation("com.github.terrakok:cicerone:${Dependencies.Android.cicerone}")

    testImplementation("junit:junit:${Dependencies.Testing.jUnit}")
    androidTestImplementation("androidx.test.ext:junit:${Dependencies.Testing.extJunit}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Dependencies.Testing.espressoCore}")
//    implementation "com.github.makeevrserg:MVVM-core:1.0.1"
    implementation("ru.astrainteractive.mobilex:ktx-core:${Dependencies.versionDep}")
    implementation("ru.astrainteractive.mobilex:core-compose:${Dependencies.versionDep}")
//    implementation("ru.astrainteractive.mobilex:android-core:${Dependencies.versionDep}")
    implementation(project(":android-core"))

    // compose
    implementation("androidx.activity:activity-compose:${Dependencies.Compose.activityCompose}")
    implementation("androidx.compose.material:material:${Dependencies.Compose.composeMaterial}")
    implementation("androidx.compose.animation:animation:${Dependencies.Compose.composeAnimation}")
    implementation("androidx.compose.ui:ui-tooling:${Dependencies.Compose.composeUiTooling}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${Dependencies.Compose.lifecycleViewModelCompose}")

    debugImplementation("androidx.compose.ui:ui-tooling:${Dependencies.Compose.composeUiTooling}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Dependencies.Compose.composeUiTooling}")


    implementation("com.google.accompanist:accompanist-navigation-animation:0.26.2-beta")
    implementation("androidx.navigation:navigation-compose:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")
}