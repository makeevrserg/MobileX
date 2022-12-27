plugins {
    id("kmm-library-convention")
}

kotlin {
    sourceSets {
        val androidMain by getting
    }
}
android {
    namespace = "com.makeevrserg.mobilex.android_core"
    dependencies {
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.google.android.material)

        implementation(libs.kotlin.coroutines.core)
        implementation(libs.androidx.viewbinding)
        implementation(libs.androidx.lifecycle.viewModelKtx)
        implementation(libs.androidx.lifecycle.runtime)

        implementation(project(":ktx-core"))
    }
}

