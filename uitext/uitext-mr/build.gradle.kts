import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("kmm-library-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":uitext:uitext-core"))
                api(libs.moko.resources.core)
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
    namespace = "$APPLICATION_ID.utiext_mr"
}
