import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("kmm-library-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Coroutines
                compileOnly(libs.kotlin.coroutines.core)
            }
        }
    }

}
android {
    namespace = "$APPLICATION_ID.paging"
}
