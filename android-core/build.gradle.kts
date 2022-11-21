plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("convention.publication")
}

group = Dependencies.group
version = Dependencies.version
kotlin{
    android(){
        publishLibraryVariants("release", "debug")
    }

    sourceSets {

        val androidMain by getting {

        }
    }
}
android {
    namespace = "com.makeevrserg.mobilex.android_core"
    compileSdk = Dependencies.compileSdkVersion

    defaultConfig {
        minSdk = Dependencies.minSdkVersion
        targetSdk = Dependencies.targetSdkVersion
    }
    sourceSets {
        named("main") {
            manifest.srcFile("src/main/AndroidManifest.xml")
            res.srcDirs("src/main/res", "src/main/resources")
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
}

