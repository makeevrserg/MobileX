plugins {
    id("kmm-library-convention")
}

kotlin {
    sourceSets {
        val androidMain by getting
    }
}
android {
    namespace = "com.makeevrserg.mobilex.rvadapter"
    buildFeatures.viewBinding = true
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.android.material)
    implementation(libs.androidx.constraintlayout.android)
    implementation(libs.androidx.cicerone)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.activity.core)
    implementation(libs.androidx.fragment.core)

    implementation(libs.kotlin.coroutines.core)
    implementation(libs.androidx.viewbinding)
    implementation(libs.androidx.lifecycle.viewModelKtx)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.activity.core)
    implementation(libs.androidx.fragment.core)

    implementation(project(":ktx-core"))
}

