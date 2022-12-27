plugins {
    id("org.jetbrains.compose")
    id("kmm-library-convention")
}
kotlin {
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
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(project(":android-core"))
            }
        }
    }
}
android {
    namespace = "com.makeevrserg.mobilex.core_compose"
    dependencies {
        implementation(libs.coil)
    }
}