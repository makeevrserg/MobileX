plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}
kotlin {
    android() {
//        apply(plugin = "kotlin-parcelize")
    }
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.material)
                implementation(compose.materialIconsExtended)
                implementation(compose.runtime)
                implementation(compose.preview)
                implementation(compose.uiTooling)
                implementation(project(":ktx-core"))


            }
        }
        val desktopMain by getting{
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
        val androidMain by getting{
            dependencies{
                implementation(project(":core"))
            }
        }
    }
}
android {
    namespace = "com.makeevrserg.mobilex.core_compose"
    compileSdk = Dependencies.compileSdkVersion

    defaultConfig {
        minSdk = Dependencies.minSdkVersion
        targetSdk = Dependencies.targetSdkVersion
    }
    dependencies {
        implementation("io.coil-kt:coil-compose:2.2.2")
    }
}

//dependencies {
//    implementation("androidx.core:core-ktx:${Dependencies.Android.coreKTX}")
//    implementation("androidx.appcompat:appcompat:${Dependencies.Android.androidxAppCompat}")
//    implementation("com.google.android.material:material:${Dependencies.Android.androidMaterial}")
//
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Dependencies.Kotlin.coroutines}")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Dependencies.Android.lifecycle}")
//
//
//    testImplementation("junit:junit:${Dependencies.Testing.jUnit}")
//    androidTestImplementation("androidx.test.ext:junit:${Dependencies.Testing.extJunit}")
//    androidTestImplementation("androidx.test.espresso:espresso-core:${Dependencies.Testing.espressoCore}")
//
//    implementation("androidx.activity:activity-compose:${Dependencies.Compose.activityCompose}")
//    implementation("androidx.compose.material:material:${Dependencies.Compose.composeMaterial}")
//    implementation("androidx.compose.animation:animation:${Dependencies.Compose.composeAnimation}")
//    implementation("androidx.compose.ui:ui-tooling:${Dependencies.Compose.composeUiTooling}")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${Dependencies.Compose.lifecycleViewModelCompose}")
//
//    debugImplementation("androidx.compose.ui:ui-tooling:${Dependencies.Compose.composeUiTooling}")
//    implementation("androidx.compose.ui:ui-tooling-preview:${Dependencies.Compose.composeUiTooling}")
//
//
//
//
//}
