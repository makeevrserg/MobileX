import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("kmm-library-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Moko
                compileOnly(libs.moko.resources.core)
                // Local
                implementation(project(":uitext:uitext-core"))
            }
        }
    }
}
android {
    namespace = "$APPLICATION_ID.utiext_mr"
}
