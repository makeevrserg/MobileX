import com.makeevrserg.mobilex.MobileXApk

plugins {
    id("android-app-convention")
}

android {
    namespace = "com.makeevrserg.mobilex"

    defaultConfig {
        applicationId = "com.makeevrserg.mobilex"
        versionCode = 1
        versionName = libs.versions.version.get()
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
    buildFeatures {
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
        kotlinCompilerVersion = "1.7.10"
    }
}

dependencies {

    // Kotlin core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.kotlin.coroutines.core)
    implementation(libs.androidx.lifecycle.viewModelKtx)
    // Navigation
    implementation(libs.androidx.cicerone)
    // Android
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.constraintlayout.android)
    implementation(libs.google.android.material)
    // Project
    implementation(project(":core-compose"))
    implementation(project(":ktx-core"))
    implementation(project(":mvi"))
    implementation(project(":paging"))
    implementation(project(":rvadapter"))
    implementation(project(":service-locator"))
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6")
    // Compose
    implementation(platform(libs.androidx.compose.bom))

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material:material-icons-core")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation(libs.androidx.lifecycle.viewModelCompose)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.google.accompanist.navigationAnimation)


    implementation(libs.androidx.lifecycle.viewModelKtx)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.fragment.core)
    implementation(libs.androidx.fragment.ktx)

}