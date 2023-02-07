import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("org.jetbrains.compose")
    id("compose-library-convention")
}
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Compose
                compileOnly(compose.foundation)
                // Local
                implementation(project(":uitext:uitext-core"))
                implementation(project(":uitext:uitext-mr"))
            }
        }
    }
}
android {
    namespace = "$APPLICATION_ID.uitext_compose"
}
