import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("kmm-library-convention")
    id("convention.publication")
}
kotlin {
    sourceSets {
        val androidMain by getting {
            dependencies {
                dependencies {
                    implementation(libs.google.android.material)
                    implementation(libs.androidx.core.ktx)
                }
            }
        }
    }
}
android {
    namespace = "$APPLICATION_ID.utiext_core"
}
