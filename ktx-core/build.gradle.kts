import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("kmm-library-convention")
    id("convention.publication")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Coroutines
                compileOnly(libs.kotlin.coroutines.core)
                implementation(libs.androidx.core.ktx)
            }
        }
    }
}

android {
    namespace = "$APPLICATION_ID.ktx_core"
}
