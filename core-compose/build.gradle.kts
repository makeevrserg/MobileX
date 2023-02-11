import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("org.jetbrains.compose")
    id("compose-library-convention")
    id("convention.publication")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Compose
                compileOnly(compose.foundation)
                compileOnly(compose.ui)
                compileOnly(compose.material)
                compileOnly(compose.materialIconsExtended)
                compileOnly(compose.runtime)
                compileOnly(compose.preview)
                compileOnly(compose.uiTooling)
                // Local
                implementation(project(":ktx-core"))
                implementation(project(":service-locator"))
                implementation(project(":mvi:mvi-core"))
                implementation(project(":paging"))


            }
        }
        val androidMain by getting {
            dependencies {
                // Lifecycle
                compileOnly(libs.androidx.lifecycle.runtime)
                compileOnly(libs.androidx.lifecycle.extensions)
                compileOnly(libs.androidx.lifecycle.viewModelCompose)
                compileOnly(libs.androidx.lifecycle.liveDataKtx)
                compileOnly(libs.androidx.lifecycle.extensions)
                compileOnly(libs.androidx.lifecycle.viewModelKtx)
                compileOnly(libs.androidx.core.ktx)
            }
        }
    }
}

android {
    namespace = "$APPLICATION_ID.core_compose"
    dependencies {
        // Lifecycle
        compileOnly(libs.androidx.lifecycle.runtime)
        compileOnly(libs.androidx.lifecycle.extensions)
        compileOnly(libs.androidx.lifecycle.viewModelCompose)
        compileOnly(libs.androidx.lifecycle.liveDataKtx)
        compileOnly(libs.androidx.lifecycle.extensions)
        compileOnly(libs.androidx.lifecycle.viewModelKtx)
        compileOnly(libs.androidx.core.ktx)

    }
}
