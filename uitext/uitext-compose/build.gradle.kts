import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("org.jetbrains.compose")
    id("compose-library-convention")
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

                implementation(project(":uitext:uitext-core"))
                implementation(project(":uitext:uitext-mr"))


            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.lifecycle.runtime)
                implementation(libs.androidx.lifecycle.extensions)
                implementation(libs.androidx.lifecycle.viewModelCompose)
                implementation(libs.androidx.lifecycle.liveDataKtx)
                implementation(libs.androidx.lifecycle.extensions)
                implementation(libs.androidx.lifecycle.viewModelKtx)
                implementation(libs.androidx.core.ktx)
            }
        }
    }
}
android {
    namespace = "$APPLICATION_ID.uitext_compose"
}
