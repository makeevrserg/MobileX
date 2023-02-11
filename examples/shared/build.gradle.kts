import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID
plugins {
    id("kmm-library-convention")
}
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":ktx-core"))
                implementation(project(":service-locator"))
            }
        }
    }

}
android {
    namespace = "$APPLICATION_ID.shared"
}