
plugins {
    id("kmm-library-convention")
    id("convention.publication")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Coroutines
                implementation(libs.kotlin.coroutines.core)
            }
        }
        val androidMain by getting {
            dependencies {
                // Android core
                implementation(libs.androidx.core.ktx)
            }
        }
    }
}

android {
    namespace = "${libs.versions.library.group.get()}.ktxcore"
}
