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
    namespace = "com.makeevrserg.mobilex.core_compose"
    dependencies {
        implementation(libs.androidx.lifecycle.runtime)
        implementation(libs.androidx.lifecycle.extensions)
        implementation(libs.androidx.lifecycle.viewModelCompose)
        implementation(libs.androidx.lifecycle.liveDataKtx)
        implementation(libs.androidx.lifecycle.extensions)
        implementation(libs.androidx.lifecycle.viewModelKtx)
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.compose.bom)
//        implementation("androidx.compose.material3:material3")
        implementation("androidx.compose.material:material")
    }
}
