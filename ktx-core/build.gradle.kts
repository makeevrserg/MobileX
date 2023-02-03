import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("kmm-library-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlin.coroutines.core)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.google.android.material)
                implementation(libs.androidx.core.ktx)
            }
        }
    }
}

android {
    namespace = "$APPLICATION_ID.ktx_core"
}
